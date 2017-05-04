package com.example.kh.spinnerdemo;

/**
 * Created by kh on 5/4/2017.
 */

public class Person {
    private int image;
    private String name;
    public Person(String name, int image){
        this.image  = image;
        this.name  = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
