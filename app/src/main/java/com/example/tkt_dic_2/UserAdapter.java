package com.example.tkt_dic_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    Context context;

    private int [] images;
    private String [] titles;
    public UserAdapter(int [] images, String [] titles, Context context){

        this.images=images;
        this.titles=titles;
        this.context=context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.user_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        int img=images[position];
        holder.ivIcon.setImageResource(img);

        String title=titles[position];
        holder.tvTitle.setText(title);


        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0){
                    Intent intent = new Intent(context, Fonts.class);
                    context.startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(context, Voice.class);
                    context.startActivity(intent);
                }
                else if (position==2){
                    Intent intent = new Intent(context, NightMode.class);
                    context.startActivity(intent);
                }
                else if (position==3){
                    Intent intent = new Intent(context, PopupMenu.class);
                    context.startActivity(intent);
                }
                else if (position ==4) {
                    Intent intent = new Intent(context,About.class);
                    context.startActivity(intent);
                }
                else if (position ==5) {
                    Intent intent = new Intent(context,Exit.class);
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvTitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}
