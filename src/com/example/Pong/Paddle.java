package com.example.Pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Janek on 2014-05-14.
 */
public class Paddle {
    float width = 15;
    float height = 5;
    float x1 = 20;
    float y1 = 20;
    private RectF bounds;   // Needed for Canvas.drawOval
    private Paint paint;   // The paint style, color used for drawing




    /*float radius = 7;      // Ball's radius
    float x = radius + 20;  // Ball's center (x,y)
    float y = radius + 40;
    float speedX = 5;       // Ball's speed (x,y)
    float speedY = 5;
    private RectF bounds;   // Needed for Canvas.drawOval
    private Paint paint;*/    // The paint style, color used for drawing

    // Constructor
    public Paddle(int color) {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
    }

    /*public void moveWithCollisionDetection(GameBackgroundView gameBackgroundView) {
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
    }*/

    public void draw(Canvas canvas) {
        bounds.set(x1-width/2, y1+height/2, x1+width/2, y1-height/2);
        canvas.drawRect(bounds, paint);

    }
}
