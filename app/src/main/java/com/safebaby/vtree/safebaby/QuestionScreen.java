package com.safebaby.vtree.safebaby;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class QuestionScreen extends Activity {

    private Button btnYes,btnNo;
    //Create a dialog object, that will contain the WebView
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        btnYes = (Button) findViewById(R.id.btnYes);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setTitle("Result video");
                WebView wv = new WebView(v.getContext());

//                final String mimeType = "text/html";
//                final String encoding = "UTF-8";
//                final String html = " <frameset><frame src='https://www.youtube.com/watch?v=mqWxGB9EOzQ'></frameset>";
//                wv.loadDataWithBaseURL(null, html, mimeType, encoding, "");
//
                alert.setView(wv);
////                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int id) {
////                        dialog.dismiss();
////                    }
////                });


                wv.setWebViewClient(new WebViewClient(){
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        if (url != null && url.startsWith("https://www.youtube.com/watch?v=mqWxGB9EOzQ")) {
                            view.getContext().startActivity(
                                    new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                alert.show();
            }
        });


    }
}
