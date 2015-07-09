package com.example.android.astam.box_music2;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class Player extends ActionBarActivity implements OnPreparedListener, OnCompletionListener {

    private MediaPlayer mediaPlayer;
    private Boolean play = true;
    private Button btnPlay;
   /* private Button btnStop;
    private Button btnRestart;*/
    private Button btnLike;
    private Button btnUnlike;
    boolean like = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mediaPlayer = new MediaPlayer();
        btnPlay = (Button) findViewById(R.id.BtnPlay);
        btnLike = (Button) findViewById (R.id.btnLike);
        btnUnlike = (Button) findViewById(R.id.btnUnlike);

        Play();

        /**
         * play media
         */
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play();
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like) {
                    like = false;
                    btnLike.setText("Back");
                    btnUnlike.setText("Next"); // Произошел лайк, обращаемся к серверу.
                } else {
                    //Next track.
                }
            }
        });
        btnUnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like) {
                    like = false;
                    btnLike.setText("Back");
                    btnUnlike.setText("Next"); // Произошел лайк, обращаемся к серверу.
                } else {
                    //Next track.
                }
            }
        });
/*
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickk(v);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickk(v);
            }
        });
*/
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                mediaPlayer.stop();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
    @Override
    public void onCompletion(MediaPlayer mp) {
        //end mp
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void onResume(){
        super.onResume();

        mediaPlayer.start();

    }

    @Override
    public void onPause() {
        super.onPause();

        mediaPlayer.pause();
    }

    /**
     * method start play
     */
    private void Play() {

        if (!mediaPlayer.isPlaying()) {
            btnPlay.setText("Pause");
            if (play) {
                try {
                    mediaPlayer.setDataSource("http://www.virginmegastore.me/Library/Music/CD_001214/Tracks/Track2.mp3");
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.prepareAsync();
                    play = false;

                    Log.d("11", "11");

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("Exception_printStackTrace", e.toString());
                }
            } else {
                mediaPlayer.start();
                Log.d("33", "33");
            }
        } else if (!play) {
            mediaPlayer.pause();
            btnPlay.setText("Play");
            Log.d("22", "22");
        }
    }
/*
    private void onClickk(View view) {

        switch (view.getId()) {
            case R.id.BtnStop:
                mediaPlayer.stop();
                play = true;
                btnPlay.setText("Play");
                mediaPlayer = new MediaPlayer();
                Log.d("44", "44");
                break;
            case R.id.BtnRestart:
                mediaPlayer.reset();
                mediaPlayer = new MediaPlayer();
                play = true;
                Play();
                break;
        }
    }
*/
}
