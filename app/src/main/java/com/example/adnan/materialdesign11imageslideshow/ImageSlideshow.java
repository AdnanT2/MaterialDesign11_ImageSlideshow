package com.example.adnan.materialdesign11imageslideshow;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ImageSlideshow extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdapter slideShowAdapter;
    CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slideshow);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager)findViewById(R.id.view_pager_id);
        circleIndicator = (CircleIndicator)findViewById(R.id.circle_indicator_id);

       slideShowAdapter = new SlideShowAdapter(this);
        viewPager.setAdapter(slideShowAdapter);
        circleIndicator.setViewPager(viewPager);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 5000);
    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            ImageSlideshow.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem()==3){
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem()==4){
                        viewPager.setCurrentItem(5);
                    }
                    else if (viewPager.getCurrentItem()==5){
                        viewPager.setCurrentItem(6);
                    }
                    else if (viewPager.getCurrentItem()==6){
                        viewPager.setCurrentItem(7);
                    }
                    else if (viewPager.getCurrentItem()==7){
                        viewPager.setCurrentItem(8);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }


//                    SlideShowAdapter adapter = new SlideShowAdapter(getApplicationContext());
//                    int size = adapter.getCount();
//                    for (int i=0;i<size; i++){
//                      viewPager.setCurrentItem(i);
//                    }
                }
            });
        }
    }
}
