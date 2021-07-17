package com.core.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.core.model.NewDetailItem;

import java.util.List;

public class NewsDetailAdapter extends RecyclerView.Adapter {

    private static final int TYPE_CENTER = 1;
    private static final int TYPE_LEFT = 2;

    private List<NewDetailItem> mData;

    public NewsDetailAdapter(List<NewDetailItem> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_CENTER) {
//            view = View.inflate(parent.getContext(), R.layout.item_news_main_view, null);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_main_view, parent, false);
            return new MainHolder(view);
        } else {
            view = View.inflate(parent.getContext(), R.layout.item_news_detail_view, null);
            return new DetailHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewDetailItem item = mData.get(position);
        if (item.type == TYPE_CENTER) {
            MainHolder mainHolder = (MainHolder) holder;
            mainHolder.setData(item);
        } else {
            DetailHolder detailHolder = (DetailHolder) holder;
            detailHolder.setData(item);
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        NewDetailItem item = mData.get(position);
        if (item.type == 1) {
            return TYPE_CENTER;
        } else {
            return TYPE_LEFT;
        }
    }

    private class MainHolder extends RecyclerView.ViewHolder {
        private ImageView icon;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_main_icon);
        }
        public void setData(NewDetailItem item) {
            icon.setImageResource(item.icon);
        }
    }

    private class DetailHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView title;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_detail_icon);
            title = itemView.findViewById(R.id.item_detail_title);
        }

        public void setData(NewDetailItem item) {
            icon.setImageResource(item.icon);
            title.setText(item.title);
        }
    }
}
