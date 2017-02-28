package com.apps.ga.moderartui;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    public SeekBar progress = null;
    public ImageView imgL1 = null;
    public ImageView imgL2 = null;
    public ImageView imgR1 = null;
    public ImageView imgR2 = null;
    public ImageView imgR3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgL1 = (ImageView) findViewById(R.id.imageViewL1);
        imgL2 = (ImageView) findViewById(R.id.imageViewL2);
        imgR1 = (ImageView) findViewById(R.id.imageViewR1);
        imgR2 = (ImageView) findViewById(R.id.imageViewR2);
        imgR3 = (ImageView) findViewById(R.id.imageViewR3);

        //Setup seekBar
        progress = (SeekBar)findViewById(R.id.seekBar3);
        progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                Log.d("VAL", "value = " + progress);
                Log.d("VAL", "alpha = " + imgL1.getImageAlpha());
                imgL1.setImageAlpha(255 - progress);
                imgL2.setImageAlpha(255 - progress);
                imgR1.setImageAlpha(255 - progress);
                imgR2.setImageAlpha(255 - progress);
                imgR3.setImageAlpha(255 - progress);

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

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
        if (id == R.id.action_info) {
            // custom dialog
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog);
            //dialog.setTitle("Title...");

            // set the custom dialog components - text, image and button
            TextView text = (TextView) dialog.findViewById(R.id.text);
            text.setText(getResources().getString(R.string.inspiration));
            TextView text2 = (TextView) dialog.findViewById(R.id.text2);
            text2.setText(getResources().getString(R.string.authors));

            TextView text3 = (TextView) dialog.findViewById(R.id.text3);
            text3.setText(getResources().getString(R.string.clickbelow));

            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                    String url = "https://www.moma.org/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });

            Button dialogButtonCancel = (Button) dialog.findViewById(R.id.dialogButtonCancel);
            // if button is clicked, close the custom dialog
            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void changeColours(View v) {

    }
}
