package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.HomeActivities.EmergencyActivity;
import com.example.myapp.HomeActivities.EmergencyActivityCustomePopUp;
import com.example.myapp.HomeActivities.ShareActivity;

import com.example.myapp.HomeActivities.VideosActivity;
import com.example.myapp.NavActivities.ContactActivity;
import com.example.myapp.NavActivities.FeedbackActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    AlertDialog.Builder builder;
    Toolbar toolbar;
    ImageView imge1,imge2,imge3,imge4,imge5,imge6;
    Dialog dialog;
    String number = null;
    public static final int REQUEST_CALL = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.langImg);
        dialog = new Dialog(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languageDialog();
            }
        });

        imge1 = findViewById(R.id.emerge);
        imge2 = findViewById(R.id.video);
        imge3 = findViewById(R.id.call);
        imge4 = findViewById(R.id.nearby);
        imge5 = findViewById(R.id.tip);
        imge6 = findViewById(R.id.imgShare);

        imge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, EmergencyActivity.class);
                startActivity(int1);

            }
        });
        imge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainActivity.this, VideosActivity.class);
                startActivity(int2);
            }
        });
        imge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4= new Intent(MainActivity.this, NearbyActivity.class);
                startActivity(int4);
            }
        });
        imge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6= new Intent(MainActivity.this, ShareActivity.class);
                startActivity(int6);
            }
        });
        imge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this
                        , Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //when permission granted
                    ActivityCompat.requestPermissions(MainActivity.this
                            , new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL );


                }
                showPopup();

            }
        });






        toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        builder = new AlertDialog.Builder(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id)
                {
                    case R.id.lang_nav:
                        languageDialog();
                        break;
                    case R.id.shr:
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, "This is the share text");
                        startActivity(Intent.createChooser(intent, "First Aid"));
                        break;
                    case R.id.feed_nav:
                        Intent intent1 = new Intent(MainActivity.this, FeedbackActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.cont_nav:
                        Intent intent2 = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ext:
                        builder.setTitle("Exit!").setMessage(R.string.sure).setCancelable(true)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                }).show();
                    default:
                        break;
                }

                return true;
            }
        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        MenuItem menuItem = menu.findItem(R.id.search_view);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("type to search");
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                usersAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id==R.id.search_view)
//        {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    private void languageDialog() {
        final String [] languageItem ={"English ", "አማርኛ"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.select);
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

    public void LoadLocale()
    {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_Lang","");
        setLanguage(language);

    }



    public void showPopup(){

        TextView txtClose;
        CircleImageView img;
        ImageButton img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
        dialog.setContentView(R.layout.customepopupmenu);
        txtClose=(TextView) dialog.findViewById(R.id.txtClose);
        img=(CircleImageView) dialog.findViewById(R.id.circleImg);
        img0= dialog.findViewById(R.id.callbtn0);
        img1=dialog.findViewById(R.id.callbtn1);
        img2=dialog.findViewById(R.id.callbtn2);
        img3=dialog.findViewById(R.id.callbtn3);
        img4=dialog.findViewById(R.id.callbtn4);
        img5=dialog.findViewById(R.id.callbtn5);
        img6=dialog.findViewById(R.id.callbtn6);
        img7=dialog.findViewById(R.id.callbtn7);
        img8=dialog.findViewById(R.id.callbtn8);
        img9=dialog.findViewById(R.id.callbtn9);
        img10=dialog.findViewById(R.id.callbtn10);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        img0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="+2516660527";
          builderShow(number);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="+251115180181";
                builderShow(number);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="+251582221041";
                builderShow(number);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="+2510114405983";
                builderShow(number);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="+2511111430";
                builderShow(number);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    private void callHelp(String callPhone) {

        String dials= "tel:" + callPhone;
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dials)));
    }

    public  void builderShow( String phonenumber){

        builder.setTitle("Call Permission ?").setMessage("Do you want to call ?").setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        callHelp(phonenumber);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }
}