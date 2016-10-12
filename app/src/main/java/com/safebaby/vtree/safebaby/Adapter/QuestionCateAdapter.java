package com.safebaby.vtree.safebaby.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.safebaby.vtree.safebaby.DataQuesionCate;
import com.safebaby.vtree.safebaby.R;

/**
 * Created by NamLong on 10/10/2016.
 */

public class QuestionCateAdapter extends RecyclerView.Adapter<QuestionCateAdapter.ViewHolder> {
    private DataQuesionCate[] itemsData;

    public QuestionCateAdapter(DataQuesionCate[] itemsData) {
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QuestionCateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cate_question, null);

        // create ViewHolder

        QuestionCateAdapter.ViewHolder viewHolder = new QuestionCateAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(QuestionCateAdapter.ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.imgCateQuestion.setImageResource(itemsData[position].getimageUrl());
//        viewHolder.imgStar1.setImageResource(itemsData[position].getimageUrl());
//        viewHolder.imgStar2.setImageResource(itemsData[position].getimageUrl());
//        viewHolder.imgStar3.setImageResource(itemsData[position].getimageUrl());
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgCateQuestion,imgStar1,imgStar2,imgStar3;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            imgCateQuestion = (ImageView) itemLayoutView.findViewById(R.id.imgCateQuestion);
            imgStar1 = (ImageView) itemLayoutView.findViewById(R.id.imgStarPoint1);
            imgStar2 = (ImageView) itemLayoutView.findViewById(R.id.imgStarPoint2);
            imgStar3 = (ImageView) itemLayoutView.findViewById(R.id.imgStarPoint3);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}