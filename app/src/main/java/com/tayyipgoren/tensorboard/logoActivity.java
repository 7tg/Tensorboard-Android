package com.tayyipgoren.tensorboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.RunnableFuture;

public class logoActivity extends AppCompatActivity {

    @Override
    protected void onResume() {

        super.onResume();
        ProgressBar pg = (ProgressBar) findViewById(R.id.progressBar);
        pg.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(logoActivity.this, MainActivity.class);
                startActivity(intent);
                ;
            }
        }, 3000);
        /**/
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

    }


}

