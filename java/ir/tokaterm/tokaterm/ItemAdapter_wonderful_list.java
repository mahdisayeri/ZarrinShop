package ir.tokaterm.tokaterm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter_wonderful_list extends
        RecyclerView.Adapter<ItemAdapter_wonderful_list.myViewHolder_wonderful> {

    List<Data_Model_wonderful_list> itemList;
    Context myContext;

    public ItemAdapter_wonderful_list(List<Data_Model_wonderful_list> itemList, Context myContext) {
        this.itemList = itemList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public myViewHolder_wonderful onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View aview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_wonderful,viewGroup,false);
        return new myViewHolder_wonderful(aview);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder_wonderful myViewHolder_wonderful, final int i) {

        final Data_Model_wonderful_list item=itemList.get(i);

        String url=item.getImage();
        Glide.with(myContext).load(url).centerCrop().placeholder(R.drawable.a1).into(myViewHolder_wonderful.image);

        myViewHolder_wonderful.nameTitle.setText(item.getNameTitle());
        myViewHolder_wonderful.oldprice.setText(item.getOffPercentage()+"تومان ");
        myViewHolder_wonderful.oldprice. setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        myViewHolder_wonderful.newPrice.setText(newPrice(item.getOffPercentage(),item.getPrice()));

        myViewHolder_wonderful.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fp=new Intent(myContext,FinalProduct.class);
                fp.putExtra("title",item.getNameTitle());
                fp.putExtra("oldPrice",item.getPrice());
                myContext.startActivity(fp);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class myViewHolder_wonderful extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView nameTitle;
        public TextView oldprice;
        public TextView newPrice;
        public CardView cardView;


        public myViewHolder_wonderful(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.item_list_wonder_image);
            nameTitle=itemView.findViewById(R.id.item_list_wonder_nameTitle);
            oldprice=itemView.findViewById(R.id.item_list_wonder_oldPrice);
            newPrice=itemView.findViewById(R.id.item_list_wonder_newPrice);
            cardView=itemView.findViewById(R.id.item_list_wonderfull_cardview);

        }
    }

    private String newPrice(String Price,String OffPer){
        int price=Integer.parseInt(Price);
        int offPer=Integer.parseInt(OffPer);
      int newPrice=price-((price*offPer)/100);

        return String.format("%,d",newPrice)+"تومان ";
    }

}
