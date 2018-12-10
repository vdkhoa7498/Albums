package com.ptpmctbdd.nhom13.albums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;

public class RotateImage extends AppCompatActivity {

    ImageView imageRotate;
    ImageButton rotateButtonRight;
    ImageButton rotateButtonLeft;
    ImageButton flipButtonHorizontal;
    ImageButton flipButtonVertical;
    GestureDetector gestureDetector;
    int IdAlbum, IdImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_image);

        imageRotate = (ImageView)findViewById(R.id.imageRotateView);
        rotateButtonRight = (ImageButton)findViewById(R.id.buttonRotateRight);
        rotateButtonLeft = (ImageButton) findViewById(R.id.buttonRotateLeft);
        flipButtonHorizontal = (ImageButton) findViewById(R.id.buttonFlipHorizontal);
        flipButtonVertical = (ImageButton) findViewById(R.id.buttonFlipVertical);

        Intent chosenImage = getIntent();
        IdAlbum = chosenImage.getIntExtra("IdAlbum", 0);
        IdImage = chosenImage.getIntExtra("IdImage", 0);
        imageRotate.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());

        rotateButtonRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageRotate.setRotation(imageRotate.getRotation() + 90);
            }
        });

        rotateButtonLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageRotate.setRotation(imageRotate.getRotation() - 90);
            }
        });

        flipButtonHorizontal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageRotate.setRotationY(imageRotate.getRotationY()-180);
            }
        });

        flipButtonVertical.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageRotate.setRotationX(imageRotate.getRotationX() + 180);
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
