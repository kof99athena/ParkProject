package com.nha1400.project02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_Main extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); //splash 할때 statusBar까지 포함해서 노출한다.

        new Handler().postDelayed(()->{ //왜 핸들러를쓸까? 시간을 제한할때 많이쓰는 방법. UI작업도 할수있다.
            Intent intent=new Intent(Splash_Main.this,MainActivity.class);
            startActivity(intent);

        },2000); //(  런어블객체(인텐트) ,  2초   );
    }
}
