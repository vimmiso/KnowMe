package com.example.db_stud;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PagerViewadpater extends FragmentPagerAdapter {
    public PagerViewadpater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

//        Fragment fragment = null;

        switch (i)
        {
            case 0:
               return new fragment_personal();
            case 1:
                return new fragment_educational();
            case 2:
                return new fragment_skills();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


}
