package com.cloud.jem.counter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Jem on 13-07-2015.
 */
public class FirstActivity extends Activity {

    MediaPlayer backSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        backSound = MediaPlayer.create(FirstActivity.this,R.raw.river);
        backSound.start();

        Thread timer = new Thread(){
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent openStartingPoint = new Intent(FirstActivity.this, Menu.class);
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        backSound.release();
        finish();
    }
}
