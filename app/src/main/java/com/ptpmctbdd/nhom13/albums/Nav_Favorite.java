package com.ptpmctbdd.nhom13.albums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Nav_Favorite extends AppCompatActivity {

    GridView favoriteGv;
    PicturesAdapter picturesAdapter;
    public static ArrayList<PicturesList> favoritePicturesList = new ArrayList<>();
    int IdAlbum, IdImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__favorite);

        favoriteGv = (GridView) findViewById(R.id.favorite_grid_view);

        for(int i = 0 ;i< Albums.albumsList.size(); i++)
        {
            for (int j = 0; j < Albums.albumsList.get(i).getPicturesList().size(); j++)
            {
                if(Albums.albumsList.get(i).getPicturesList().get(j).isFavorite())
                {
                    favoritePicturesList.add(new PicturesList(IdImage, 0,
                            Albums.albumsList.get(i).getPicturesList().get(j).getName(),
                            Albums.albumsList.get(i).getPicturesList().get(j).getImage()));
                }
            }
        }

        picturesAdapter = new PicturesAdapter(Nav_Favorite.this,
                R.layout.image_view, favoritePicturesList);
        favoriteGv.setAdapter(picturesAdapter);


        favoriteGv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent chosenImage = new Intent(Nav_Favorite.this, FavoritePicture.class);
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
