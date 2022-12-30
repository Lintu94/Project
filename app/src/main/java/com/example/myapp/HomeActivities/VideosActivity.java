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
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

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


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String url1="https://www.youtube.com/embed/CAcwoaylH9o";
        String url2="https://www.youtube.com/embed/eBINwvHFTnw";
        String url3="https://www.youtube.com/embed/D3SbaMe5HpE";
        String url4="https://www.youtube.com/embed/ZhO-c4z-lDM";
        String url5="https://www.youtube.com/embed/O2ja8MNdQuQ";
        String url6="https://www.youtube.com/embed/dSfXcQqLZqs";
        String url7="https://www.youtube.com/embed/8pTaqY40-Rs";
        String url8="https://www.youtube.com/embed/NsuGwUB8SZM";
        String url9="https://www.youtube.com/embed/iJMyJ1KUdmQ";
        String url10="https://www.youtube.com/embed/k7iPIQXvKjQ";
        String url11="https://www.youtube.com/embed/eTKo4DVVS58";
        String url12="https://www.youtube.com/embed/faLkXDXrhnM";
        String url13="https://www.youtube.com/embed/V1YiDNEqOHM";
        String url14="https://www.youtube.com/embed/_ZBOF4tl-0M";
        String url15="https://www.youtube.com/embed/9j9ne13Cm2k";
        String url16="https://www.youtube.com/embed/RrPsfeij-bA";
        String url17="https://www.youtube.com/embed/7Fh3v5c6FY4";
        String url18="https://www.youtube.com/embed/PLfgh_r8gbf66l76oOvSvzlVgRU0W4IBHe";
        String url19="https://www.youtube.com/embed/KeZXgE9q6eo";
        String url20="https://www.youtube.com/embed/naalpe_MxBU";



        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url1 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));

        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url2 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));

        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url3 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url4 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url5 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url6 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url7 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url8 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url8 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url10 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url11 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url12 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url13 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url14 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url15 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url16 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url17 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url18 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url19 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));
        youtubeVideos.add(new YoutubeVideo("<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" " +
                "src='" + url20 + "' frameborder=\"0\" allowfullscreen>" +
                "</iframe></body></html>"));



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