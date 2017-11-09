package com.example.adnan.materialdesign11imageslideshow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by Adnan on 27/09/2017.
 */

public class SlideShowAdapter extends PagerAdapter {
    private Context context;
    LayoutInflater inflater;

    public int[] images = {
            R.drawable.angrybirds,
            R.drawable.asphalt8,
            R.drawable.clashofclans,
            R.drawable.cuttherope,
            R.drawable.fruitninja,
            R.drawable.pou,
            R.drawable.talkingtom,
            R.drawable.wheresmywhater,
            R.drawable.worms3
    };


    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideshow_layout, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.image_view_id);
       // img.setImageResource(images[position]);

        //To use glide, you have to add reposaitory and dependencies in grudle file
        Glide.with(context).load(images[position]).into(img);

        //You can add ON-click event here.......
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
