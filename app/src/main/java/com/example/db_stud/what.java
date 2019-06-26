package com.example.db_stud;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class what extends AppCompatActivity implements CallBackInterface {

    TextView personal, educational, skills;
    EditText dob;
    PagerViewadpater pagerViewadpater;
    Calendar c;
    DatePickerDialog dpd;
    FrameLayout viewPager;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        personal = (TextView) findViewById(R.id.per);
        educational = (TextView) findViewById(R.id.edu);
        skills = (TextView) findViewById(R.id.ski);
        viewPager = (FrameLayout) findViewById(R.id.fragment_container);

        fragmentManager = getSupportFragmentManager();


        pagerViewadpater = new PagerViewadpater(fragmentManager);
        addFragmentPersonal();

//        viewPager.setAdapter(pagerViewadpater);
//        viewPager.disableScroll(false);
//        abc.disableScroll(false);
    }
//        if(viewPager.getCurrentItem()==0) {
//            abc.disableScroll(false);
////                    viewPager.setCurrentItem(0);
////            onChangeTab(0);
//            personal.setTextSize(18);
//            personal.setTextColor(getColor(R.color.bright_color));
//
//            educational.setTextSize(15);
//            educational.setTextColor(getColor(R.color.light_color));
//
//            skills.setTextSize(15);
//            skills.setTextColor(getColor(R.color.light_color));
//
//            Button b1 = (Button)viewPager.findViewById(R.id.btView);
//            b1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    viewPager.setCurrentItem(1);
////                    onChangeTab(1);
//                    personal.setTextSize(17);
//                    personal.setTextColor(getColor(R.color.light_color));
//
//                    educational.setTextSize(18);
//                    educational.setTextColor(getColor(R.color.bright_color));
//                    skills.setTextSize(15);
//                    skills.setTextColor(getColor(R.color.light_color));
//
//                    if (viewPager.getCurrentItem() == 1) {
//                        Button b2 = (Button)viewPager.findViewById(R.id.btEadd);
//                        b2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                viewPager.setCurrentItem(2);
////                                onChangeTab(2);
//                                personal.setTextSize(17);
//                                personal.setTextColor(getColor(R.color.light_color));
//                                educational.setTextSize(15);
//                                educational.setTextColor(getColor(R.color.light_color));
//
//                                skills.setTextSize(18);
//                                skills.setTextColor(getColor(R.color.bright_color));
//
//
//                                if (viewPager.getCurrentItem() == 2) {
//                                    Button b3 = (Button) findViewById(R.id.btSave);
//                                    b3.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            Intent intent = new Intent(what.this, pdfAcitivity.class);
//                                            startActivity(intent);
//                                        }
//                                    });
//
//                                }
//                            }
//                        });
//                    }
//                }
//            });
//        }
//    }
//}

//        viewPager.setPageingEnabled(false);

//        personal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(0);
//            }
//        });
//
//        educational.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(1);
//            }
//        });
//
//        skills.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(2);
//            }
//        });
//


