package ir.tokaterm.tokaterm;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter_category extends RecyclerView.Adapter<ItemAdapter_category.MyViewHolder> {

    List<Data_Model_category> itemList;
    Context myContext;

    public ItemAdapter_category(List<Data_Model_category> itemList, Context myContext) {
        this.itemList = itemList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View aView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_category,viewGroup,false);

        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        Data_Model_category item=itemList.get(i);


        myViewHolder.titleList.setText(item.getTitlelist());

        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent product=new Intent(myContext,ProductCategoryList.class);
                product.putExtra("category",myViewHolder.titleList.getText().toString());
                myContext.startActivity(product);


            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView titleList;
        public LinearLayout linearLayout;

        public MyViewHolder( View itemView) {
            super(itemView);

            titleList=itemView.findViewById(R.id.item_list_category_textView);
            linearLayout=itemView.findViewById(R.id.item_list_category_linearLayout);
        }
    }

}
