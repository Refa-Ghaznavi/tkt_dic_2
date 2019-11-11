package com.example.tkt_dic_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Setting extends AppCompatActivity{


    int[] itemImage={R.drawable.ic_1_airplay,R.drawable.ic_2_alpha,R.drawable.ic_3_voice,R.drawable.ic_4_find,R.drawable.ic_5_cached,R.drawable.ic_6_account,R.drawable.ic_7_exit};
    String[] itemName={"Themes","Fonts","Voice","Popup Menu","Update","About","Exit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvList=findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));


        rvList.setAdapter(new UserAdapter(itemImage,itemName,Setting.this));

        ImageButton backs=findViewById(R.id.ivBack);

        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
