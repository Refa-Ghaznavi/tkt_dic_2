package com.example.tkt_dic_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SearchView searchBars;
    ImageButton ibSearches;
    TextView tvMeanings;
    TextView tvMeaningsDaris;
    String searchedText;
    TextToSpeech textToSpeech;

    //String search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        searchBars = findViewById(R.id.searchBar);
        ibSearches = findViewById(R.id.ibSearch);
        tvMeanings = findViewById(R.id.tvMeaning);
        tvMeaningsDaris = findViewById(R.id.tvMeaning_dari);

        searchBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBars.setIconified(false);
            }
        });


        searchBars.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchedText=query;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               searchedText=newText;
                return false;
            }
        });


        ibSearches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(searchedText))
                {
                    Toast.makeText(MainActivity.this, "No Empty Keyword", Toast.LENGTH_SHORT).show();

                } else {
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("meaning");
                    mRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String searchKeyword = searchedText;

                            Log.d("data", "onDataChange: "+dataSnapshot.getKey());

                            if (dataSnapshot.child(searchKeyword).exists()) {
                                tvMeanings.setText(dataSnapshot.child(searchKeyword).getValue()+"");
                            } else {
                                Toast.makeText(MainActivity.this, "No Search result found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("meaning_Dari");
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String searchKeyword = searchedText;

                            Log.d("data", "onDataChange: "+dataSnapshot.getKey());

                            if (dataSnapshot.child(searchKeyword).exists()) {
                                tvMeaningsDaris.setText(dataSnapshot.child(searchKeyword).getValue()+"");
                            } else {
                                Toast.makeText(MainActivity.this, "No Search result found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }
        });


        // this is for setting activity to go another activity
        ImageButton imageButton=findViewById(R.id.ibSettings);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Setting.class);
                startActivity(intent);
            }
        });

        // this is for adding text to speech functionality
        ImageButton imageButton2=findViewById(R.id.ibVolume);

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // if there is no error then set the language
                if(status!=TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get text from searchView
               String search=searchedText;
               // String search2 = search;
              //  search.setText.search2.getValue()+"");

               // convert text to speech
                textToSpeech.speak(search,TextToSpeech.QUEUE_FLUSH,null);
            }
        });



    }

    @Override
    protected void onPause() {
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}
