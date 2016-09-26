package com.safebaby.vtree.safebaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import com.roger.catloadinglibrary.CatLoadingView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CatLoadingView mView;
    Button btnAction;
    int fileDownloaded = 0;
    ImageView imageView;
    String name_cate = null;
    String [] name_url = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Question question = new Question();
//        ActiveAndroid.beginTransaction();
//        try {
//            for (int i = 0; i < Constant.URLS.length; i++) {
//                Question item = new Question();
//                item.link_image = Constant.URLS[i];
//                item.name_image = "home_" + i;
//                item.link_youtube = "https://www.youtube.com/watch?v=mqWxGB9EOzQ";
//                item.cate_type = "home";
//                item.save();
//            }
//            ActiveAndroid.setTransactionSuccessful();
//        } finally {
//            ActiveAndroid.endTransaction();
//        }
        name_cate = getIntent().getExtras().getString("name_cate").toString();
        name_url= (String[]) getIntent().getSerializableExtra("name_url");
        Toast.makeText(getApplicationContext(),name_cate,Toast.LENGTH_LONG).show();
        mView = new CatLoadingView();
        imageView = (ImageView)findViewById(R.id.imgv);
        // test download
        Button btnDismis  = (Button)findViewById(R.id.btnDismiss);
        btnDismis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.dismiss();
            }
        });
        checkdataExist(name_cate);
//        if(checkdataExist()){
//
//            setImage("home");
//        }
    }

    private FileDownloadListener downloadListener;

    private FileDownloadListener createLis() {
        return new FileDownloadListener() {

            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if (task.getListener() != downloadListener) {
                    return;
                }
            }
            @Override

            protected void connected(BaseDownloadTask task, String etag, boolean isContinue,
                                     int soFarBytes, int totalBytes) {

                super.connected(task, etag, isContinue, soFarBytes, totalBytes);
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

            @Override
            protected void blockComplete(BaseDownloadTask task) {
                if (task.getListener() != downloadListener) {
                    return;
                }

            }

            @Override
            protected void retry(BaseDownloadTask task, Throwable ex, int retryingTimes, int soFarBytes) {
                super.retry(task, ex, retryingTimes, soFarBytes);
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                if (task.getListener() != downloadListener) {
                    return;
                }
                fileDownloaded++;
                if(fileDownloaded == name_url.length){
                    if(!mView.isAdded()){
                        mView.dismiss();
                        setImage(name_cate);
                    }
                    if(!mView.isHidden()){
                        mView.dismiss();
                        setImage(name_cate);
                    }
                }
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                if (task.getListener() != downloadListener) {
                    return;
                }
            }

        };
    }

    /**
     * Check data exist
     * @return
     */
    private boolean checkdataExist(String nameCate){
        String filePath = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + nameCate;
        File file = new File(filePath);
        File list[] = file.listFiles();

        if(file.exists() && file.listFiles().length > 0){
            setImage(nameCate);
            return true;
        } else {
            mView.show(getSupportFragmentManager(),"");
            start();

            return false;
        }
    }


    /**
     * Gep image
     * @return
     */
    private void setImage(String nameCate) {
        String root_sd = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + nameCate ;
        File file = new File(root_sd);
        File list[] = file.listFiles();

        try{
            Picasso.with(getApplicationContext())
                    .load("file://" + root_sd + File.separator + list[0].getName().toString()).resize(96, 96).centerCrop()
                    .into(imageView);
        }catch (ArrayIndexOutOfBoundsException a){

        }
        Toast.makeText(getApplicationContext(),"file://" + root_sd + File.separator +list[2],Toast.LENGTH_LONG).show();
    }

    private boolean start() {
        downloadListener = createLis();
        final FileDownloadQueueSet queueSet = new FileDownloadQueueSet(downloadListener);
        final List<BaseDownloadTask> tasks = new ArrayList<>();
        for (int i = 0; i < name_url.length; i++) {
            tasks.add(FileDownloader.getImpl().create(name_url[i]).setTag(i + 1).setPath(FileDownloadUtils.getDefaultSaveRootPath() + File.separator + name_cate+ File.separator +
                    name_cate + i));
        }
        queueSet.disableCallbackProgressTimes(); // do not want each task's download progress's callback,
        // we just consider which task will completed.

        // auto retry 1 time if download fail
        queueSet.setAutoRetryTimes(0);
        queueSet.downloadTogether(tasks);
        queueSet.start();
        return true;
    }
}
