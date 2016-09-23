package com.safebaby.vtree.safebaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SelectPlayerScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player_screen);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_select_player, container, false);

            rootView.findViewById(R.id.btnplayer1).setOnClickListener(this);
            rootView.findViewById(R.id.btnplayer2).setOnClickListener(this);
            rootView.findViewById(R.id.btnplayer3).setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),SelectCateScreen.class);
            startActivity(intent);
        }
    }
}
