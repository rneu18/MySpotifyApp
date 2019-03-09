package com.example.myspotifyapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    TextView tv_fact, tv_type;
    final String Base_Url ="https://cat-fact.herokuapp.com";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // tv_type = findViewById(R.id.tv_fact);
      //  tv_fact = findViewById(R.id.tv_type);
        initializedRetrofit();


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new RockFragment(), "Rock");
        adapter.addFragment(new ClassicFragment(), "Classic");
        adapter.addFragment(new PopFragment(), "Pop");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void initializedRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
        interfaceApi.getRandomSongs().enqueue(new Callback<SongsDescription>() {
            @Override
            public void onResponse(Call<SongsDescription> call, Response<SongsDescription> response) {
                //tv_fact.setText(response.body().getText());
               // tv_type.setText(response.body().getType());
            }

            @Override
            public void onFailure(Call<SongsDescription> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}