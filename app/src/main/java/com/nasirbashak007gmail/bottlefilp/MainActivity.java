package com.nasirbashak007gmail.bottlefilp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button flip1,flip2;
    ImageView imageView;
    TextView degView;
    Random rand = new Random();
    int angle;
    boolean restart=true;
    int degree,rounds;

    Animation leftToRight,RightToLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flip1=(Button)findViewById(R.id.button3);
        flip2=(Button)findViewById(R.id.button2);
        imageView=(ImageView)findViewById(R.id.imageButton);
        degView=(TextView)findViewById(R.id.viewText);

        flip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(restart){

                    angle = Math.abs(rand.nextInt()) %3600;
                    if(angle<360){
                        angle=angle+360;
                    }

                    RotateAnimation rotate = new RotateAnimation(0,angle,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3000);
                    rotate.setInterpolator( new AccelerateDecelerateInterpolator());

                    imageView.startAnimation(rotate);

                    rounds=angle/360;
                    degree=angle%360;
                    degView.setText(degree+" deg"+"");

                    LeftToRight();
                    RightToLeft();

                    if(rounds>=0 && rounds<=3){
                        Toast toast =Toast.makeText(MainActivity.this,"only "+rounds+" rounds, poor performance....",Toast.LENGTH_SHORT);
                              // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,1000);
                                toast.show();
                    }else if(rounds>=4 && rounds<=6){
                        Toast toast =Toast.makeText(MainActivity.this,"hooo "+rounds+" rounds, goood performance....",Toast.LENGTH_SHORT);
                       // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,500);
                        toast.show();

                    }else{
                        Toast toast =Toast.makeText(MainActivity.this,"wow "+rounds+" rounds, better performance....",Toast.LENGTH_SHORT);
                       // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,75);
                        toast.show();

                    }



                    restart=false;

                    flip1.setBackgroundColor(Color.parseColor("#dea939"));
                    flip1.setText("RE");
                    flip2.setBackgroundColor(Color.parseColor("#dea939"));
                    flip2.setText("SET");

                }else{
                    degView.setText("");
                    int temp= angle%360;
                    RotateAnimation rotate = new RotateAnimation(temp,0,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator( new AccelerateDecelerateInterpolator());

                    imageView.startAnimation(rotate);

                    LeftToRight();
                    RightToLeft();

                    restart=true;
                    flip1.setBackgroundColor(Color.parseColor("#fddf52"));
                    flip1.setText("FL");
                    flip2.setBackgroundColor(Color.parseColor("#fddf52"));
                    flip2.setText("IP");
                }



            }
        });



        flip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(restart){

                    angle = Math.abs(rand.nextInt()) %3600;
                    if(angle<360){
                        angle=angle+360;
                    }

                    RotateAnimation rotate = new RotateAnimation(0,angle,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3000);
                    rotate.setInterpolator( new AccelerateDecelerateInterpolator());

                    imageView.startAnimation(rotate);

                    rounds=angle/360;
                    degree=angle%360;
                    degView.setText(degree+" deg"+"");

                    LeftToRight();
                    RightToLeft();

                    if(rounds>=0 && rounds<=3){
                        Toast toast =Toast.makeText(MainActivity.this,"only "+rounds+" rounds, poor performance....",Toast.LENGTH_SHORT);
                        // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,1000);
                        toast.show();
                    }else if(rounds>=4 && rounds<=6){
                        Toast toast =Toast.makeText(MainActivity.this,"hooo "+rounds+" rounds, goood performance....",Toast.LENGTH_SHORT);
                        // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,500);
                        toast.show();

                    }else{
                        Toast toast =Toast.makeText(MainActivity.this,"wow "+rounds+" rounds, better performance....",Toast.LENGTH_SHORT);
                        // toast.setMargin(50,50);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,140,75);
                        toast.show();

                    }



                    restart=false;

                    flip2.setBackgroundColor(Color.parseColor("#dea939"));
                    flip2.setText("SET");
                    flip1.setBackgroundColor(Color.parseColor("#dea939"));
                    flip1.setText("RE");

                }else{
                    degView.setText("");
                    int temp= angle%360;
                    RotateAnimation rotate = new RotateAnimation(temp,0,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator( new AccelerateDecelerateInterpolator());

                    imageView.startAnimation(rotate);

                    LeftToRight();
                    RightToLeft();

                    restart=true;
                    flip2.setBackgroundColor(Color.parseColor("#fddf52"));
                    flip2.setText("IP");
                    flip1.setBackgroundColor(Color.parseColor("#fddf52"));
                    flip1.setText("FL");
                }



            }
        });


    }

    public void LeftToRight(){

        leftToRight= AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        flip1.setAnimation(leftToRight);

    }

    public void RightToLeft(){

        leftToRight=AnimationUtils.loadAnimation(this,R.anim.right_to_left);
        flip2.setAnimation(leftToRight);
    }
}
