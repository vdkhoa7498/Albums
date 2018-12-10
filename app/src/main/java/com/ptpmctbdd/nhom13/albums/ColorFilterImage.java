package com.ptpmctbdd.nhom13.albums;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;

public class ColorFilterImage extends AppCompatActivity {

    TableLayout colorFilterImageTool;
    GestureDetector gestureDetector;
    ImageView imageColorView;
    ImageButton darkenButton;
    ImageButton lightenButton;
    ImageButton overlayButton;
    ImageButton screenButton;
    ImageButton multiplyButton;
    int IdAlbum, IdImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_filter_image);

        imageColorView = (ImageView)findViewById(R.id.imageColorView);
        darkenButton = (ImageButton)findViewById(R.id.colorDarkenButton);
        lightenButton = (ImageButton) findViewById(R.id.colorLightenButton);
        overlayButton = (ImageButton) findViewById(R.id.colorOverlayButton);
        screenButton = (ImageButton) findViewById(R.id.colorScreenButton);
        multiplyButton = (ImageButton) findViewById(R.id.colorMultiplyButton);

//        gestureDetector = new GestureDetector(this, new ColorFilterImage.MyGesture());
//        imageColorView.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                gestureDetector.onTouchEvent(event);
//                return true;
//            }
//        });


        Intent chosenImage = getIntent();
        IdAlbum = chosenImage.getIntExtra("IdAlbum", 0);
        IdImage = chosenImage.getIntExtra("IdImage", 0);

        imageColorView.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        darkenButton.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        darkenButton.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);
        darkenButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        lightenButton.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        lightenButton.setColorFilter(Color.GRAY, PorterDuff.Mode.LIGHTEN);
        lightenButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        overlayButton.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        overlayButton.setColorFilter(Color.GRAY, PorterDuff.Mode.OVERLAY);
        overlayButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        screenButton.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        screenButton.setColorFilter(Color.GRAY, PorterDuff.Mode.SCREEN);
        screenButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        multiplyButton.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());
        multiplyButton.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        multiplyButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        darkenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageColorView.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);
            }
        });

        lightenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageColorView.setColorFilter(Color.GRAY, PorterDuff.Mode.LIGHTEN);
            }
        });

        overlayButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageColorView.setColorFilter(Color.GRAY, PorterDuff.Mode.OVERLAY);
            }
        });

        screenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageColorView.setColorFilter(Color.GRAY, PorterDuff.Mode.SCREEN);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageColorView.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu_back:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
