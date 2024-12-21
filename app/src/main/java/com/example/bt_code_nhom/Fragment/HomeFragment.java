package com.example.bt_code_nhom.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bt_code_nhom.Model.Photo;
import com.example.bt_code_nhom.Adapter.MovieViewPagerAdapter;
import com.example.bt_code_nhom.Adapter.PhotoAdapter;
import com.example.bt_code_nhom.Model.Photo;
import com.example.bt_code_nhom.R;
import com.example.bt_code_nhom.Widget.CustomViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ViewPager2 mViewPager2;
    private List<Photo> mListPhoto;
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private View mView;
    private TextView tvLocation;
    private Button btnXemTiep;
    private String selectedLocation = "Toàn quốc";
    private Handler mHandler= new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mViewPager2.getCurrentItem();
            if (currentPosition == mListPhoto.size()-1){
                mViewPager2.setCurrentItem(0);
            }
            else {
                mViewPager2.setCurrentItem(currentPosition+1);
            }
        }
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = mView.findViewById(R.id.tab_layout);
        viewPager = mView.findViewById(R.id.movie_viewpager);
        MovieViewPagerAdapter viewPagerAdapter= new MovieViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ,false,false);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);

        tvLocation = mView.findViewById(R.id.tv_location);
        tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationDialog(); // Gọi phương thức để hiển thị hộp thoại chọn vị trí
            }
        });
        return mView;
    }

    private void showLocationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Vị trí");

        // Tạo danh sách các địa điểm
        String[] locations = {"Toàn quốc", "TP Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "An Giang",
                "Bà Rịa - Vũng Tàu", "Bến Tre", "Cà Mau", "Đắk Lắk", "Hải Phòng",
                "Khánh Hòa", "Nghệ An"};

        // Mảng boolean lưu trạng thái chọn
        int checkedItem = -1; // Không có lựa chọn mặc định

        // Set danh sách radio button
        builder.setSingleChoiceItems(locations, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lưu vị trí được chọn vào biến selectedLocation
                selectedLocation = locations[which];
            }
        });

        // Thêm nút Xác nhận
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cập nhật TextView với địa điểm đã chọn
                tvLocation.setText(selectedLocation);
            }
        });

        // Thêm nút Đóng
        builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Hiển thị dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.image_run_1));
        list.add(new Photo(R.drawable.image_run_4));
        list.add(new Photo(R.drawable.image_run_5));
        list.add(new Photo(R.drawable.image_run_2));
        list.add(new Photo(R.drawable.image_run_3));
        list.add(new Photo(R.drawable.image_run_6));

        return list;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager2 = view.findViewById(R.id.vp_silderimage);


        //setting mViewPager(slider)
        mViewPager2.setOffscreenPageLimit(3);
        mViewPager2.setClipToPadding(false);
        mViewPager2.setClipChildren(false);

        CompositePageTransformer compositePageTransformer = getCompositePageTransformer();
        mViewPager2.setPageTransformer(compositePageTransformer);

        mListPhoto = getListPhoto();
        PhotoAdapter photoAdapter = new PhotoAdapter(mListPhoto);
        mViewPager2.setAdapter(photoAdapter);


        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 3000);
            }
        });


    }

    private static @NonNull CompositePageTransformer getCompositePageTransformer() {
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        return compositePageTransformer;
    }

}