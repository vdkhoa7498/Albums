package com.ptpmctbdd.nhom13.albums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class FavoritePicture extends AppCompatActivity {

    GestureDetector gestureDetector;
    ImageView favoriteImage;
    int IdImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_picture);

        favoriteImage = (ImageView) findViewById(R.id.favoriteImage);
        Intent chosenImage = getIntent();
        IdImage = chosenImage.getIntExtra("IdImage", 0);
        favoriteImage.setImageResource(Nav_Favorite.favoritePicturesList.get(IdImage).getImage());

        gestureDetector = new GestureDetector(this, new FavoritePicture.MyGesture());
        favoriteImage.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //Keo sang phai
            if((e2.getX() - e1.getX() > 100 && Math.abs(velocityX)>100)){
                IdImage--;
                if (IdImage < 0){
                    IdImage = Nav_Favorite.favoritePicturesList.size();
                }
                favoriteImage.setImageResource(Nav_Favorite.favoritePicturesList.get(IdImage).getImage());
            }
            //Keo sang trai
            if((e1.getX() - e2.getX() > 100 && Math.abs(velocityX)>100)){
                IdImage++;
                if (IdImage == Nav_Favorite.favoritePicturesList.size()){
                    IdImage = 0;
                }
                favoriteImage.setImageResource(Nav_Favorite.favoritePicturesList.get(IdImage).getImage());

            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
