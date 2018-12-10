package com.ptpmctbdd.nhom13.albums;

import java.util.ArrayList;

public class AlbumsList {
    private int Id;
    private String Name;
    private ArrayList<PicturesList> picturesList;

    public AlbumsList(int id, String name, ArrayList<PicturesList> picturesList) {
        Id = id;
        Name = name;
        this.picturesList = picturesList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<PicturesList> getPicturesList() {
        return picturesList;
    }

    public void setPicturesList(ArrayList<PicturesList> picturesList) {
        this.picturesList = picturesList;
    }

    public void removePicture(int position){
        picturesList.remove(position);
    }
}
