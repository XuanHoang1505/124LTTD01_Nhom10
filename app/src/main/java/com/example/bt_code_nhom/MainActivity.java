package com.example.bt_code_nhom;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bt_code_nhom.Adapter.ViewPagerAdapter;
import com.example.bt_code_nhom.Fragment.AccountFragment;
import com.example.bt_code_nhom.Fragment.CinemaFragment;
import com.example.bt_code_nhom.Fragment.CommentFragment;
import com.example.bt_code_nhom.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 view_pager;
    private BottomNavigationView bottom_nav;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        view_pager = findViewById(R.id.view_pager);
        bottom_nav = findViewById(R.id.bottom_nav);
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new CinemaFragment());
        fragmentArrayList.add(new CommentFragment());
        fragmentArrayList.add(new AccountFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, fragmentArrayList);
        view_pager.setAdapter(adapter);

        view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottom_nav.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottom_nav.getMenu().findItem(R.id.menu_cinema).setChecked(true);
                        break;
                    case 2:
                        bottom_nav.getMenu().findItem(R.id.menu_movie).setChecked(true);
                        break;
                    case 3:
                        bottom_nav.getMenu().findItem(R.id.menu_account).setChecked(true);
                        break;
                }
            }
        });

        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_home) {
                    view_pager.setCurrentItem(0);
                    return true;
                } else if (itemId == R.id.menu_cinema) {
                    view_pager.setCurrentItem(1);
                    return true;
                } else if (itemId == R.id.menu_movie) {
                    view_pager.setCurrentItem(2);
                    return true;
                } else if (itemId == R.id.menu_account) {
                    view_pager.setCurrentItem(3);
                    return true;
                }
                return false;
            }
        });
    }
}
