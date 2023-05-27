package com.nha1400.project02.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.kakao.util.maps.helper.Utility;
import com.nha1400.project02.R;
import com.nha1400.project02.Tab2Fragment;
import com.nha1400.project02.view.Tab1Fragment;

public class MainActivity extends AppCompatActivity {

    //키 해시값 얻어오기

    Tab1Fragment tab1Fragment;
    Tab2Fragment tab2Fragment;
    NavigationBarView navigationBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String keyhash= Utility.getKeyHash(this);
        Log.i("keyHash",keyhash);


        tab1Fragment=new Tab1Fragment();
        tab2Fragment=new Tab2Fragment();



        //시작할때 처음 화면에 보여줄 뷰를 지정한다. FragmentManager
        //내가 궁금한거 : 왜 import도 안되있는데 FragmentManager get으로 가져올수있냐? import도 안되있는데
        //모든 FragmentActivity 및 subclass(AppcompatActivity)는 getSupportFragmentManager()를 통해
        //FragmentManager를 소환할수있다.
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,tab1Fragment).commit();


        navigationBarView=findViewById(R.id.bottomview);
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



    }//onCreate method

}//MainActivity class