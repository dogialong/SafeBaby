//package com.safebaby.vtree.safebaby.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.safebaby.vtree.safebaby.AndroidVersion;
//import com.safebaby.vtree.safebaby.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//import static com.safebaby.vtree.safebaby.R.id.img_android;
//import static com.safebaby.vtree.safebaby.R.id.tv_android;
//
///**
// * Created by NamLong on 9/23/2016.
// */
//
//public class DataAdapterMedal extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
//    private ArrayList<AndroidVersion> android;
//    private Context context;
//
//    public DataAdapterMedal(Context context,ArrayList<AndroidVersion> android){
//        this.android = android;
//        this.context = context;
//    }
//    @Override
//    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_select_cate, viewGroup, false);
//        return new DataAdapterMedal().ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
//
//        viewHolder.tv_medal(android.get(i).getAndroid_version_name());
//        Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(400, 300).into(viewHolder.img_medal);
//    }
//
//    @Override
//    public int getItemCount() {
//        return android.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        private TextView tv_medal;
//        private ImageView img_medal;
//        public ViewHolder(View view) {
//            super(view);
//            tv_android = (TextView)view.findViewById(tv_medal);
//            img_android = (ImageView) view.findViewById(img_medal);
//        }
//    }
//}
