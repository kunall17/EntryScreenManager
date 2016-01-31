package com.kunall17.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_CODE = 435;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {

        if (requestCode == REQUEST_CODE) {
            setContentView(R.layout.activity_main);

            if (resultCode == Activity.RESULT_OK) {
                //Write your code if result is OK
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, data.getStringExtra("SomeValues"), Snackbar.LENGTH_LONG)
                                .setAction("Done!", null).show();
                    }
                });
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(MainActivity.this, com.kunall17.entryscreenmanager.Activities.MainActivity.class);
        startActivityForResult(i, REQUEST_CODE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
