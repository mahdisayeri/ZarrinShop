package ir.tokaterm.tokaterm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;

public class FinalProduct extends AppCompatActivity {

    private SliderLayout sliderLayout;
    private Toolbar toolbar;
    private ImageView sharebtn,favbtn;
    private TextView mainTitle,subTitle,detail,comment,callbtn,description,textRate;
    private RatingBar ratingBar;
    private Slider slider;
    private ApiInterface apiInterface;
    private String product_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product);
        apiInterface=Api.getApi().create(ApiInterface.class);
        defineWidget();
        setSupportActionBar(toolbar);
        product_id=getIntent().getExtras().getString("post_id");

        Slider.init(new PicassoImageLoadingService(this));
        setupViews();
        setdata();
       set_moreData();

    }

    private void setupViews() {
        // setupToolbar();
        slider = findViewById(R.id.banner_slider1);
        final String imgUrl=getIntent().getExtras().getString("imgUrl");

        //delay for testing empty view functionality
        slider.setAdapter(new MainSliderAdapter(imgUrl,imgUrl,imgUrl,3));
        slider.setSelectedSlide(0);

    }

    private void setdata(){

        String title=getIntent().getExtras().getString("title");
        String oldPrice=getIntent().getExtras().getString("oldPrice");
        String newPrice=getIntent().getExtras().getString("newPRice");

     //   Toast.makeText(FinalProduct.this, product_id, Toast.LENGTH_SHORT).show();



        mainTitle.setText(title);
        subTitle.setText("");

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0219377523892"));
                startActivity(callIntent);

            }
        });
    }

    private void set_moreData(){

        Call<Product> productCall=MainActivity.apiInterface.product_moreDetailCall(product_id);
        productCall.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, final Response<Product> response) {
                comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FinalProduct.this,   response.body().getApiComment_count(), Toast.LENGTH_SHORT).show();
                    }
                });
               description.setText( response.body().getApiDescription());
             //   Toast.makeText(FinalProduct.this,  response.body()+"", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });


    }

    private void defineWidget(){

        toolbar=findViewById(R.id.main_toolbar);
       // sliderLayout=findViewById(R.id.imageSlider_product_sliderLayout);
        sharebtn=findViewById(R.id.final_product_share);
        favbtn=findViewById(R.id.final_product_favorite);
        mainTitle=findViewById(R.id.final_product_mainTitle);
        subTitle=findViewById(R.id.final_product_subTitle);
        detail=findViewById(R.id.final_product_details);
        comment=findViewById(R.id.final_product_commentUser);
        callbtn=findViewById(R.id.final_product_call);
       description=findViewById(R.id.final_product_presentation);
        textRate=findViewById(R.id.final_product_text_ratingBar);
        ratingBar=findViewById(R.id.final_product_ratingBar);

    }
}
