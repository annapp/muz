package com.example.android.astam.box_music2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import libraryjava.parseJSON;


public class Genre extends ActionBarActivity {
    parseJSON jasonParser;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        jasonParser = new parseJSON("http://muz.returnt.ru/main/getcategories","category");
        for (int i =0; i<jasonParser.getJsonArray().length(); i++)
        {
            try {
              a = jasonParser.getJsonArray().getJSONObject(i).getString("muz_category_name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        LinearLayout vertical = (LinearLayout) findViewById(R.id.vertq);
        //LinearLayout.LayoutParams tad = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        // News = (RelativeLayout) findViewById(R.id.news);
        //LinearLayout linearLayout = new LinearLayout(this);
        //LinearLayout.LayoutParams tad = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //LinearLayout catIco = (LinearLayout) findViewById(R.id.news);
        //LinearLayout.LayoutParams tad = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //LinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams bag = new LinearLayout.LayoutParams(100,  100);
        LinearLayout.LayoutParams dog = new LinearLayout.LayoutParams(100, 100);
        bag.setMargins(30, 10, 10, 10);
        dog.setMargins(30, -10, 10, 0);
        //setContentView(linearLayout, tad);

        for(int i = 0; i < 50; i++) {
            ImageView btn = new ImageView(this);
            TextView tex = new TextView(this);
            btn.setId(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ress.class));
                }
            });
            btn.setImageResource(R.drawable.wewew);
            btn.setMinimumWidth(100);
            btn.setMinimumHeight(100);
            vertical.addView(btn, bag);

            tex.setText(i + a);
            tex.setRotationY(-20);
            tex.setRotationX(30);
            tex.setTextColor(Color.BLACK);
            tex.setTextSize(16);
            vertical.addView(tex, dog);
            //linearLayout.addView(linearLayout);
            tex.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ress.class));
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_genre, menu);
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
