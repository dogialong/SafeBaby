//package com.safebaby.vtree.safebaby;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//
//import com.safebaby.vtree.safebaby.adapter.DataAdapter;
//
//import java.util.ArrayList;
//
//import static com.safebaby.vtree.safebaby.utils.Constant.URLS;
//
//public class RoomMedalScreen extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private final String medal_cate_names[] = {
//            "Home",
//            "Picnic",
//            "River",
//            "Street",
//            "Park",
//            "Forest",
//            "School",
//            "KitKat",
//            "Lollipop",
//            "Marshmallow"
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_room_medal_screen);
//        initViews();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_medal);
//        recyclerView.addOnItemTouchListener(new SelectCateScreen.RecyclerTouchListener(getApplicationContext(), recyclerView, new SelectCateScreen.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
////                Intent myIntent  = new Intent(SelectCateScreen.this,SelectModePlayScreen.class);
////                startActivity(myIntent);
////                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//
//        }));
//    }
//
//    public interface ClickListener {
//        void onClick(View view, int position);
//
//        void onLongClick(View view, int position);
//    }
//
//    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
//
//        private GestureDetector gestureDetector;
//        private SelectCateScreen.ClickListener clickListener;
//
//        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final SelectCateScreen.ClickListener clickListener) {
//            this.clickListener = clickListener;
//            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public boolean onSingleTapUp(MotionEvent e) {
//                    return true;
//                }
//
//                @Override
//                public void onLongPress(MotionEvent e) {
//                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
//                    if (child != null && clickListener != null) {
//                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
//                    }
//                }
//            });
//        }
//
//        @Override
//        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            View child = rv.findChildViewUnder(e.getX(), e.getY());
//            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
//                clickListener.onClick(child, rv.getChildPosition(child));
//            }
//            return false;
//        }
//
//        @Override
//        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//        }
//
//        @Override
//        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//        }//
//    }
//
//    private void initViews() {
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_medal);
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
//        recyclerView.setLayoutManager(layoutManager);
//
//        ArrayList<AndroidVersion> androidVersions = prepareData();
//        DataAdapter adapter = new DataAdapter(getApplicationContext(), androidVersions);
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    private ArrayList<AndroidVersion> prepareData() {
//        ArrayList<AndroidVersion> android_version = new ArrayList<>();
//        for (int i = 0; i < medal_cate_names.length; i++) {
//            AndroidVersion androidVersion = new AndroidVersion();
//            androidVersion.setAndroid_version_name(medal_cate_names[i]);
//            androidVersion.setAndroid_image_url(URLS[i]);
//            android_version.add(androidVersion);
//        }
//        return android_version;
//    }
//}
