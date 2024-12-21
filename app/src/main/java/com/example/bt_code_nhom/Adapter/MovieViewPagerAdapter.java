package com.example.bt_code_nhom.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bt_code_nhom.Fragment.CommentFragment;
import com.example.bt_code_nhom.Fragment.ShowingFragment;

public class MovieViewPagerAdapter extends FragmentPagerAdapter {
    private boolean isForViewMore;
    private boolean isForMovie; // New flag for the new TabLayout

    public MovieViewPagerAdapter(@NonNull FragmentManager fm, int behavior, boolean isForViewMore, boolean isForMovie) {
        super(fm, behavior);
        this.isForViewMore = isForViewMore;
        this.isForMovie = isForMovie;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (isForMovie) {
            // Fragments for new TabLayout (Comment, News, Characters)
            switch (position) {
                case 0:
                    return new CommentFragment();

                default:
                    return new CommentFragment();
            }

        } else {
            // Fragments for HomeFragment
            switch (position) {
                case 0:
                    return new ShowingFragment();
                default:
                    return new ShowingFragment();
            }
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (isForMovie) {
            switch (position) {
                case 0:
                    return "Bình luận";
                case 1:
                    return "Blog điện ảnh";

            }
        } else {
            switch (position) {
                case 0:
                    return "Đang chiếu";
                case 1:
                    return "Sắp chiếu";
            }
        }
        return null;
    }
}
