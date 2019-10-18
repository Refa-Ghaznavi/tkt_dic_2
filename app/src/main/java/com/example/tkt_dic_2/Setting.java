package com.example.tkt_dic_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


public class Setting extends AppCompatActivity{


    int[] itemImage={R.drawable.ic_1_airplay,R.drawable.ic_2_alpha,R.drawable.ic_3_voice,R.drawable.ic_4_find,R.drawable.ic_5_cached};
    String[] itemName={"Themes","Fonts","Voice","Popup Window","Update"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RecyclerView rvList=findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));


        rvList.setAdapter(new UserAdapter(itemImage,itemName));




    }
}
