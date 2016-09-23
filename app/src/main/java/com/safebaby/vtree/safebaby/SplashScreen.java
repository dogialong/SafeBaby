package com.safebaby.vtree.safebaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.safebaby.vtree.safebaby.utils.Constant;

import java.io.Serializable;

public class SplashScreen extends AppCompatActivity {
    Button btnPicnic,btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        btnPicnic = (Button)findViewById(R.id.btnPicnic);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnPicnic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                i.putExtra("name_cate","picnic");
                i.putExtra("name_url",Constant.URLS_PICNIC);
                startActivity(i);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                i.putExtra("name_cate","home");
                i.putExtra("name_url", (Serializable) Constant.URLS_HOME);
                startActivity(i);
            }
        });
    }
}
