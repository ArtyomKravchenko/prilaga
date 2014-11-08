package com.example.untitled1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by artem on 04.11.14.
 */
public class Animal extends AShakeActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal);

        final ImageButton burnButton = (ImageButton) findViewById(R.id.animalburp);
        burnButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                try {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.burp);
                    mediaPlayer.start();
                } catch (Throwable t) {
                    System.out.print(t);
                }
            }
        });

        final ImageButton bunchButton = (ImageButton) findViewById(R.id.animalbunch);
        bunchButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                try {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bunch);
                    mediaPlayer.start();
                } catch (Throwable t) {
                    System.out.print(t);
                }
            }
        });
    }
}
