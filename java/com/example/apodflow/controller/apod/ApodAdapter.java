package com.example.apodflow.controller.apod;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apodflow.R;
import com.example.apodflow.model.apod.Apod;

import java.util.List;

public class ApodAdapter extends RecyclerView.Adapter<ApodAdapter.ApodViewHolder> {

    private List<Apod> apodList;
    private boolean isExpanded = false;

    public ApodAdapter(List<Apod> apodList) {
        this.apodList = apodList;
    }

    @NonNull
    @Override
    public ApodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ApodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApodViewHolder holder, int position) {
        Apod apod = apodList.get(position);

        holder.title.setText(apod.getTitle());
        holder.date.setText(apod.getDate());
        holder.description.setText(apod.getExplanation());

        Glide.with(holder.itemView.getContext())
                .load(apod.getHdurl())
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.error_image)
                .into(holder.imageView);

        holder.btn_toggle.setOnClickListener(v -> toggleExpand(holder));
    }

    private void toggleExpand(ApodViewHolder holder) {
        if (isExpanded) {
            holder.title.setTranslationY(0);
            holder.date.setTranslationY(0);
            holder.description.setTranslationY(0);
            holder.description.setMaxLines(4);
            holder.description.setEllipsize(TextUtils.TruncateAt.END);
            holder.btn_toggle.setText("Ver Tudo");
        } else {
            holder.title.setTranslationY(-900);
            holder.date.setTranslationY(-900);
            holder.description.setTranslationY(-900);
            holder.description.setMaxLines(Integer.MAX_VALUE);
            holder.description.setEllipsize(null);
            holder.btn_toggle.setText("Recolher");
        }
        isExpanded = !isExpanded;
    }

    @Override
    public int getItemCount() {
        return apodList.size();
    }

    public static class ApodViewHolder extends RecyclerView.ViewHolder {
        TextView title, date, description;
        ImageView imageView;
        Button btn_toggle;

        public ApodViewHolder(@NonNull View itemView) {
            super(itemView);


            title = itemView.findViewById(R.id.item_layout_title);
            date = itemView.findViewById(R.id.item_layout_date);
            description = itemView.findViewById(R.id.item_layout_explanation);
            imageView = itemView.findViewById(R.id.item_layout_imageView);
            btn_toggle = itemView.findViewById(R.id.btn_toggle);
        }
    }
}
