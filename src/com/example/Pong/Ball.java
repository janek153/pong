package com.example.Pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball {
    float radius = 5;      // Ball's radius
    float x = radius + 20;  // Ball's center (x,y)
    float y = radius + 40;
    float speedX = 5;       // Ball's speed (x,y)
    float speedY = 5;
    private RectF bounds;   // Needed for Canvas.drawOval
    private Paint paint;    // The paint style, color used for drawing

    // Constructor
    public Ball(int color) {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
    }

    public void moveWithCollisionDetection(GameBackgroundView gameBackgroundView) {
        // Get new (x,y) position
        x += speedX;
        y += speedY;
        // Detect collision and react
        if (x + radius > gameBackgroundView.xMax) {
            speedX = -speedX;
            x = gameBackgroundView.xMax-radius;
        } else if (x - radius < gameBackgroundView.xMin) {
            speedX = -speedX;
            x = gameBackgroundView.xMin+radius;
        }
        if (y + radius > gameBackgroundView.yMax) {
            speedY = -speedY;
            y = gameBackgroundView.yMax - radius;
        } else if (y - radius < gameBackgroundView.yMin) {
            speedY = -speedY;
            y = gameBackgroundView.yMin + radius;
        }
    }

    public void draw(Canvas canvas) {
        bounds.set(x-radius, y-radius, x+radius, y+radius);
        canvas.drawOval(bounds, paint);
    }
}