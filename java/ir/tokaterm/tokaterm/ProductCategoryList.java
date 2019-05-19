package ir.tokaterm.tokaterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCategoryList extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<Product> data;

    RecyclerView product_cat_list_recycler;
    List<Data_Mode_product_cat_list> itemlist_product_cat_list=new ArrayList<>();
    Item_Adapter_product_cat_list product_cat_list_Adapter;
    List<Data_Mode_product_cat_list> itemListCategory=new ArrayList<>();
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category_list);
        toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        category=getIntent().getExtras().getString("category");

//       ViewPageAdapter vpAdapter=new ViewPageAdapter(getSupportFragmentManager());

        //********** START recyclerview for product category list
        product_cat_list_recycler=findViewById(R.id.product_cat_list_recyclerview);
        product_cat_list_Adapter=new Item_Adapter_product_cat_list(itemlist_product_cat_list,this);
        RecyclerView.LayoutManager plm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);
        product_cat_list_recycler.setLayoutManager(plm);
      //  RecyclerView.ItemDecoration idecoretion=new DividerItemDecoration(this,
        //        DividerItemDecoration.VERTICAL);
       // product_cat_list_recycler.addItemDecoration(idecoretion);
        product_cat_list_recycler.setItemAnimator(new DefaultItemAnimator());
        product_cat_list_recycler.setHasFixedSize(true);
        product_cat_list_recycler.setAdapter(product_cat_list_Adapter);

        setDataProduct_cat_list(category);
       // Toast.makeText(this, category, Toast.LENGTH_LONG).show();

        //**********END recyclerview for product category list


   }

    private void setDataProduct_cat_list(String category){


        if(category.equals("sales_number")||category.equals("view_number")){

            final  Call<ProductArray> productArrayCall=MainActivity.apiInterface.best_seller_listCall(category);
            productArrayCall.enqueue(new Callback<ProductArray>() {
                @Override
                public void onResponse(Call<ProductArray> call, Response<ProductArray> response) {

                    ProductArray jsonresponse=response.body();
                    data=new ArrayList<>(Arrays.asList(jsonresponse.getObj1()));
                    if(data.size()>0){
                        for(int i=0;i<data.size();i++){
                            itemlist_product_cat_list.add(new Data_Mode_product_cat_list(data.get(i).getApiproduct_id(),
                                    data.get(i).getApiImageUrl(), data.get(i).getApiTitle(),data.get(i).getApiprice(),
                                    data.get(i).getApiOffPercentage()));
                        }
                    }else{
                        Toast.makeText(ProductCategoryList.this,"موجودی 0 !!!", Toast.LENGTH_LONG).show();
                        finish();

                    }
                    product_cat_list_Adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ProductArray> call, Throwable t) {
                    Toast.makeText(ProductCategoryList.this, t+"", Toast.LENGTH_LONG).show();


                }
            });

        }else if(category.equals("specialOffer")||category.equals("newest")){
            final  Call<ProductArray> productArrayCall=MainActivity.apiInterface.wonderfulListCall(category);
            productArrayCall.enqueue(new Callback<ProductArray>() {
                @Override
                public void onResponse(Call<ProductArray> call, Response<ProductArray> response) {

                    ProductArray jsonresponse=response.body();
                    data=new ArrayList<>(Arrays.asList(jsonresponse.getObj1()));
                    if(data.size()>0){
                        for(int i=0;i<data.size();i++){
                            itemlist_product_cat_list.add(new Data_Mode_product_cat_list(data.get(i).getApiproduct_id(),
                                    data.get(i).getApiImageUrl(), data.get(i).getApiTitle(),data.get(i).getApiprice(),
                                    data.get(i).getApiOffPercentage()));
                        }
                    }else{
                        Toast.makeText(ProductCategoryList.this,"موجودی 0 !!!", Toast.LENGTH_LONG).show();
                        finish();

                    }
                    product_cat_list_Adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ProductArray> call, Throwable t) {
                    Toast.makeText(ProductCategoryList.this, t+"", Toast.LENGTH_LONG).show();


                }
            });

        } else{
            final  Call<ProductArray> productArrayCall=MainActivity.apiInterface.product_category_listCall(category);
            productArrayCall.enqueue(new Callback<ProductArray>() {
                @Override
                public void onResponse(Call<ProductArray> call, Response<ProductArray> response) {

                    ProductArray jsonresponse=response.body();
                    data=new ArrayList<>(Arrays.asList(jsonresponse.getObj1()));
                    if(data.size()>0){
                        for(int i=0;i<data.size();i++){
                            itemlist_product_cat_list.add(new Data_Mode_product_cat_list(data.get(i).getApiproduct_id(),
                                    data.get(i).getApiImageUrl(), data.get(i).getApiTitle(),data.get(i).getApiprice(),
                                    data.get(i).getApiOffPercentage()));
                        }
                    }else{
                        Toast.makeText(ProductCategoryList.this,"موجودی 0 !!!", Toast.LENGTH_LONG).show();
                        finish();

                    }
                    product_cat_list_Adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ProductArray> call, Throwable t) {
                    Toast.makeText(ProductCategoryList.this, t+"", Toast.LENGTH_LONG).show();


                }
            });
        }



    }
}
