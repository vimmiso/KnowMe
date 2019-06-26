package com.example.db_stud;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Slide_Activity extends AppCompatActivity {

    private ViewPager SlideViewPager;
    private LinearLayout DotLayout;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_);

        SlideViewPager = (ViewPager)findViewById(R.id.Vp_slide);
        DotLayout = (LinearLayout)findViewById(R.id.layout_dots);

        sliderAdapter = new SliderAdapter(Slide_Activity.this);

        SlideViewPager.setAdapter(sliderAdapter);
    }
}
