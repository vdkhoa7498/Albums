package com.ptpmctbdd.nhom13.albums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PicturesView extends AppCompatActivity {

    GridView Pictures;
    public static PicturesAdapter picturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures_view);
        Pictures = (GridView) findViewById(R.id.PicturesView);

        Intent chosenAlbum = getIntent();
        final int IdAlbum = chosenAlbum.getIntExtra("IdAlbum", 0);

        picturesAdapter = new PicturesAdapter(PicturesView.this,
                R.layout.image_view, Albums.albumsList.get(IdAlbum).getPicturesList());
        Pictures.setAdapter(picturesAdapter);

        Pictures.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent chosenImage = new Intent(PicturesView.this, Picture.class);
                chosenImage.putExtra("IdAlbum", IdAlbum);
                chosenImage.putExtra("IdImage", position);
                startActivity(chosenImage);
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
