package com.ptpmctbdd.nhom13.albums;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Albums extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView Albums;
    ViewFlipper viewFlipper;
    int countImage;
    boolean loginOK = false;
    public static String password = "abc123";

    public static ArrayList<AlbumsList> albumsList;
    private ArrayList<PicturesList> arrayPicturesList, arrayPicturesList1, arrayPicturesList2;
    public static AlbumsAdapter albumsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewFlipper = (ViewFlipper) findViewById(R.id.ImagesViewFlipper);
        Albums = (GridView) findViewById((R.id.AlbumsView)) ;
        setSupportActionBar(toolbar);
        DialogLogin();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        arrayPicturesList = new ArrayList<>();
        arrayPicturesList.add(new PicturesList(0, 0, "Chùa Thiên Mụ", R.drawable.chuathienmu));
        arrayPicturesList.add(new PicturesList(1, 0, "Chùa Huyền Không", R.drawable.chuahuyenkhong));
        arrayPicturesList.add(new PicturesList(2, 0, "Chùa Tử Đàm", R.drawable.chuatudam));
        arrayPicturesList.add(new PicturesList(3, 0, "Chùa Thiền Lâm", R.drawable.chuathienlam));
        arrayPicturesList.add(new PicturesList(4, 0, "Lăng Khải Đình", R.drawable.langkhaidinh));
        arrayPicturesList.add(new PicturesList(5, 0, "Lăng Minh Mạng", R.drawable.langminhmang));
        arrayPicturesList.add(new PicturesList(6, 0, "Núi Ngự Bình", R.drawable.nuingubinh));
        arrayPicturesList.add(new PicturesList(7, 0, "Sông Hương", R.drawable.songhuong));
        arrayPicturesList.add(new PicturesList(8, 0, "Núi Bạch Mã", R.drawable.nuibachma));

        arrayPicturesList.get(0).setLongitude(16.453200); arrayPicturesList.get(0).setLatitude(107.544848);
        arrayPicturesList.get(2).setLongitude(16.451340); arrayPicturesList.get(2).setLatitude(107.581813);
        arrayPicturesList.get(7).setLongitude(16.472239); arrayPicturesList.get(7).setLatitude(107.592103);

        arrayPicturesList1 = new ArrayList<>();
        arrayPicturesList1.add(new PicturesList(0, 1, "Hồ Tuyền Lâm", R.drawable.hotuyenlam));
        arrayPicturesList1.add(new PicturesList(1, 1, "Ga Đà Lạt", R.drawable.gadalat));
        arrayPicturesList1.add(new PicturesList(2, 1, "Núi Langbiang", R.drawable.nuilangbiang));
        arrayPicturesList1.add(new PicturesList(3, 1, "Làng Cù Lần", R.drawable.langculan));
        arrayPicturesList1.add(new PicturesList(4, 1, "Đồi Mộng Mơ", R.drawable.doimongmo));
        arrayPicturesList1.add(new PicturesList(5, 1, "Thung Lũng Tình Yêu", R.drawable.thunglungtinhyeu));
        arrayPicturesList1.add(new PicturesList(6, 1, "Chùa Phước Linh", R.drawable.chuaphuoclinh));
        arrayPicturesList1.add(new PicturesList(7, 1, "Biệt điện Trần Lệ Xuân", R.drawable.bietdientranlexuan));

        arrayPicturesList.get(0).setLongitude(11.899937); arrayPicturesList1.get(0).setLatitude(108.429845);
        arrayPicturesList.get(1).setLongitude(11.941680); arrayPicturesList1.get(1).setLatitude(108.454443);
        arrayPicturesList.get(7).setLongitude(11.945894); arrayPicturesList1.get(7).setLatitude(108.426076);

        arrayPicturesList2 = new ArrayList<>();
        arrayPicturesList2.add(new PicturesList(0, 2, "Bear", R.drawable.bear));
        arrayPicturesList2.add(new PicturesList(1, 2, "Bird", R.drawable.bird));
        arrayPicturesList2.add(new PicturesList(2, 2, "Cat", R.drawable.cat));
        arrayPicturesList2.add(new PicturesList(3, 2, "Chicken", R.drawable.chicken));
        arrayPicturesList2.add(new PicturesList(4, 2, "Dog", R.drawable.dog));
        arrayPicturesList2.add(new PicturesList(5, 2, "Fox", R.drawable.fox));
        arrayPicturesList2.add(new PicturesList(6, 2, "Hamster", R.drawable.hamster));

        albumsList = new ArrayList<>();
        albumsList.add(new AlbumsList(0, "Huế", arrayPicturesList));
        albumsList.add(new AlbumsList(1, "Đà Lạt", arrayPicturesList1));
        albumsList.add(new AlbumsList(2, "Động Vật", arrayPicturesList2));

        for(int i = 0 ;i< albumsList.size(); i++)
        {
            for (int j = 0; j < albumsList.get(i).getPicturesList().size(); j++)
            {
                ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(albumsList.get(i).getPicturesList().get(j).getImage());
                viewFlipper.addView(imageView);
            }
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(Albums.this,R.anim.slide_in);
        viewFlipper.setOutAnimation(Albums.this,R.anim.slide_out);


        albumsAdapter = new AlbumsAdapter(Albums.this,R.layout.album_view, albumsList);
        Albums.setAdapter(albumsAdapter);

        Albums.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent chosenImage = new Intent(Albums.this, PicturesView.class);
                chosenImage.putExtra("IdAlbum", position);
                startActivity(chosenImage);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.albums, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_camera:
                Toast.makeText(Albums.this, "OK Camera", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_favorite:
                Intent nav_favorite = new Intent(Albums.this, Nav_Favorite.class);
                startActivity(nav_favorite);
                break;

            case R.id.nav_location:
                Intent nav_location = new Intent(Albums.this, Nav_Location.class);
                startActivity(nav_location);
                break;

            case R.id.nav_slideshow:
                Intent nav_slideshow = new Intent(Albums.this, Nav_Slideshow.class);
                startActivity(nav_slideshow);
                break;

            case R.id.nav_security:
                Intent nav_security = new Intent (Albums.this, Nav_Security.class);
                startActivity(nav_security);

            case R.id.nav_help:
                break;
            case R.id.nav_setting:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void DialogLogin()
    {
        final Dialog dialogLogin = new Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        dialogLogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLogin.setContentView(R.layout.dialog_login);
        dialogLogin.setCanceledOnTouchOutside(false);

        final EditText edtPassword = (EditText) dialogLogin.findViewById(R.id.passwordLogin);
        Button btnLogin = (Button) dialogLogin.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) dialogLogin.findViewById(R.id.btnExit);
        final TextView notification = (TextView) dialogLogin.findViewById(R.id.notification);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass  = edtPassword.getText().toString().trim();
                if (pass.equals(password))
                {
                    dialogLogin.dismiss();
                }
                else
                {
                    notification.setText("Sai mật khẩu! Vui lòng nhập lại.");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dialogLogin.show();
    }

}
