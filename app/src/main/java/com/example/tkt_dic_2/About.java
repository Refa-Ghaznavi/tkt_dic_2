package com.example.tkt_dic_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.net.Uri;

public class About extends AppCompatActivity {

    ImageButton imageButtonFb;
    ImageButton imageButtonIn;
    ImageButton imageButtonPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //imageView=findViewById(R.id.imageView3);
        imageButtonFb=findViewById(R.id.imageButtonFb);

        imageButtonIn=findViewById(R.id.imageButtonIn);

        imageButtonPs=findViewById(R.id.imageButtonPs);



//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent("android.intent.action.VIEW", Uri.parse("https://fb.me/Refah.11"));
//                About.this.startActivity(intent);
//            }
//        });

        imageButtonFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://facebook.com/Refah.11"));
                startActivity(intent);
            }
        });
        imageButtonIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/"));
                startActivity(intent);
            }
        });
        imageButtonPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://playstore.com/"));
                startActivity(intent);
            }
        });
    }
}

