package com.dragonflythicket.modernartui;

import android.animation.ArgbEvaluator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView verticalRectangle;
    private ImageView horizontalRectangle1;
    private ImageView horizontalRectangle2;
    private ImageView horizontalRectangle3;
    private ImageView horizontalRectangle4;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verticalRectangle = (ImageView)findViewById(R.id.vertical);
        horizontalRectangle1  = (ImageView)findViewById(R.id.horizontal1);
        horizontalRectangle2 = (ImageView)findViewById(R.id.horizontal2);
        horizontalRectangle3 = (ImageView)findViewById(R.id.horizontal3);
        horizontalRectangle4 = (ImageView)findViewById(R.id.horizontal4);

        seekBar = (SeekBar)findViewById(R.id.seekbar);
        seekBar.setMax(255);
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        final int GREEN = ContextCompat.getColor(this, R.color.green);
        final int YELLOW = ContextCompat.getColor(this, R.color.yellow);
        final int BLUE = ContextCompat.getColor(this, R.color.blue);
        final int RED = ContextCompat.getColor(this, R.color.red);
        final int DEEP_SKY_BLUE = ContextCompat.getColor(this, R.color.deep_sky_blue);
        final int DEEP_PINK = ContextCompat.getColor(this, R.color.deep_pink);
        final int AQUAMARINE = ContextCompat.getColor(this, R.color.aquamarine);
        final int DARK_ORANGE = ContextCompat.getColor(this, R.color.dark_orange);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                horizontalRectangle1.setBackgroundColor((int)argbEvaluator.evaluate((float)progress/seekBar.getMax(), GREEN, DEEP_PINK));
                verticalRectangle.setBackgroundColor((int)argbEvaluator.evaluate((float)progress/seekBar.getMax(), YELLOW, DARK_ORANGE));
                horizontalRectangle2.setBackgroundColor((int)argbEvaluator.evaluate((float)progress/seekBar.getMax(), BLUE, AQUAMARINE));
                horizontalRectangle4.setBackgroundColor((int)argbEvaluator.evaluate((float)progress/seekBar.getMax(), RED, DEEP_SKY_BLUE));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        if (id == R.id.action_more_info) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle(getString(R.string.inspired_by));
            builder.setMessage(getString(R.string.inspired_by) + "\n\n" + getString(R.string.learn_more));
            builder.setCancelable(true);

            builder.setPositiveButton(
                    getString(R.string.visit_moma),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "visit Moma", Toast.LENGTH_LONG).show();
                        }
                    }
            );

            builder.setNegativeButton(
                    getString(R.string.not_now),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }
            );

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
