package com.ptpmctbdd.nhom13.albums;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Nav_Slideshow extends AppCompatActivity {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__slideshow);

        viewFlipper = (ViewFlipper) findViewById(R.id.slideshow_view_flipper);

        for(int i = 0 ;i< Albums.albumsList.size(); i++)
        {
            for (int j = 0; j < Albums.albumsList.get(i).getPicturesList().size(); j++)
            {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(Albums.albumsList.get(i).getPicturesList().get(j).getImage());
                viewFlipper.addView(imageView);
            }
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(Nav_Slideshow.this,R.anim.slide_in);
        viewFlipper.setOutAnimation(Nav_Slideshow.this,R.anim.slide_out);
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
