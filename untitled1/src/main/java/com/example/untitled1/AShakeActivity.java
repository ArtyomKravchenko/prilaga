package com.example.untitled1;

import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by artem on 08.11.14.
 */
public abstract class AShakeActivity extends AbstractActivity {

    protected MediaPlayer mediaPlayer;

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            BackgroundTask.mediaPlayer = mediaPlayer;
            startService(new Intent(this, BackgroundTask.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        stopService(new Intent(this, BackgroundTask.class));
    }
}
