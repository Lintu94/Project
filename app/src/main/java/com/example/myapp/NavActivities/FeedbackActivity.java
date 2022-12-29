package com.example.myapp.NavActivities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapp.MainActivity;
import com.example.myapp.R;

import java.util.Locale;

public class FeedbackActivity extends AppCompatActivity {

    ImageView imgBack;
    EditText editText1,editText2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_feedback);

        imgBack = findViewById(R.id.imgback);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);
        btn = findViewById(R.id.sendBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
 //               intent.setType("message/html");
//                intent.putExtra(Intent.EXTRA_EMAIL,"linamikail9416@gmail.com");
//               // intent.putExtra(Intent.EXTRA_EMAIL,new String("linamikail9416@gmail.com"));
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Feed Back From App");
//                intent.putExtra(Intent.EXTRA_TEXT, "Name: "+editText1.getText()+
//                        "\n Message: "+editText2.getText());
//                try {
//                    startActivity(Intent.createChooser(intent,"Select Email"));
//
//                }catch (android.content.ActivityNotFoundException exception)
//                {
//                    Toast.makeText(FeedbackActivity.this, "There are no Email client", Toast.LENGTH_SHORT).show();
//                }
                String UriText = "mailto: "+ Uri.encode("linamikail9194@gmail.com")+
                        "?subject= "+Uri.encode("Feedback from app \n")
                        +"\n Name: " +Uri.encode(String.valueOf(editText1.getText()))
                         +"\n\n Message:\n\n "+Uri.encode(String.valueOf(editText2.getText()));
                Uri uri =Uri.parse(UriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent," Select Email"));

            }
        });


    }
    private void languageDialog() {
        final String [] languageItem ={"English ", "አማርኛ"};
        AlertDialog.Builder builder = new AlertDialog.Builder(FeedbackActivity.this);
        builder.setTitle("Select Language..");
        builder.setSingleChoiceItems(languageItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0)
                {
                    setLanguage("En");
                    recreate();
                }else if (i==1)
                {
                    setLanguage("Am");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

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