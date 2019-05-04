package com.example.fragmentsviewpager.adapters;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentsviewpager.R;
import com.example.fragmentsviewpager.activities.DescriptionActivity;
import com.example.fragmentsviewpager.models.ItemModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<ItemModel> listItem;

    public RecyclerViewAdapter(Context context, List<ItemModel> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final ItemModel item = listItem.get(i);
        myViewHolder.imgItem.setImageResource(context.getResources().getIdentifier(item.getItemImageName() , "drawable", context.getPackageName()));
        myViewHolder.tvItemName.setText(item.getItemName());
        myViewHolder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                intent.putExtra("imgName", item.getItemImageName());
                intent.putExtra("name", item.getItemName());
                intent.putExtra("desc", item.getItemDescription());
                intent.putExtra("price", item.getItemPrice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemName;
        private ImageView imgItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvItemName = itemView.findViewById(R.id.tvItemName);
        }
    }
}