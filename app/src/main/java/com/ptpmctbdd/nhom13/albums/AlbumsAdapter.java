package com.ptpmctbdd.nhom13.albums;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<AlbumsList> albums_array;

    public AlbumsAdapter(Context context, int layout, ArrayList<AlbumsList> albums_array) {
        this.context = context;
        this.layout = layout;
        this.albums_array = albums_array;
    }

    @Override
    public int getCount() {
        return albums_array.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView img;
        TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlbumsAdapter.ViewHolder holder;

        if(convertView == null){
            holder = new AlbumsAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.img = (ImageView) convertView.findViewById(R.id.gv_imageAlbum);
            holder.name = (TextView) convertView.findViewById(R.id.gv_nameAlbum);
            convertView.setTag(holder);
        }
        else
        {
            holder = (AlbumsAdapter.ViewHolder) convertView.getTag();
        }

        AlbumsList albumsList = albums_array.get(position);
        holder.img.setImageResource(albumsList.getPicturesList().get(0).getImage());
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.name.setText(albumsList.getName());

//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale_grid);
//        convertView.startAnimation(animation);

        return convertView;
    }
}
