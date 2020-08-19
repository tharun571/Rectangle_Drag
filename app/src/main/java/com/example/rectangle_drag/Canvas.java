package com.example.rectangle_drag;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Canvas extends View {

    private static final String TAG = "QWERTYUI";
    float left=100, right=600, top=100, bottom=500;
    float b,h;
    public Canvas(Context context) {
        super(context);
        init(null);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    private void init(@Nullable AttributeSet set){

        postInvalidate();
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#000000"));
        paint1.setColor(Color.parseColor("#DCDCDC"));

        canvas.drawRect(left,top,right,bottom,paint);
        canvas.drawCircle(left,top,30,paint1);
        canvas.drawCircle(left,bottom,30,paint1);
        canvas.drawCircle(left,top+(bottom-top)/2,30,paint1);
        canvas.drawCircle(right,top,30,paint1);
        canvas.drawCircle(right,bottom,30,paint1);
        canvas.drawCircle(right,top+(bottom-top)/2,30,paint1);
        canvas.drawCircle(left+(right-left)/2,top,30,paint1);
        canvas.drawCircle(left+(right-left)/2,bottom,30,paint1);


    }
    double dx, dy;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        Log.w(TAG,"QWE");

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:{
                return true;
            }

            case MotionEvent.ACTION_MOVE:{
                float x=event.getX();
                float y=event.getY();
                Log.w(TAG,"QWE 1 "+x+" "+y);



                if(x>left+30&&x<right-30&&y>top+30&&y<bottom-30){
                    b=(right-left)/2;
                    h=(bottom-top)/2;


                    left=x-b;
                    right=x+b;
                    top=y-h;
                    bottom=y+h;

                    postInvalidate();


                    return true;
                }
                else if(x>left-30&&x<left+30&&y<top+(bottom-top)/2+30&&y>top+(bottom-top)/2-30){
                    left=x;
                    postInvalidate();
                    return true;


                }
                else if(x>right-30&&x<right+30&&y<top+(bottom-top)/2+30&&y>top+(bottom-top)/2-30){
                    right=x;
                    postInvalidate();
                    return true;


                }
                else if(x>left+(right-left)/2-30&&x<left+(right-left)/2+30&&y<bottom+30&&y>bottom-30){
                    bottom=y;
                    postInvalidate();
                    return true;


                }
                else if(x>left+(right-left)/2-30&&x<left+(right-left)/2+30&&y<top+30&&y>top-30){
                    top=y;
                    postInvalidate();
                    return true;


                }
                else if(x>left-30&&x<left+30&&y<top+30&&y>top-30){
                    left=x;
                    top=y;
                    postInvalidate();
                    return true;
                }
                else if(x>left-30&&x<left+30&&y<bottom+30&&y>bottom-30){
                    left=x;
                    bottom=y;
                    postInvalidate();
                    return true;
                }
                else if(x>right-30&&x<right+30&&y<bottom+30&&y>bottom-30){
                    right=x;
                    bottom=y;
                    postInvalidate();
                    return true;
                }
                else if(y<top+30&&y>top-30&&x>right-30&&x<right+30){
                    right=x;
                    top=y;
                    postInvalidate();
                    return true;
                }



                return value;
        }
        }


        return value;


    }
}
