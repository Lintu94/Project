package com.example.myapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.Model.YoutubeVideo;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    List<YoutubeVideo> youtubeVideoList;
    public VideoAdapter (){}

    public VideoAdapter(List<YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList=youtubeVideoList;
    }


    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {

        holder.videoWeb.loadData(youtubeVideoList.get(position).getVideoUrl(),"text/html","utf-8");
    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }


    public class VideoHolder extends RecyclerView.ViewHolder {

        WebView videoWeb;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            videoWeb=(WebView)itemView.findViewById(R.id.videoweview);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());

        }

    }
}
