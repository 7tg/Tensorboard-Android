package com.tayyipgoren.mltoolbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

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
        }, 1000);
        /**/
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

    }


}

