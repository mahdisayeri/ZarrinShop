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
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    List<Data_Model> itemList;
    Context myContext;

    public ItemAdapter(List<Data_Model> itemList, Context myContext) {
        this.itemList = itemList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View aView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list1,viewGroup,false);

        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        Data_Model item=itemList.get(i);


        myViewHolder.titleList1.setText(item.getTitlelist());

        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(myContext, "item" + i, Toast.LENGTH_LONG).show();
                Intent product=new Intent(myContext,ProductCategoryList.class);
                myContext.startActivity(product);


            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView titleList1;
        public LinearLayout linearLayout;

        public MyViewHolder( View itemView) {
            super(itemView);

            titleList1=itemView.findViewById(R.id.tv_titleList1);
            linearLayout=itemView.findViewById(R.id.row_item_list);
        }
    }

}
