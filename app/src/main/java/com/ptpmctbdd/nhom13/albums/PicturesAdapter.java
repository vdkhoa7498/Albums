package com.ptpmctbdd.nhom13.albums;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class PicturesAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<PicturesList> pictures_array;

    public PicturesAdapter(Context context, int layout, ArrayList<PicturesList> pictures_array) {
        this.context = context;
        this.layout = layout;
        this.pictures_array = pictures_array;
    }

    @Override
    public int getCount() {
        return pictures_array.size();
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
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.img = (ImageView) convertView.findViewById(R.id.ImageView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        PicturesList picList = pictures_array.get(position);
        holder.img.setImageResource(picList.getImage());

//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale_grid);
//        convertView.startAnimation(animation);

        return convertView;
    }

}
