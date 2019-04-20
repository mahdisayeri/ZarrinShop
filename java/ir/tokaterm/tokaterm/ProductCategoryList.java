package ir.tokaterm.tokaterm;

import android.graphics.Paint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryList extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    RecyclerView product_cat_list_recycler;
    List<Data_Mode_product_cat_list> itemlist_product_cat_list=new ArrayList<>();
    Item_Adapter_product_cat_list product_cat_list_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category_list);
        toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

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
        setDataProduct_cat_list();

        //**********END recyclerview for product category list


   }

    private void setDataProduct_cat_list(){

        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرت",R.drawable.dbt1));
        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرت",R.drawable.dbt2));
        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرت ",R.drawable.dbt3));

        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرتا",R.drawable.dbt4));
        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرت",R.drawable.dbt5));
        itemlist_product_cat_list.add(new Data_Mode_product_cat_list("دستبند طلا اسپرت ",R.drawable.dbt6));


    }
}
