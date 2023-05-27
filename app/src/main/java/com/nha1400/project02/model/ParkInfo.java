package com.nha1400.project02.model;

public class ParkInfo {
    String name;
    String addr;
    int image;

    public ParkInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return addr;
    }

    public void setAdd(String addr) {
        this.addr = addr;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ParkInfo(String name, String addr, int image) {
        this.name = name;
        this.addr = addr;
        this.image =image;
    }

}