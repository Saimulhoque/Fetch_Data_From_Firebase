package com.forbitbd.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.forbitbd.firebase.adapter.SliderAdapter;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialCardView card1,card7,card9, card10;
    private ViewPager viewPager;
    int images[] = {R.drawable.ggg,R.drawable.one,R.drawable.three,R.drawable.two,R.drawable.four};
    int currentPageCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card1 = findViewById(R.id.aboutsandwip);
        card7 = findViewById(R.id.police);
        card9 = findViewById(R.id.tourist);
        card10 = findViewById(R.id.news);

        card1.setOnClickListener(this);
        card7.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);

        viewPager = findViewById(R.id.slideview);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new SliderAdapter(images, HomeActivity.this));
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCounter == images.length) {
                    currentPageCounter = 0;
                }
                viewPager.setCurrentItem(currentPageCounter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 4000, 4000);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.police){
            Intent intent = new Intent(HomeActivity.this,PoliceActivity.class);
            startActivity(intent);
        }else if (id == R.id.news){
            Intent intent = new Intent(HomeActivity.this,NewsActivity.class);
            startActivity(intent);
        }else if (id == R.id.tourist){
            Intent intent = new Intent(HomeActivity.this,TouristActivity.class);
            startActivity(intent);
        }else if (id == R.id.aboutsandwip){
            Intent intent = new Intent(HomeActivity.this,AboutSandwipActivity.class);
            startActivity(intent);
        }
    }
}