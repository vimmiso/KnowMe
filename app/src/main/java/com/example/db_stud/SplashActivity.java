package com.example.db_stud;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private static int spashTimeout=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo=(ImageView)findViewById(R.id.img_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginAcitivity.class);
                startActivity(intent);
                finish();
            }
        },spashTimeout);

        Animation myanim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.mysplashanimation);
        logo.startAnimation(myanim);

    }

}
