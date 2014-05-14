package com.example.Pong;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MENU extends Activity {
    /**
     * Called when the activity is first created.
     */
    Button przycisk;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        context = getApplicationContext();

        przycisk = (Button) findViewById(R.id.button);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Game.class);
                startActivity((intent));
            }
        });

    }

}
