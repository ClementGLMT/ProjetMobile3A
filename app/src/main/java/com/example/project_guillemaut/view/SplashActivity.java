package com.example.project_guillemaut.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_guillemaut.R;
import com.example.project_guillemaut.controller.Controller;
import com.example.project_guillemaut.view.MainActivity;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {

    private TextView textview;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textview = (TextView) findViewById(R.id.textView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
        textview.startAnimation(anim);
        controller = new Controller();
        controller.start(this);
    }
}
