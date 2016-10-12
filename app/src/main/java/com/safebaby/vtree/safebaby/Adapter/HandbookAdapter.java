package com.safebaby.vtree.safebaby.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.safebaby.vtree.safebaby.R;
import com.safebaby.vtree.safebaby.model.Category_Item;

import java.util.List;

/**
 * Created by NamLong on 10/7/2016.
 */

public class HandbookAdapter extends RecyclerView.Adapter<HandbookAdapter.MainViewHolder> {
    List<Category_Item> category_item;
    Context context;
    private static final int TYPE_PROFILE = 1;
    private static final int TYPE_OPTION_MENU = 2;
    public HandbookAdapter(List<Category_Item> context){
        this.category_item = context;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0? TYPE_PROFILE : TYPE_OPTION_MENU);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
//            case TYPE_PROFILE:
//                return new HandbookItemHolder(LayoutInflater.from(context).inflate(R.layout.item_handbook, parent, false));
            case TYPE_OPTION_MENU:
                return new HandbookCateHolder(LayoutInflater.from(context).inflate(R.layout.item_cate_handbook, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_PROFILE){
            HandbookItemHolder mholder = (HandbookItemHolder) holder;
            mholder.imgHandbookItem.setImageResource(category_item.get(position).getImageCatel());

        }
        else {
            HandbookCateHolder mHolder = (HandbookCateHolder) holder;
         //   Category_Item mo = category_item.get(position);
            mHolder.imgHandbookCate.setImageResource(R.drawable.cate_congvien);
         //   mHolder.itemView.setSelected(selectedPos == position);
        }
    }

    @Override
    public int getItemCount() {
        return category_item.size();
    }




    public class HandbookCateHolder extends MainViewHolder{
        ImageView imgHandbookCate;
        public HandbookCateHolder(View v){
            super(v);
            this.imgHandbookCate = (ImageView) v.findViewById(R.id.imgHandBook);
        }
    }
    public class HandbookItemHolder extends MainViewHolder{
        ImageView imgHandbookItem;

        public HandbookItemHolder(View v){
            super(v);
            this.imgHandbookItem = (ImageView) v.findViewById(R.id.img_content_handbook);
        }
    }
    
    public class MainViewHolder extends  RecyclerView.ViewHolder {
        public MainViewHolder(View v) {
            super(v);
        }
    }


}