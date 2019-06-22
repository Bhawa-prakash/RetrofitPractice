package com.e.retrofitpractice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e.retrofitpractice.R;
import com.e.retrofitpractice.model.BestSelling;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<BestSelling>DtaAdapter;
    Context context;


    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new MyViewHolder(itemView);


    }
    public DataAdapter(List<BestSelling> DtaAdapter, int recycler_item, Context applicationContext) {
        this.context = applicationContext;
        this.DtaAdapter= DtaAdapter;
    }
    @Override
    public void onBindViewHolder(DataAdapter.MyViewHolder holder, int position) {

        BestSelling bestSelling = DtaAdapter.get(position);
        holder.textView1.setText(DtaAdapter.get(position).getDTitle());
        holder.textView2.setText(DtaAdapter.get(position).getPDesc());
        holder.textView3.setText(DtaAdapter.get(position).getPDiscPrice());
        holder.textView4.setText(DtaAdapter.get(position).getPPrice());
        holder.textView5.setText(DtaAdapter.get(position).getPQuantity());
        holder.textView6.setText(DtaAdapter.get(position).getPTitle());
        Picasso.with(context).load(DtaAdapter.get(position).getPImage())

                .into(holder.imageview);




    }

    @Override
    public int getItemCount() {
        return DtaAdapter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        LinearLayout dataLayout;
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
        public MyViewHolder(View itemView) {
            super(itemView);
            dataLayout = (LinearLayout) itemView.findViewById(R.id.recycler);
            imageview = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.name1);
            textView2 = itemView.findViewById(R.id.name2);
            textView3 = itemView.findViewById(R.id.name3);
            textView4 = itemView.findViewById(R.id.name4);
            textView5 = itemView.findViewById(R.id.name5);
            textView6 = itemView.findViewById(R.id.name6);
        }
    }
}
