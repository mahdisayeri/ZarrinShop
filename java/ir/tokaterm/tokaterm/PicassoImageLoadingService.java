package ir.tokaterm.tokaterm;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import ss.com.bannerslider.ImageLoadingService;

public class PicassoImageLoadingService implements ImageLoadingService {
    public Context context;

    public PicassoImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
       // Picasso.with(context).load(url).into(imageView);
        Glide.with(context).load(url).fitCenter().into(imageView);

    }

    @Override
    public void loadImage(int resource, ImageView imageView) {
        //Picasso.with(context).load(resource).into(imageView);
        Glide.with(context).load(resource).fitCenter().into(imageView);

    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        //Picasso.with(context).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
        Glide.with(context).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
    }

}

