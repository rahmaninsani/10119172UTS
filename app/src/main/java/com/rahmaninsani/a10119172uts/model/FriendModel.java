/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts.model;

public class FriendModel {

    int image;
    String name;

    public FriendModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getNama() {
        return name;
    }

}
