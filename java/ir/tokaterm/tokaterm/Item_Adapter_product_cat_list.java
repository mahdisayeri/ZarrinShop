package ir.tokaterm.tokaterm;

import android.content.Context;
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

      myViewHolder_product_cat_list.imageView.setImageResource(item.getImage());
      myViewHolder_product_cat_list.titlename.setText(item.getTitle());

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
       private TextView titlename;
       private ImageView imageView;
       private LinearLayout ll;

        public myViewHolder_product_cat_list(@NonNull View itemView) {
            super(itemView);

            titlename=itemView.findViewById(R.id.row_product_cat_list_textview);
            imageView=itemView.findViewById(R.id.row_product_cat_list_imageview);
            ll=itemView.findViewById(R.id.row_product_cat_list_linearLayout);
        }
    }
}
