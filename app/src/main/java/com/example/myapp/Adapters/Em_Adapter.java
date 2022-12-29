package com.example.myapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.EmergencyActivities.AsthmaActivity;
import com.example.myapp.EmergencyActivities.BleedingActivity;
import com.example.myapp.EmergencyActivities.BurnActivity;
import com.example.myapp.EmergencyActivities.ChestActivity;
import com.example.myapp.EmergencyActivities.Choke1Activity;
import com.example.myapp.EmergencyActivities.Choke2Activity;
import com.example.myapp.EmergencyActivities.CutActivity;
import com.example.myapp.EmergencyActivities.DiarActivity;
import com.example.myapp.EmergencyActivities.DogActivity;
import com.example.myapp.EmergencyActivities.DrowningActivity;
import com.example.myapp.EmergencyActivities.EpilepsyActivity;
import com.example.myapp.EmergencyActivities.FaintActivity;
import com.example.myapp.EmergencyActivities.FeverActivity;
import com.example.myapp.EmergencyActivities.FractureActivity;
import com.example.myapp.EmergencyActivities.NoBreathActivity;
import com.example.myapp.EmergencyActivities.NoseBleedActivity;
import com.example.myapp.EmergencyActivities.PoisonActivity;
import com.example.myapp.EmergencyActivities.StingActivity;
import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class Em_Adapter extends RecyclerView.Adapter<Em_Adapter.MyHolder> implements Filterable {


    private List<UserModel> getUserModelList;
    private List<UserModel> userModelList;
    private Context context;
    int images [];

    public Em_Adapter(List<UserModel> userModelList, int img[])
    {
        this.getUserModelList=userModelList;
        this.userModelList = userModelList;
        this.images = img;

    }


    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence==null | charSequence.length()==0)
                {
                    filterResults.count=getUserModelList.size();
                    filterResults.values=getUserModelList;
                }
                else
                {
                    String searchChr = charSequence.toString().toLowerCase();
                    List<UserModel> resultData = new ArrayList<>();
                    for (UserModel userModel:getUserModelList)
                    {
                        if (userModel.getUserName().toLowerCase().contains(searchChr)){
                            resultData.add(userModel);
                        }
                    }
                    filterResults.count=resultData.size();
                    filterResults.values=resultData;

                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                userModelList= (List<UserModel>) filterResults.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       context = parent.getContext();
       return new MyHolder(LayoutInflater.from(context).inflate(R.layout.emergency_row,null));
    }

    @Override
    public void onBindViewHolder(@NonNull Em_Adapter.MyHolder holder, int position) {
        UserModel userModel = userModelList.get(position);
        String username = userModel.getUserName();
        holder.img.setImageResource(images[position]);
        holder.tvUserName1.setText(username);

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        ImageView img;
        TextView tvUserName1;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvUserName1 = itemView.findViewById(R.id.userName1);
            img = itemView.findViewById(R.id.images);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position==0)
                    {
                        Intent intent = new Intent(context , AsthmaActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==1)
                    {
                        Intent intent = new Intent(context , BleedingActivity.class);
                        context.startActivity(intent);
                    }

                    else if (position==2)
                    {
                        Intent intent = new Intent(context , BurnActivity.class);
                        context.startActivity(intent);
                    }

                    else if (position==3)
                    {
                        Intent intent = new Intent(context , ChestActivity.class);
                        context.startActivity(intent);
                    }

                    else if (position==4)
                    {
                        Intent intent = new Intent(context , Choke1Activity.class);
                        context.startActivity(intent);
                    }

                    else if (position==5)
                    {
                        Intent intent = new Intent(context , Choke2Activity.class);
                        context.startActivity(intent);
                    }

                    else if (position==6)
                    {
                        Intent intent = new Intent(context , CutActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==7)
                    {
                        Intent intent = new Intent(context , DiarActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==8)
                    {
                        Intent intent = new Intent(context , DogActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==9)
                    {
                        Intent intent = new Intent(context , DrowningActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==10)
                    {
                        Intent intent = new Intent(context , EpilepsyActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==11)
                    {
                        Intent intent = new Intent(context , FaintActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==12)
                    {
                        Intent intent = new Intent(context , FeverActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==13)
                    {
                        Intent intent = new Intent(context , FractureActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==14)
                    {
                        Intent intent = new Intent(context , NoBreathActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==15)
                    {
                        Intent intent = new Intent(context , NoseBleedActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==16)
                    {
                        Intent intent = new Intent(context , PoisonActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==17)
                    {
                        Intent intent = new Intent(context , StingActivity.class);
                        context.startActivity(intent);
                    }
                    else if (position==18)
                    {
                        Intent intent = new Intent(context , ChestActivity.class);
                        context.startActivity(intent);
                    }

                    else
                    {
                        Intent intent = new Intent(context , MainActivity.class);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
