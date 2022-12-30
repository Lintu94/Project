package com.example.myapp.HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.myapp.Adapters.Em_Adapter;
import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.Model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmergencyActivity extends AppCompatActivity {
    ImageView imgBack;
    Toolbar toolbar1;
    RecyclerView recyclerViews;
    List<UserModel> userModelList = new ArrayList<>();
    Em_Adapter em_adapter;

    int images [] = {R.drawable.asthma,R.drawable.bleed,R.drawable.burn,R.drawable.chest,R.drawable.chok,
            R.drawable.chok2,R.drawable.cuts, R.drawable.diarrhoea,R.drawable.dogbote,R.drawable.drowning,
            R.drawable.epilepsy,R.drawable.faint,R.drawable.fever,R.drawable.fracture,R.drawable.no_breath,
            R.drawable.nose,R.drawable.poison,R.drawable.sting,R.drawable.stroke};


//    String string1=(String) getString(R.string.bleeding);
//    String string2=(String) getString(R.string.burning);

//    public String string11 = getString(R.string.burning);

   // String [] names={"Bleeding","Burning","Chest Pain","Chock","Cuts","Diarrhoea","Dog bite","Drowning","Epilepsy","Faint"};


   String [] names ;
    String name1,name2,name3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_emergency);

       names = getResources().getStringArray(R.array.Emergency_Names);

      // name1 = getResources().getString(R.string.bleeding);
      // name2 = getResources().getString(R.string.burning);


        for(String s: names)
        {
            UserModel userModel = new UserModel(s);
            userModelList.add(userModel);
        }










        imgBack = findViewById(R.id.imgback);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Intent intent = new Intent(EmergencyActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        toolbar1 = findViewById(R.id.toolbar1);
        recyclerViews = findViewById(R.id.recycler_view);
        this.setSupportActionBar(toolbar1);
        recyclerViews.setLayoutManager(new LinearLayoutManager(this));
        em_adapter = new Em_Adapter(userModelList,images);
        recyclerViews.setAdapter(em_adapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem =menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                em_adapter.getFilter().filter(newText);
                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.search_view)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void languageDialog() {
        final String [] languageItem ={"English ", "አማርኛ"};
        AlertDialog.Builder builder = new AlertDialog.Builder(EmergencyActivity.this);
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