package com.example.Pong;

/**
 * Created by Janek on 2014-05-14.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {
    private Ball ball;
    private Context mcontext;
    private Paddle paddle;
    private GameBackgroundView gameBackgroundView;
    private Handler h;
    private final int FRAME_RATE = 10;

    // For touch inputs - previous touch (x, y)
    private float previousX;
    private float previousY;

    // Constructor
    public GameView(Context context) {
        super(context);
        gameBackgroundView = new GameBackgroundView(0xff5A180F);  // ARGB
        ball = new Ball(context, gameBackgroundView);
        paddle = new Paddle(Color.RED);
        mcontext = context;
        h = new Handler();

        // To enable keypad
        this.setFocusable(true);
        this.requestFocus();
        // To enable touch mode
        this.setFocusableInTouchMode(true);
    }

    // Called back to draw the view. Also called after invalidate().
    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the components
        gameBackgroundView.draw(canvas);
        ball.onDraw(canvas);
        ball.moveWithCollisionDetection();
        //ball.draw(canvas);
        paddle.draw(canvas);
        h.postDelayed(r, FRAME_RATE);


        // Update the position of the ball, including collision detection and reaction.



        // Delay

         // Force a re-draw
    }

    // Called back when the view is first created or its size changes.
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        gameBackgroundView.set(0, 0, w, h);
    }
    private Runnable r = new Runnable() {

        @Override

        public void run() {

            invalidate();

        }

    };

    // Key-up event handler
    /*@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT: // Increase rightward speed
                ball.speedX++;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:  // Increase leftward speed
                ball.speedX--;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:    // Increase upward speed
                ball.speedY--;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:  // Increase downward speed
                ball.speedY++;
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER: // Stop
                ball.speedX = 0;
                ball.speedY = 0;
                break;
            case KeyEvent.KEYCODE_A:    // Zoom in
                // Max radius is about 90% of half of the smaller dimension
                float maxRadius = (gameBackgroundView.xMax > gameBackgroundView.yMax) ? gameBackgroundView.yMax / 2 * 0.9f  : gameBackgroundView.xMax / 2 * 0.9f;
                if (ball.radius < maxRadius) {
                    ball.radius *= 1.05;   // Increase radius by 5%
                }
                break;
            case KeyEvent.KEYCODE_Z:    // Zoom out
                if (ball.radius > 20) {  // Minimum radius
                    ball.radius *= 0.95;  // Decrease radius by 5%
                }
                break;
        }
        return true;  // Event handled
    }

    // Touch-input handler
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        float deltaX, deltaY;
        float scalingFactor = 5.0f / ((gameBackgroundView.xMax > gameBackgroundView.yMax) ? gameBackgroundView.yMax : gameBackgroundView.xMax);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // Modify rotational angles according to movement
                deltaX = currentX - previousX;
                deltaY = currentY - previousY;
                ball.speedX += deltaX * scalingFactor;
                ball.speedY += deltaY * scalingFactor;
        }
        // Save current x, y
        previousX = currentX;
        previousY = currentY;
        return true;  // Event handled
    }
    */
}
