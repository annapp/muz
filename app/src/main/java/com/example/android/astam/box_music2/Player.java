package com.example.android.astam.box_music2;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;


public class Player extends ActionBarActivity implements OnPreparedListener, OnCompletionListener {

    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mediaPlayer = new MediaPlayer();


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        //if(pref.getBoolean("key_name", null)){
        editor.putString("key_name", "string value");
        editor.commit();
        Log.d("777", pref.getString("key_name", null)+"");
        //}



        /**
         * play media
         */
        findViewById(R.id.BtnPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
//end mp
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    /**
     *
     * @param view
     * method start play
     */
    private void Play (View view) {

        Log.d("5555", mediaPlayer.isPlaying()+"");
        if (!mediaPlayer.isPlaying()){
            try {
                mediaPlayer.setDataSource("http://www.virginmegastore.me/Library/Music/CD_001214/Tracks/Track1.mp3");
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("Exception_printStackTrace", e.toString());
            }
        }
    }


}
