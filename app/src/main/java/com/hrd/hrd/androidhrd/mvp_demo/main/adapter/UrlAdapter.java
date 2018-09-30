package com.hrd.androidhrd.mvp_demo.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrd.androidhrd.mvp_demo.R;
import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UrlAdapter  extends RecyclerView.Adapter<UrlAdapter.ViewHolder>{

    List<UrlResponse.Url> urls;
    public UrlAdapter(List<UrlResponse.Url> urls){
        this.urls=urls;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.url_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UrlResponse.Url url=urls.get(position);
        holder.urlTitle.setText(url.getTitle());
        holder.urlPhone.setText(url.getPhone());
        holder.urlLink.setText(url.getLink());
        //holder.icon.setImageResource();
        //bind image
        Picasso.get()
                .load(url.getPicUrl()==null ? "http://www.cambodianfootball.com/wp-content/uploads/logo.png":
                                url.getPicUrl())
                .fit().centerCrop()
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public void updateUrls(List<UrlResponse.Url> urls) {
        this.urls.addAll(urls);
        notifyItemRangeInserted(this.urls.size(),urls.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView urlTitle,urlPhone,urlLink;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            urlTitle=itemView.findViewById(R.id.urlTitle);
            urlPhone=itemView.findViewById(R.id.urlPhone);
            urlLink=itemView.findViewById(R.id.urlLink);
            icon=itemView.findViewById(R.id.icon);
        }
    }
}
