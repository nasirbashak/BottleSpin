package com.nasirbashak007gmail.bottlefilp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Nasir Basha K on 04-01-2018.
 */

public class Welcome extends AppCompatActivity {

    Button start;
    ImageView imageView,imageView2;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        imageView=(ImageView)findViewById(R.id.imageView2) ;
        imageView2=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.welcomeimage);
        imageView2.setImageResource(R.drawable.image2);
        start=(Button)findViewById(R.id.button);

        rotateTheBottle(imageView,3,3000);
        rotateTheBottle(imageView2,-3,2000);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheBottleActivity();
            }
        });
    }


    public void startTheBottleActivity(){
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

    public void rotateTheBottle(ImageView image,int n,int time){
        RotateAnimation rotate = new RotateAnimation(0,360*n,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        rotate.setFillAfter(true);
        rotate.setDuration(time);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());


        image.startAnimation(rotate);

    }


}
