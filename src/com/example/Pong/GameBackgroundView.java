package com.example.Pong;

/**
 * Created by Janek on 2014-05-14.
 */
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameBackgroundView {
    int xMin, xMax, yMin, yMax;
    private Paint paint;  // paint style and color
    private Rect bounds;

    public GameBackgroundView(int color) {
        paint = new Paint();
        paint.setColor(color);
        bounds = new Rect();
    }

    public void set(int x, int y, int width, int height) {
        xMin = x;
        xMax = x + width - 1;
        yMin = y;
        yMax = y + height - 1;
        // The box's bounds do not change unless the view's size changes
        bounds.set(xMin, yMin, xMax, yMax);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(bounds, paint);
    }
}