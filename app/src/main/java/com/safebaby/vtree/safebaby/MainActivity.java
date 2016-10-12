package com.safebaby.vtree.safebaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnParent,btnKid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParent = (Button) findViewById(R.id.btnParrent);
        btnKid = (Button) findViewById(R.id.btnKid);
        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,HandbookCateScreen.class);
                startActivity(in);
                finish();
            }
        });
        btnKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,SelectModePlayScreen.class);
                startActivity(in);
            }
        });
    }
}