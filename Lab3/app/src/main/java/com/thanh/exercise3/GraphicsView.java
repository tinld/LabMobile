package com.thanh.exercise3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;


public class GraphicsView extends View {

    int x=0;
    int y=0;
    int d=100;
    int r=50;

    Bitmap[] frames = new Bitmap[36];
    int i = 0;
    long last_tick=0;
    long period=200;
    Context ctext;
    MediaPlayer mPlayer;
    public GraphicsView(Context context) {
        super(context);

        ctext = context;
        frames[0]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy0);
        frames[1]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy1);
        frames[2]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy2);
        frames[3]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy3);
        frames[4]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy4);
        frames[5]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy5);
        frames[6]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy6);
        frames[7]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy7);
        frames[8]= BitmapFactory.decodeResource(getResources (), R.drawable.giphy8);

        mPlayer = MediaPlayer.create(ctext, R.raw.music);
        mPlayer.start();
    }

    //Bài 1
//    @Override
//    protected void onDraw(Canvas canvas){
//
//        Rect r=new Rect(40, 40, 400, 200);
//        Paint paint = new Paint();
//        paint.setStyle (Paint.Style. FILL);
//        paint.setColor(Color.RED);
//        canvas.drawRect (r, paint);
//
//        invalidate();
//
//    }

    //Bài 2
//    @Override
//    protected void onDraw(Canvas canvas){
//
//        if (x!=0&&y!=0) {
//            int right=x+d;
//            int bottom=y+r;
//            Rect r=new Rect(x, y, right, bottom);
//            Paint paint = new Paint();
//            paint.setStyle (Paint.Style. FILL);
//            paint.setColor(Color.RED);
//            canvas.drawRect (r, paint);
//        }
//        invalidate();
//    }
//
//    @Override
//    public boolean onTouchEvent (MotionEvent event) {
//        x= (int) event.getX();
//        y= (int) event.getY();
//        return super.onTouchEvent (event);
//    }

    //Bài 3
//    @Override
//    protected void onDraw(Canvas canvas){
//
//        if (i<9) {
//            canvas.drawBitmap (frames [i], 40, 40,  new Paint());
//        }
//        else{
//            i=0;
//        }
//        invalidate();
//    }
//
//
//    @Override
//    public boolean onTouchEvent (MotionEvent event) {
//        i++;
//        return true;
//    }

    //Bài 4
    @Override
    protected void onDraw(Canvas canvas){

        if (i<9) {
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period) //the delay time has passed. set next frame
            {
                last_tick = System.currentTimeMillis();
                canvas.drawBitmap (frames[i], 40, 40, new Paint());
                i++;
                // Again call onDraw method
                postInvalidate();
            }
            else //still within delay. redraw current frame
            {
                canvas.drawBitmap (frames [i], 40, 40, new Paint()); // Again call onDraw method
                postInvalidate();
            }
        }
            else{
                i=0;
                postInvalidate();
            }
    }

}
