package com.example.db_stud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {

      R.drawable.db,
      R.drawable.frame,
//      R.drawable.db

    };

    public String[] slide_headimages = {
      "Hello 1",
      "Hello 2",
//      "Hello 3"
    };

    public String[] slide_define = {
      "The medicine used for common ailments are stored by many households for emergency use. Many times these medicine expire despite being stored under prescribed conditions and become useless. The proposal brings in usage of technology to reuse medicine in hassle free manner.",
      "The medicine used for common ailments are stored by many households for emergency use. Many times these medicine expire despite being stored under prescribed conditions and become useless. The proposal brings in usage of technology to reuse medicine in hassle free manner.",
//      "The medicine used for common ailments are stored by many households for emergency use. Many times these medicine expire despite being stored under prescribed conditions and become useless. The proposal brings in usage of technology to reuse medicine in hassle free manner."
    };
    @Override
    public int getCount() {
        return slide_define.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layoutt,container,false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.img_logo);
        TextView slideTextview = (TextView)view.findViewById(R.id.txtDefine);

        slideImageView.setImageResource(slide_images[position]);
        slideTextview.setText(slide_define[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
