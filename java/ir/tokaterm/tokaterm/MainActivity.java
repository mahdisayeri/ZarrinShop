package ir.tokaterm.tokaterm;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

   private Toolbar toolbar;
   private DrawerLayout drawerLayout;
   private NavigationView navigationView;

   SliderLayout sliderLayout;

    RecyclerView recyclerView,wonderRecycler,product_cat_list_recycler;


    List<Data_Model_category> itemList=new ArrayList<>();
    ItemAdapter_category madapter;
    List<Data_Model_wonderful_list> itemListwonder=new ArrayList<>();
    ItemAdapter_wonderful_list wonderAdapter;

    List<Data_Mode_product_cat_list> itemlist_product_cat_list=new ArrayList<>();
    Item_Adapter_product_cat_list product_cat_list_Adapter;

    private CountDownTimer countDownTimer;
    private TextView cdtTV;

    public static ApiInterface apiInterface;

    private ArrayList<Product> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=Api.getApi().create(ApiInterface.class);


        //START*************************COUNT DOWN TIMER********************

        cdtTV=findViewById(R.id.countdowntv);
        int minutes =1221;
        int milliseconds=minutes*60*1000;

        countDownTimer=new CountDownTimer(milliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                cdtTV.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)-
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished))
                        ,TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                ));
            }

            @Override
            public void onFinish() {
                cdtTV.setText("Amazing Time Down!" );
            }
        };

        countDownTimer.start();

        //END*************************COUNT DOWN TIMER********************




        //  SLIDER
     sliderLayout=findViewById(R.id.imageSlider_sliderLayout);
     sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
     sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
     sliderLayout.setScrollTimeInSec(5);
     setSliderViews();

    // END SLIDER

     //START NAVIGATION VIEW
     toolbar=findViewById(R.id.main_toolbar);
    setSupportActionBar(toolbar);

    drawerLayout=findViewById(R.id.main_drawerLayout);
    navigationView=findViewById(R.id.main_navigation_view);

        final ActionBarDrawerToggle atoggloe=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,
                R.string.close);
        navigationView.setNavigationItemSelectedListener(this);
        // atoggloe.getDrawerArrowDrawable().setColor(getColor(R.color.tooglemenu));
        drawerLayout.addDrawerListener(atoggloe);
        atoggloe.syncState();

        View headeview=navigationView.getHeaderView(0);
        TextView login=headeview.findViewById(R.id.nav_header_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
               Intent main2=new Intent(MainActivity.this, Main_log_regActivity.class);
                startActivity(main2);
            }
        });




     //END NAVIGATION VIEW

    //**************************************
        recyclerView=findViewById(R.id.first_layout_recyclerView1);
        madapter=new ItemAdapter_category(itemList,this);
        RecyclerView.LayoutManager mlayoutmanager=new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mlayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(madapter);
        setData();
    //****************************************
        wonderRecycler=findViewById(R.id.first_layout_wonderful_recyclerView);
        wonderAdapter=new ItemAdapter_wonderful_list(itemListwonder,this);
        RecyclerView.LayoutManager wlm=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        wonderRecycler.setLayoutManager(wlm);
        wonderRecycler.setItemAnimator(new DefaultItemAnimator());
        wonderRecycler.setHasFixedSize(true);
        wonderRecycler.setAdapter(wonderAdapter);
        setDataWonderful();
    }


    private void setSliderViews(){

      for(int i=0;i<=3;i++){

          DefaultSliderView sliderView=new DefaultSliderView(this);
          switch (i){
              case 0:
                  sliderView.setImageUrl("https://www.digizargar.com/new/images/Kids.jpeg");
                  break;
              case 1:
                  sliderView.setImageUrl("https://www.digizargar.com/new/images/weding.jpg");
                  break;
              case 2:
                  sliderView.setImageUrl("https://www.digizargar.com/new/images/Gift.jpeg");
                  break;
              case 3:
                  sliderView.setImageUrl("https://www.digizargar.com/new/images/Economic.jpeg");
                  break;
          }

          sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
          //sliderView.setDescription("Jackdaws love my big sphinx of quartz." + (i + 1));
          final int finalI=i;
          sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
              @Override
              public void onSliderClick(SliderView sliderView) {
                //  Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                  Intent ni=new Intent(MainActivity.this,ProductCategoryList.class);
                  startActivity(ni);
              }
          });
          //at last add this view in your layout :
          sliderLayout.addSliderView(sliderView);

      }

    }



    private void setDataWonderful(){

        String imageUrl;
        final String[] title = new String[1];
        String price;

       Call<JSONResponse> callProduct=apiInterface.wonderfulListCall("true");

       callProduct.enqueue(new Callback<JSONResponse>() {
                               @Override
                               public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                             JSONResponse jsonResponse=response.body();
                            data=new ArrayList<>(Arrays.asList(jsonResponse.getObj1()));
                                   for(int i=0;i<data.size();i++){
                                       itemListwonder.add(new Data_Model_wonderful_list(data.get(i).getApiproduct_id(),data.get(i).getApiImageUrl(),
                                             data.get(i).getApiTitle(),data.get(i).getApiprice(),data.get(i).getApiOffPercentage()));


                                   }

                                   wonderAdapter.notifyDataSetChanged();
                               }

                               @Override
                               public void onFailure(Call<JSONResponse> call, Throwable t) {
                                   Toast.makeText(MainActivity.this,"error", Toast.LENGTH_SHORT).show();

                               }
                           });

    }

    private void setData(){

        itemList.add(new Data_Model_category("دستبند طلا"));
        itemList.add(new Data_Model_category("گوشواره طلا"));
        itemList.add(new Data_Model_category("سرویس طلا"));
        itemList.add(new Data_Model_category("نیم ست طلا"));
        itemList.add(new Data_Model_category("انگشتر طلا"));
        itemList.add(new Data_Model_category("گردنبند طلا"));
        itemList.add(new Data_Model_category("‍‍پابند طلا"));
        itemList.add(new Data_Model_category("حلقه طلا"));
        itemList.add(new Data_Model_category("تک دست والنگوطلا"));
        itemList.add(new Data_Model_category("ساعت و آویز طلا"));
        itemList.add(new Data_Model_category("مدال و پلاک طلا"));
        madapter.notifyDataSetChanged();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       switch (item.getItemId()){

           case R.id.toobar_menu_cart:
               Toast.makeText(this, "cart", Toast.LENGTH_LONG).show();
               break;
           case R.id.toolbar_menu_search:
               Toast.makeText(this, "search", Toast.LENGTH_LONG).show();
               break;
           default:
               break;

       }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_home:
              //  Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
            break;
            case R.id.nav_productList:
               // Intent product=new Intent(MainActivity.this,ProductCategoryList.class);
               // startActivity(product);
               Toast.makeText(this, "ProductList", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_basket:
                Toast.makeText(this, "Basket", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_specialOffer:
                Toast.makeText(this, "specialOffer", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_bestsellers:
                Toast.makeText(this, "bestSeller", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_mostviewed:
                Toast.makeText(this, "mostViewed", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_newest:
                Toast.makeText(this, "newst", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_frequentlyAQ:
                Toast.makeText(this, "frequently", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_aboutMe:
                Toast.makeText(this, "aboutMe", Toast.LENGTH_LONG).show();
                break;

                default:
                    break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


    @Override
    public void onBackPressed() {
      if(drawerLayout.isDrawerOpen(GravityCompat.START)){
          drawerLayout.closeDrawer(GravityCompat.START);
      }else{
          super.onBackPressed();
      }
    }
}
