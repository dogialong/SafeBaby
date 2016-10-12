package com.safebaby.vtree.safebaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.safebaby.vtree.safebaby.Adapter.QuestionCateAdapter;

/**
 * Created by NamLong on 10/10/2016.
 */

public class QuestionCateScreen extends Activity {
    DataQuesionCate[] itemsData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_question_screen);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cate_question);
        // this is data fro recycler view
        itemsData = new DataQuesionCate[]{new DataQuesionCate(R.drawable.cate_trongnha),
                new DataQuesionCate(R.drawable.cate_songnuoc),
                new DataQuesionCate(R.drawable.cate_congvien),
                new DataQuesionCate(R.drawable.cate_giaothong),
                new DataQuesionCate(R.drawable.cate_rungram)};
        // 2. set layoutManger
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        // 3. create an adapter
        QuestionCateAdapter mAdapter = new QuestionCateAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                DataQuesionCate item = itemsData[position];
                Toast.makeText(getApplicationContext(), item.getimageUrl() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(QuestionCateScreen.this, QuestionScreen.class);
                startActivity(in);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
