package ir.tokaterm.tokaterm;


import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {


    private String url1;
    private String url2;
    private String url3;
    private int imageCount;

    public MainSliderAdapter(String url1, String url2, String url3, int imageCount) {
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.imageCount = imageCount;
    }

    @Override
    public int getItemCount() {
        return imageCount;
    }
    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
               viewHolder.bindImageSlide(url1);
                break;
            case 1:
                viewHolder.bindImageSlide(url2);
                break;
            case 2:
                viewHolder.bindImageSlide(url3);
                break;
        }
    }

}
