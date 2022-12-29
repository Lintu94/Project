package com.example.myapp.HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.example.myapp.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class ShareActivity extends AppCompatActivity {
    public Button sharebtn, viewbtn;
    private FusedLocationProviderClient fusedLocationClient;
    private TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    public static final int RESULT_PICK_CONTACT=1;

    // for picking contact

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }
        } else {
            Toast.makeText(this, "Failed to pick contact", Toast.LENGTH_SHORT).show();
        }
    }
    private void contactPicked(Intent data){
        Cursor cursor=null;
        try{
            String phoneNo=null;
            Uri uri=data.getData();
            cursor= getContentResolver().query(uri,null,null,null,null);
            cursor.moveToFirst();
            int phoneIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNo=cursor.getString(phoneIndex);
            textInputEditText.setText(phoneNo);

        }catch (Exception e){
           e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_share);
        textInputEditText = findViewById(R.id.editPhone);
        sharebtn = findViewById(R.id.btnShare);
        viewbtn = findViewById(R.id.btnView);
        textInputLayout=findViewById(R.id.textInputLayout2);
        textInputEditText=findViewById(R.id.editPhone);

        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(ShareActivity.this);
                if (ActivityCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        //when permission granted
                        ActivityCompat.requestPermissions(ShareActivity.this
                                , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                        //when permission granted
                        ActivityCompat.requestPermissions(ShareActivity.this
                                , new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                } else {

                fusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        //Initalize Location
                        Location location = task.getResult();
                        if (location != null) {
                            //Initalize geoCoder
                            try {
                                Geocoder geocoder = new Geocoder(ShareActivity.this
                                        , Locale.getDefault());
                                //Initalize address list
                                List<Address> addresses = geocoder.getFromLocation(
                                        location.getLatitude(), location.getLongitude(), 1);
                                String uri = "http://maps.google.com/?q=" + location.getLatitude() + "," + location.getLongitude();
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                startActivity(intent);


                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                });
                }
            }
        });
      sharebtn.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {

              String phone = textInputEditText.getText().toString();
              if(textInputEditText.getText().toString()==""){
                  Toast.makeText(ShareActivity.this, "Pleas Insert Phone Number or chose from Contacts", Toast.LENGTH_SHORT).show();
              }
             if( textInputEditText.getText().toString().substring(0,1)=="09"  || textInputEditText.getText().toString().substring(0,1)!="07") {
                  Toast.makeText(ShareActivity.this, "Pleas Insert valid Phone Number", Toast.LENGTH_SHORT).show();
                  textInputEditText.setText("");
              }
          if(textInputEditText.getText().toString()!="" && textInputEditText.getText().toString().substring(0,1)=="09" || textInputEditText.getText().toString().substring(0,1)=="07"){
                  fusedLocationClient = LocationServices.getFusedLocationProviderClient(ShareActivity.this);
                  if (ActivityCompat.checkSelfPermission(ShareActivity.this
                          , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                      //when permission granted
                      ActivityCompat.requestPermissions(ShareActivity.this
                              , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                  }
                  if (ActivityCompat.checkSelfPermission(ShareActivity.this
                          , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                      //when permission granted
                      ActivityCompat.requestPermissions(ShareActivity.this
                              , new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                  }
                  if (ActivityCompat.checkSelfPermission(ShareActivity.this
                          , Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                      //when permission granted
                      ActivityCompat.requestPermissions(ShareActivity.this
                              , new String[]{Manifest.permission.SEND_SMS}, 44);
                  }

                  fusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                      @Override
                      public  void onComplete(@NonNull Task<Location> task) {
                          //Initalize Location
                          Location location = task.getResult();
                          if (location != null) {
                              //Initalize geoCoder
                              try {
                                  Geocoder geocoder = new Geocoder(ShareActivity.this
                                          , Locale.getDefault());
                                  //Initalize address list
                                  List<Address> addresses = geocoder.getFromLocation(
                                          location.getLatitude(), location.getLongitude(), 1);
                                  String uri = "http://maps.google.com/?q=" + location.getLatitude() + "," + location.getLongitude();
                                  Toast.makeText(ShareActivity.this, "ur current loaction is " + uri, Toast.LENGTH_SHORT).show();

                                  if (ContextCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                                      SmsManager smsManager = SmsManager.getDefault();
                                      StringBuffer smsBody = new StringBuffer();
                                      smsBody.append(Uri.parse(uri));
                                      smsManager.sendTextMessage(String.valueOf(phone), null, smsBody.toString(), null, null);
                                      textInputEditText.setText("");
                                  } else {
                                      ActivityCompat.requestPermissions(ShareActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                                  }



                              } catch (IOException e) {
                                  e.printStackTrace();
                              }

                          }
                      }

                  });
              }







              }

      });


textInputLayout.setStartIconOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent,RESULT_PICK_CONTACT);
    }
});




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

}


