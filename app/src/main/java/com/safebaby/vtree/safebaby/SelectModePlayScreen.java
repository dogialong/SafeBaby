package com.safebaby.vtree.safebaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectModePlayScreen extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
    private Button btnQuestion,btnFlashcard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode_play);
        btnQuestion = (Button)findViewById(R.id.btnQuestion);
        btnFlashcard =(Button)findViewById(R.id.btnFlashcard);
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SelectModePlayScreen.this,QuestionCateScreen.class);
                startActivity(in);
            }
        });
        btnFlashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SelectModePlayScreen.this,FlashCardScreen.class);
                startActivity(in);
            }
        });
    }
}
