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

import com.example.myapp.EmergencyActivities.BleedingActivity;
import com.example.myapp.HomeActivities.EmergencyActivity;
import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

//2S add implement Filterable
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVh> implements Filterable {


    private List<UserModel> getUserModelList;
    private List<UserModel> userModelList;
    private Context context;
    int images [];

    public UsersAdapter(List<UserModel> userModelList, int img[])
    {
        this.getUserModelList=userModelList;
        this.userModelList = userModelList;
        this.images = img;
    }

    @NonNull
    @Override
    public UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_users, null));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterVh holder, int position) {

        UserModel userModel = userModelList.get(position);
        String username = userModel.getUserName();
        holder.img.setImageResource(images[position]);
        holder.tvUserName.setText(username);

    }

    @Override
    public int getItemCount() {

        return userModelList.size();
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

                //userModelList = filterResults.values; then cast
                userModelList = (List<UserModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


    public  class UsersAdapterVh extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvUserName;
        TextView selectedUser;

        public UsersAdapterVh(@NonNull View itemView)
        {
            super(itemView);

            tvUserName = itemView.findViewById(R.id.userName);
            img = itemView.findViewById(R.id.images);
            selectedUser=itemView.findViewById(R.id.selectedUser);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position =getAdapterPosition();
                    if (position==0)
                    {
                        Intent intent = new Intent(context , EmergencyActivity.class);
                        context.startActivity(intent);
                    }else if (position==1)
                    {
                        Intent intent = new Intent(context , BleedingActivity.class);
                        context.startActivity(intent);
                    }else
                    {
                        Intent intent = new Intent(context , MainActivity.class);
                        context.startActivity(intent);
                    }
                }
            });





        }
    }
}
