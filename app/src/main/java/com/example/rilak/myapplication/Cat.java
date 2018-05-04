package com.example.rilak.myapplication;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by rilak on 2018/05/04.
 */

public class Cat {

    int state;
    ImageView catImage;

    android.os.Handler h;

    Runnable hide;

    public Cat(ImageView imageView) {
        state = 0;
        catImage = imageView;
        catImage.setImageResource(R.drawable.cat3_smile);

        h = new android.os.Handler();
        hide = new Runnable() {
            @Override
            public void run() {
                state = 0;

                catImage.setImageResource(R.drawable.cat3_smile);
            }
        };
    }

    public void start(){
        if(state==0){
            state = 1;
            catImage.setImageResource(R.drawable.cat1_smile);

            h.postDelayed(hide,1000);
        }
    }

    public int tapCat(){
        if(state==1){
            state=2;
            catImage.setImageResource(R.drawable.cat2_angry);

            h.removeCallbacks(hide);
            h.postDelayed(hide,1000);
            return 1;
        }
        return  0;
    }
}


