package com.example.makeuptask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.makeuptask.R;
import com.example.makeuptask.networking.ProductResult;

import java.util.List;

public class RVRetrofitAdapter extends RecyclerView.Adapter<RVRetrofitAdapter.RVHolderRetrofit> {
    public interface OnProductClickListener {
        void onProductClick(ProductResult product);
    }
    Context mContext;
    List<ProductResult> productResults;
    private OnProductClickListener onProductClickListener;
    public RVRetrofitAdapter(Context mContext, List<ProductResult> productResults, OnProductClickListener listener) {
        this.mContext = mContext;
        this.productResults = productResults;
        this.onProductClickListener = listener;
    }

    @NonNull
    @Override
    public RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_product_item, parent, false);
        return new RVHolderRetrofit(view);
    }

    @Override
    public int getItemCount() {
        return productResults.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolderRetrofit holder, int position) {
        holder.tvTitle.setText(productResults.get(position).getName());
        holder.tvPrice.setText(productResults.get(position).getPrice());
        Glide.with(mContext).load(productResults.get(position)
                        .getImage_link()).placeholder(R.drawable.th)
                .error(R.drawable.ic_launcher_background).into(holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION && onProductClickListener != null) {
                    onProductClickListener.onProductClick(productResults.get(clickedPosition));
                }
            }
        });
    }
    public class RVHolderRetrofit extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivImage;
        TextView tvPrice;

        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }

}
