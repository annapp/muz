package com.example.android.astam.box_music2;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Box_music2 extends ActionBarActivity {

    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_music2);

        findViewById(R.id.PlayRand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Player.class));
            }
        });

        ImageButton rr = (ImageButton) findViewById(R.id.imageButton);
        LinearLayout qq = (LinearLayout) findViewById(R.id.category);

        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(180,  180);
        /*for (int i=0; i<10; i++){

            ImageButton ww = new ImageButton(this);
            ww.setMaxHeight(500);
            ww.setMaxHeight(500);
            ww.setMaxWidth(500);
            ww.setMaxWidth(500);

            qq.addView(ww);

        }*/
//-----------------------------------------
        /*ImageButton[] btnGreen = new ImageButton[3];

        for (int i = 0; i < 3; i++) {
            btnGreen[i] = new ImageButton(this);


            Log.d(""+i,""+Color.BLUE);
            btnGreen[i].setBackgroundColor(-1677696+i);
            btnGreen[i].setId(i);
            btnGreen[i].setMinimumWidth(50);
            btnGreen[i].setMinimumHeight(50);


            ImageButton ww = new ImageButton(this);


            qq.addView(ww);
            qq.addView(btnGreen[i]);
        }*/

        //-------------------------------------------



        /*MediaPlayer player = MediaPlayer.create(this, R.raw.qq);////!!!!!!!!!!!!!!!!!!музыка локально
        player.start();*/
        //player.setLooping(true); // зацикливаем

        for (int i = 0; i < 5; i++) {
            ImageButton btnGreen = new ImageButton(this);


            Log.d(""+i,""+Color.BLUE);
            btnGreen.setBackgroundColor(-1677696 * i);
            btnGreen.setId(i);
            btnGreen.setMinimumWidth(50);
            btnGreen.setMinimumHeight(50);
            btnGreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(Box_music2.this, ress.class));
                }
            });

            qq.addView(btnGreen);
        }
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_box_music2, menu);
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
}
