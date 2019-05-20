package ir.tokaterm.tokaterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private TextView search_tv;
    private Button search_btn;
    private RecyclerView search_recyclerView;

    List<Data_Mode_product_cat_list> itemList=new ArrayList<>();
    Item_Adapter_product_cat_list item_adapter;

    ApiInterface apiInterface;

    private ArrayList<Product> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_tv=findViewById(R.id.search_tv);
        search_btn=findViewById(R.id.search_btn);
        search_recyclerView=findViewById(R.id.search_recyclerView);

        apiInterface=Api.getApi().create(ApiInterface.class);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_tv.getText().toString().equals("")){

                    Toast.makeText(SearchActivity.this,"لطفا نام محصول مورد نظر را وارد کنید .", Toast.LENGTH_SHORT).show();

                }else{
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    String word=search_tv.getText().toString();
                    item_adapter=new Item_Adapter_product_cat_list(itemList,getApplicationContext());
                    RecyclerView.LayoutManager rlm=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    search_recyclerView.setLayoutManager(rlm);
                    search_recyclerView.setItemAnimator(new DefaultItemAnimator());
                    search_recyclerView.setHasFixedSize(true);
                    search_recyclerView.setAdapter(item_adapter);
                    set_data_search(word);

                }
            }
        });

    }

    private void set_data_search(String word){
         itemList.clear();
        Call<ProductArray> callProduct=apiInterface.search_listCall(word);

        callProduct.enqueue(new Callback<ProductArray>() {
            @Override
            public void onResponse(Call<ProductArray> call, Response<ProductArray> response) {

                ProductArray jsonResponce=response.body();
                data=new ArrayList<>(Arrays.asList(jsonResponce.getObj1()));
                if(data.size()<=0)
                    Toast.makeText(SearchActivity.this, "هیچ نتیجه ای یافت نشد !!!", Toast.LENGTH_SHORT).show();
                for(int i=0;i<data.size();i++){
                    itemList.add(new Data_Mode_product_cat_list(data.get(i).getApiproduct_id(),
                            data.get(i).getApiImageUrl(), data.get(i).getApiTitle(),data.get(i).getApiprice(),
                            data.get(i).getApiOffPercentage()));
                }
                item_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductArray> call, Throwable t) {

                Toast.makeText(SearchActivity.this,"error", Toast.LENGTH_SHORT).show();

            }
        });



    }

}
