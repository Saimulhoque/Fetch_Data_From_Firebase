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

    private MaterialCardView card7,card10;
    private ViewPager viewPager;
    int images[] = {R.drawable.ggg,R.drawable.one,R.drawable.three,R.drawable.two,R.drawable.four};
    int currentPageCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card7 = findViewById(R.id.police);
        card10 = findViewById(R.id.news);
        card7.setOnClickListener(this);
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
        }
    }
}