//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onPageSelected(int i) {
//
//                onChangeTab(i);
////                if(viewPager.getCurrentItem()==0) {
//////                    viewPager.setCurrentItem(0);
////                    onChangeTab(i);
////                    Button b1 = (Button)findViewById(R.id.btView);
////                    b1.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View v) {
////                            viewPager.setCurrentItem(1);
////                            onChangeTab(1);
////                            if(viewPager.getCurrentItem()==1){
////                                Button b2 = (Button)findViewById(R.id.btEadd);
////                                b2.setOnClickListener(new View.OnClickListener() {
////                                    @Override
////                                    public void onClick(View v) {
////                                        viewPager.setCurrentItem(2);
////                                        onChangeTab(2);
////                                        if(viewPager.getCurrentItem()==2){
////                                            Button b3 = (Button)findViewById(R.id.btSave);
////                                            b3.setOnClickListener(new View.OnClickListener() {
////                                                @Override
////                                                public void onClick(View v) {
////                                                    Intent intent = new Intent(what.this,pdfAcitivity.class);
////                                                    startActivity(intent);
////                                                }
////                                            });
////
////                                        }
////                                    }
////                                });
////                            }
////
////
////                        }
////                    });
////
////                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @SuppressLint("ResourceAsColor")
//            private void onChangeTab(int i) {
//
//                if(i==0){
//                    dob = (EditText)findViewById(R.id.etDateofBirth);
//                    dob.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            c = Calendar.getInstance();
//                            int day = c.get(Calendar.DAY_OF_MONTH);
//                            int month = c.get(Calendar.MONTH);
//                            int year = c.get(Calendar.YEAR);
//
//                            dpd = new DatePickerDialog(what.this, new DatePickerDialog.OnDateSetListener() {
//                                @Override
//                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                    dob.setText(dayOfMonth+"/"+(month+1)+"/"+year);
//                                }
//                            },day,month,year);
//                            dpd.show();
//                        }
//                    });
//
//
//                    personal.setTextSize(18);
//                    personal.setTextColor(getColor(R.color.bright_color));
//
//                    educational.setTextSize(15);
//                    educational.setTextColor(getColor(R.color.light_color));
//
//                    skills.setTextSize(15);
//                    skills.setTextColor(getColor(R.color.light_color));
//
//
//                }else if(i==1){
//                    personal.setTextSize(17);
//                    personal.setTextColor(getColor(R.color.light_color));
//
//                    educational.setTextSize(18);
//                    educational.setTextColor(getColor(R.color.bright_color));
//
//                    skills.setTextSize(15);
//                    skills.setTextColor(getColor(R.color.light_color));
//                }else{
//                    personal.setTextSize(17);
//                    personal.setTextColor(getColor(R.color.light_color));
//
//                    educational.setTextSize(15);
//                    educational.setTextColor(getColor(R.color.light_color));
//
//                    skills.setTextSize(18);
//                    skills.setTextColor(getColor(R.color.bright_color));
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//    }
//    boolean bundle = getIntent().getExtras().getBoolean("Check");


        @RequiresApi(api = Build.VERSION_CODES.M)
        private void addFragmentPersonal () {
            personal.setTextSize(18);
            personal.setTextColor(getColor(R.color.bright_color));

            educational.setTextSize(15);
            educational.setTextColor(getColor(R.color.light_color));

            skills.setTextSize(15);
            skills.setTextColor(getColor(R.color.light_color));

            fragmentTransaction = fragmentManager.beginTransaction();

            fragment_personal fragPer = new fragment_personal();
            fragPer.setCallBackInterface(this);

            fragmentTransaction.replace(R.id.fragment_container, fragPer);
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        @RequiresApi(api = Build.VERSION_CODES.M)
        private void addFragmentEducational () {
            personal.setTextSize(17);
            personal.setTextColor(getColor(R.color.light_color));

            educational.setTextSize(18);
            educational.setTextColor(getColor(R.color.bright_color));
            skills.setTextSize(15);
            skills.setTextColor(getColor(R.color.light_color));

            fragmentTransaction = fragmentManager.beginTransaction();

            fragment_educational fragPer = new fragment_educational();
            fragPer.setCallBackInterface(this);

            fragmentTransaction.replace(R.id.fragment_container, fragPer);
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        @RequiresApi(api = Build.VERSION_CODES.M)
        private void addFragmentSkills () {
            personal.setTextSize(17);
                    personal.setTextColor(getColor(R.color.light_color));

                    educational.setTextSize(15);
                    educational.setTextColor(getColor(R.color.light_color));

                    skills.setTextSize(18);
                    skills.setTextColor(getColor(R.color.bright_color));

            fragmentTransaction = fragmentManager.beginTransaction();

            fragment_skills fragPer = new fragment_skills();

            fragmentTransaction.replace(R.id.fragment_container, fragPer);
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        private void addAcitivity(){
        Intent intent = new Intent(this,pdfAcitivity.class);
        startActivity(intent);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void callBackMethod1() {
//            Toast.makeText(this, "ToDo: Trigger Educational Fragment", Toast.LENGTH_SHORT).show();
            addFragmentEducational();
        }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
        public void callBackMethod2() {
//        Toast.makeText(this, "ToDo: Trigger Skills Fragment", Toast.LENGTH_SHORT).show();
        addFragmentSkills();
    }

    public void callBackMethod3(){
//        Toast.makeText(this,"ToDo: Trigger activity Fragment ",Toast.LENGTH_SHORT).show();
        addAcitivity();
    }
    }
