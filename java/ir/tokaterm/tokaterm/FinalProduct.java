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

public class FinalProduct extends AppCompatActivity {

    private SliderLayout sliderLayout;
    private Toolbar toolbar;
    private ImageView sharebtn,favbtn;
    private TextView mainTitle,subTitle,detail,comment,callbtn,presentbtn,textRate;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product);

        defineWidget();
        setdata();
        setSupportActionBar(toolbar);

        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(5);
        setSliderViews();
    }

    private void setdata(){

        mainTitle.setText("دستبند طلا 18 عیار زنانه ریسه گالری");
        subTitle.setText("مدل Ri3-S1088-Gold");
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FinalProduct.this, "هیچ نظری ثبت نشده است!!! ", Toast.LENGTH_SHORT).show();
            }
        });
        presentbtn.setText("دستبند صدف با طرح پولکی طلایی. متریال بکار رفته در دستبند صدف با طرح پولکی طلایی شامل صدف پولکی به قطر 2 سانتی متر, فریم طلا و نخ شاین دار به رنگ طلایی که با بافت بسیار مقاوم در کنار هم محکم شده اند. باور و اعتقاد قلبی به خواص مروارید, خصوصا خواص جادویی و ماورائی مروارید سبب گشته تا استفاده از آن پیشینه ای طولانی داشته باشد. اگر چه مروارید ساختاری کریستالی ندارد اما از قرن ها پیش و در میان اقوام گذشته مروارید از اهمیت بسیار زیادی در صنعت جواهر سازی و ساخت جواهرات برخوردار بوده است. باور و ایمان گذشتگان به خواص سنگ ها, خصوصا خواص مروارید سبب می گشت تا همواره و در همه حال این آن را همراه خود داشته باشند.");
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02120202020"));
                startActivity(callIntent);

            }
        });
    }

    private void defineWidget(){

        toolbar=findViewById(R.id.main_toolbar);
        sliderLayout=findViewById(R.id.imageSlider_product_sliderLayout);
        sharebtn=findViewById(R.id.final_product_share);
        favbtn=findViewById(R.id.final_product_favorite);
        mainTitle=findViewById(R.id.final_product_mainTitle);
        subTitle=findViewById(R.id.final_product_subTitle);
        detail=findViewById(R.id.final_product_details);
        comment=findViewById(R.id.final_product_commentUser);
        callbtn=findViewById(R.id.final_product_call);
        presentbtn=findViewById(R.id.final_product_presentation);
        textRate=findViewById(R.id.final_product_text_ratingBar);
        ratingBar=findViewById(R.id.final_product_ratingBar);

    }

    private void setSliderViews(){

        for(int i=0;i<=4;i++){

            DefaultSliderView sliderView=new DefaultSliderView(this);
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://dkstatics-public.digikala.com/digikala-products/4612025.jpg?x-oss-process=image/resize,h_800/quality,q_80");
                    break;
                case 1:
                    sliderView.setImageUrl("https://dkstatics-public.digikala.com/digikala-products/4612026.jpg?x-oss-process=image/resize,h_800/quality,q_80");
                    break;
                case 2:
                    sliderView.setImageUrl("https://dkstatics-public.digikala.com/digikala-products/4612030.jpg?x-oss-process=image/resize,h_800/quality,q_80");
                    break;
                case 3:
                    sliderView.setImageUrl("https://dkstatics-public.digikala.com/digikala-products/4612032.jpg?x-oss-process=image/resize,h_800/quality,q_80");
                    break;
                case 4:
                    sliderView.setImageUrl("https://dkstatics-public.digikala.com/digikala-products/4637078.jpg?x-oss-process=image/resize,h_800/quality,q_80");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("Jackdaws love my big sphinx of quartz." + (i + 1));
            //final int finalI=i;
           // sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
             //   @Override
               // public void onSliderClick(SliderView sliderView) {
                   // Toast.makeText(FinalProduct.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                //}
            //});
            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);

        }

    }
}
