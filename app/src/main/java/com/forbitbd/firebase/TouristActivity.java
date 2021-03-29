package com.forbitbd.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.forbitbd.firebase.adapter.TabFragAdapter;
import com.forbitbd.firebase.fragments.HotelFragment;
import com.forbitbd.firebase.fragments.PlaceFragment;
import com.forbitbd.firebase.fragments.RestaurantFragment;
import com.google.android.material.tabs.TabLayout;

public class TouristActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private HotelFragment hotelFragment;
    private RestaurantFragment restaurantFragment;
    private PlaceFragment placeFragment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        int[] imageResId = {
                R.drawable.baseline_local_activity_24,
                R.drawable.baseline_hotel_24,
                R.drawable.baseline_local_dining_24,
        };

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        placeFragment = new PlaceFragment();
        hotelFragment = new HotelFragment();
        restaurantFragment = new RestaurantFragment();
        tabLayout.setupWithViewPager(viewPager);
        TabFragAdapter viewPagerAdapter = new TabFragAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(placeFragment, "Places Of Interest");
        viewPagerAdapter.addFragment(hotelFragment, "Hotels");
        viewPagerAdapter.addFragment(restaurantFragment, "Restaurants");
        viewPager.setAdapter(viewPagerAdapter);

        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }
    }
}