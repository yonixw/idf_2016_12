package com.example.lesson3_listview;

/**
 * Created by eladlavi on 13/12/2016.
 */

public class City {

    private String name;
    private boolean isSelected;
    private int image;

    public City(String name, int image) {
        this.name = name;
        this.image = image;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return name;
    }
}
