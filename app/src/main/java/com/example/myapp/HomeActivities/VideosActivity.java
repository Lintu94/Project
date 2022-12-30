package com.example.myapp.HomeActivities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.Adapters.VideoAdapter;
import com.example.myapp.Model.YoutubeVideo;

import java.util.Locale;
import java.util.Vector;

public class VideosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YoutubeVideo>youtubeVideos=new Vector<YoutubeVideo>();


    TextView tv;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_videos);

        tv = findViewById(R.id.textView);
        tv.setText(R.string.VideoInstruction);
        img = findViewById(R.id.imgs);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        VideoView videoView = findViewById(R.id.video_view);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
//        Uri uri = Uri.parse(videoPath);
//        videoView.setVideoURI(uri);
//
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // youtubeVideos.add(new YoutubeVideo());
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/hdVKpUR513M\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/M-tFVvdsWAY\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/PmmhxW0vVXA\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/DzpRjE5ekVk\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/eNvXrSf3Cww\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/e3eimijVeLw\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/R6VdoV8dZRc\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/fKzdiuseEIw\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/ddHKwkMwNyI\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/dmi18EiLDQo\" frameborder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\") src=\"https://www.youtube.com/embed/Yk2WOOqd2xY\" frameborder=\"0\" allowfullscreen></iframe>"));

//        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " + "src=\"https://www.youtube.com/embed/hdVKpUR513M\"  frameborder=\"0\" allowfullscreen>" + "</iframe></body></html>"));
//        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " + "src=\"https://www.youtube.com/embed/hdVKpUR513M\"  frameborder=\"0\" allowfullscreen>" + "</iframe></body></html>"));
//        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " + "src=\"https://www.youtube.com/embed/hdVKpUR513M\"  frameborder=\"0\" allowfullscreen>" + "</iframe></body></html>"));
//        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " + "src=\"https://www.youtube.com/embed/hdVKpUR513M\"  frameborder=\"0\" allowfullscreen>" + "</iframe></body></html>"));
//        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " + "src=\"https://www.youtube.com/embed/hdVKpUR513M\"  frameborder=\"0\" allowfullscreen>" + "</iframe></body></html>"));


//        youtubeVideos.add(R.raw.bleeding);
//        youtubeVideos.add(R.raw.fracture);
//        youtubeVideos.add(R.raw.nose);

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);





    }








    private void setLanguage(String en) {
        Locale locale =new Locale(en);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",en);
        editor.apply();
    }

    public void LoadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_Lang","");
        setLanguage(language);

    }
}