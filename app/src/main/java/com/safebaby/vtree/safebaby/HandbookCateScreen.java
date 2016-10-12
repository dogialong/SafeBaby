package com.safebaby.vtree.safebaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.safebaby.vtree.safebaby.Adapter.HandbookAdapter;
import com.safebaby.vtree.safebaby.model.Category_Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NamLong on 10/7/2016.
 */

public class HandbookCateScreen extends Activity {
    List<Category_Item> itemsData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handbook_cate_screen);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cate_handbook);
        // this is data fro recycler view
        itemsData = new ArrayList<>();
        itemsData.add(new Category_Item("Trong nha",R.drawable.sach_trongnha));
        itemsData.add( new Category_Item("duoi nuoc",R.drawable.sach_duoinuoc));
        itemsData.add( new Category_Item("duoi nuoc",R.drawable.sach_songnuoc));
        itemsData.add( new Category_Item("duoi nuoc",R.drawable.sach_tainan));
        itemsData.add( new Category_Item("duoi nuoc",R.drawable.sach_truonghoc));
        itemsData.add( new Category_Item("duoi nuoc",R.drawable.sach_vatnuoi));
        // 2. set layoutManger
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        // 3. create an adapter
        HandbookAdapter mAdapter = new HandbookAdapter(itemsData);
        mAdapter.getItemViewType(1);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Category_Item item = itemsData.get(position);
                Toast.makeText(getApplicationContext(), item.getImageCatel() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(HandbookCateScreen.this, HandbookItemScreen.class);
                startActivity(in);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
