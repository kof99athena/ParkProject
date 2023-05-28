package com.nha1400.project02.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.kakao.util.maps.helper.Utility;
import com.nha1400.project02.R;
import com.nha1400.project02.presenter.ParkContract;

public class MainActivity extends AppCompatActivity implements ParkContract.main{

    Tab1Fragment tab1Fragment;
    Tab2Fragment tab2Fragment;
    NavigationBarView navigationBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1Fragment=new Tab1Fragment();
        tab2Fragment=new Tab2Fragment();
        navigationBarView=findViewById(R.id.bottomview);

        String keyhash= Utility.getKeyHash(this);
        Log.i("keyHash",keyhash);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,tab1Fragment).commit();
        mainStart();

    }//onCreate method

    @Override
    public void mainStart() {

        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override //MenuItem item은 누구냐? item은 @menu에 만든 버텀뷰의 하나
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,tab1Fragment).commit();
                        return true;

                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,tab2Fragment).commit();
                        return true;
                }

                return false;
            }
        });

    }

}//MainActivity class