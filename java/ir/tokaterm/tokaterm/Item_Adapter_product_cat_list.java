package ir.tokaterm.tokaterm;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Item_Adapter_product_cat_list extends RecyclerView.Adapter<Item_Adapter_product_cat_list.myViewHolder_product_cat_list>  {

    List<Data_Mode_product_cat_list> itemlist;
    Context myContext;

    public Item_Adapter_product_cat_list(List<Data_Mode_product_cat_list> itemlist, Context myContext) {
        this.itemlist = itemlist;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public myViewHolder_product_cat_list onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View iview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_product_category_list,viewGroup,false);

        return new myViewHolder_product_cat_list(iview);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder_product_cat_list myViewHolder_product_cat_list, final int i) {

      Data_Mode_product_cat_list  item=itemlist.get(i);
      String imgurl=item.getImage();
        Glide.with(myContext).load(imgurl).centerCrop().placeholder(R.drawable.a1).into(myViewHolder_product_cat_list.imageView);

      myViewHolder_product_cat_list.mainTitle.setText(item.getMainTitle());
      myViewHolder_product_cat_list.subTitle.setText("");
      myViewHolder_product_cat_list.oldPrice.setText(String.format("%,d",Integer.parseInt(item.getOlePrice()))+" تومان ");
      myViewHolder_product_cat_list.oldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
      myViewHolder_product_cat_list.newPrice.setText(newPrice(item.getOlePrice(),item.getOffPersentage()));

      myViewHolder_product_cat_list.ll.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(myContext, "item"+i, Toast.LENGTH_SHORT).show();
          }
      });


    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class myViewHolder_product_cat_list extends RecyclerView.ViewHolder{
       private TextView mainTitle,subTitle,oldPrice,newPrice;
       private ImageView imageView;

       private LinearLayout ll;

        public myViewHolder_product_cat_list(@NonNull View itemView) {
            super(itemView);

            mainTitle=itemView.findViewById(R.id.row_product_cat_list_main_title);
            subTitle=itemView.findViewById(R.id.row_product_cat_list_subtitle);
            oldPrice=itemView.findViewById(R.id.row_product_cat_list_oldprice);
            newPrice=itemView.findViewById(R.id.row_product_cat_list_newprice);

            imageView=itemView.findViewById(R.id.row_product_cat_list_imageview);
            ll=itemView.findViewById(R.id.row_product_cat_list_linearLayout);
        }
    }

    private String newPrice(String Price,String OffPer){
        int price=Integer.parseInt(Price);
        int offPer=Integer.parseInt(OffPer);
        int newPrice=price-((price*offPer)/100);

        return String.format("%,d",newPrice)+" تومان ";
    }
}
