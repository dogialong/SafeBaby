package com.safebaby.vtree.safebaby.model;

/**
 * Created by NamLong on 10/11/2016.
 */

public class Category_Item {
    private String nameCate;
    private int imageCatel;

    public Category_Item(String nameCate, int imageCatel) {
        this.nameCate = nameCate;
        this.imageCatel = imageCatel;
    }

    public Category_Item() {
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public int getImageCatel() {
        return imageCatel;
    }

    public void setImageCatel(int imageCatel) {
        this.imageCatel = imageCatel;
    }
}
