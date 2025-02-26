package com.example.exe2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exe2.R;
import com.example.exe2.model.Cat;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> list;
    private Context context;
    private onCatItemListener onCatItemListener;

    public void setOnCatItemListener(CatAdapter.onCatItemListener onCatItemListener) {
        this.onCatItemListener = onCatItemListener;
    }

    public CatAdapter(Context context, List<Cat> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = list.get(position);
        holder.img.setImageResource(cat.getImage());
        holder.txtName.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CatViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtName;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCatItemListener.onItemClick(itemView, getAdapterPosition());
                }
            });
        }


    }
    public interface onCatItemListener{
        void onItemClick(View view, int position);
    }
}
