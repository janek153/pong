package com.example.Pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

public class Ball {
    float x = 0;  // Ball's center (x,y)
    float y = 0;
    float speedX = 7;       // Ball's speed (x,y)
    float speedY = 7;
    private BitmapDrawable ball;


    private GameBackgroundView mgameBackgroundView;

    // Constructor
    public Ball(Context context, GameBackgroundView gameBackgroundView) {

        ball = (BitmapDrawable) context.getResources().getDrawable(R.drawable.ball);
        mgameBackgroundView = gameBackgroundView;
    }

    public void moveWithCollisionDetection() {
        // Get new (x,y) position
        x += speedX;
        y += speedY;

        // Detect collision and react
        if (x + ball.getBitmap().getWidth()> mgameBackgroundView.xMax || x<0) {
            speedX = -speedX;
        }

        if (y + ball.getBitmap().getHeight() > mgameBackgroundView.yMax || y<0) {
            speedY = -speedY;
        }
    }

    public void onDraw(Canvas c) {
        c.drawBitmap(ball.getBitmap(), x, y, null);
    }
}