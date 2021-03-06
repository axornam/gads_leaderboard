package com.axornam.gads_leaderboard.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.axornam.gads_leaderboard.FragmentLearningHours;
import com.axornam.gads_leaderboard.FragmentSkillsIQ;
import com.axornam.gads_leaderboard.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return FragmentLearningHours.newInstance(position + 1);
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentLearningHours();
                break;
            case 1:
                fragment = new FragmentSkillsIQ();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show total pages.
        return TAB_TITLES.length;
    }
}