package com.ptpmctbdd.nhom13.albums;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

public class Picture extends AppCompatActivity {

    ImageButton DeleteImage;
    ImageButton RotateImage;
    ImageButton ColorImage;
    ImageButton FavoriteImage;
    ImageView ViewImage;
    TableLayout pictureTool;
    int IdImage, IdAlbum;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        RotateImage = (ImageButton) findViewById(R.id.rotateImageButton);
        ColorImage =(ImageButton) findViewById(R.id.colorImageButton);
        ViewImage = (ImageView) findViewById(R.id.imageView);
        FavoriteImage = (ImageButton) findViewById(R.id.favoriteImageButton);
        DeleteImage = (ImageButton) findViewById(R.id.deleteImageButton);
        pictureTool = (TableLayout) findViewById(R.id.pictureTool);

        Intent chosenImage = getIntent();
        IdAlbum = chosenImage.getIntExtra("IdAlbum", 0);
        IdImage = chosenImage.getIntExtra("IdImage", 0);
        ViewImage.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());

        gestureDetector = new GestureDetector(this, new MyGesture());
        ViewImage.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

        if(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).isFavorite())
        {
            FavoriteImage.setImageResource(R.drawable.icon_favorite);
        }
        else
        {
            FavoriteImage.setImageResource(R.drawable.icon_unfavorite);
        }

        RotateImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent rotateimage = new Intent(Picture.this, RotateImage.class);
                rotateimage.putExtra("IdAlbum", IdAlbum);
                rotateimage.putExtra("IdImage", IdImage);
                startActivity(rotateimage);
            }
        });

        FavoriteImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).isFavorite())
                {
                    FavoriteImage.setImageResource(R.drawable.icon_unfavorite);
                    Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).setFavorite(false);
                }
                else
                {
                    FavoriteImage.setImageResource(R.drawable.icon_favorite);
                    Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).setFavorite(true);
                }
            }
        });

        DeleteImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DeleteConfirmation();

            }
        });

        ColorImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent colorimage = new Intent(Picture.this, ColorFilterImage.class);
                colorimage.putExtra("IdAlbum", IdAlbum);
                colorimage.putExtra("IdImage", IdImage);
                startActivity(colorimage);
            }
        });

//        ColorImage.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent colorimage = new Intent(Picture.this, ColorFilterImage.class);
//                colorimage.putExtra("IdAlbum", IdAlbum);
//                colorimage.putExtra("IdImage", IdImage);
//                startActivity(colorimage);
//            }
//        });
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //Keo sang phai
            if((e2.getX() - e1.getX() > 100 && Math.abs(velocityX)>100)){
                IdImage--;
                if (IdImage < 0){
                    IdImage = Albums.albumsList.get(IdAlbum).getPicturesList().size();
                }
                ViewImage.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());

                if(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).isFavorite())
                {
                    FavoriteImage.setImageResource(R.drawable.icon_favorite);
                }
                else
                {
                    FavoriteImage.setImageResource(R.drawable.icon_unfavorite);
                }
            }
            //Keo sang trai
            if((e1.getX() - e2.getX() > 100 && Math.abs(velocityX)>100)){
                IdImage++;
                if (IdImage == Albums.albumsList.get(IdAlbum).getPicturesList().size()){
                    IdImage = 0;
                }
                ViewImage.setImageResource(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).getImage());

                if(Albums.albumsList.get(IdAlbum).getPicturesList().get(IdImage).isFavorite())
                {
                    FavoriteImage.setImageResource(R.drawable.icon_favorite);
                }
                else
                {
                    FavoriteImage.setImageResource(R.drawable.icon_unfavorite);
                }
            }

            //Keo len
            if((e1.getY() - e2.getY() > 100 && Math.abs(velocityY)>100)){
                pictureTool.setVisibility(View.VISIBLE);
            }
            //Keo xuong
            if((e2.getY() - e1.getY() > 100 && Math.abs(velocityY)>100)){
                pictureTool.setVisibility(View.INVISIBLE);
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
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

    private void DeleteConfirmation()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo");
        //alertDialog.setIcon(R.drawable.ic_)
        alertDialog.setMessage("Bạn có muốn xoá Ảnh này không");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Albums.albumsList.get(IdAlbum).removePicture(IdImage);
                PicturesView.picturesAdapter.notifyDataSetChanged();
                finish();
            }
        });

        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }
}
