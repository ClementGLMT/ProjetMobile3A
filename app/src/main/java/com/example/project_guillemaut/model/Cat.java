package com.example.project_guillemaut.model;

import java.io.Serializable;

public class Cat implements Serializable {

    private String cat_pic;
    private String cat_name;
    private String cat_age;
    private String cat_mood;
    private String cat_color;
    private String cat_num;
    private String cat_height;
    private String cat_coat;

    public Cat(String cat_pic, String cat_name, String cat_age, String cat_mood, String cat_color, String cat_num, String cat_height, String cat_coat){
        this.cat_age = cat_age;
        this.cat_coat = cat_coat;
        this.cat_color = cat_color;
        this.cat_height = cat_height;
        this.cat_mood = cat_mood;
        this.cat_name = cat_name;
        this.cat_num = cat_num;
        this.cat_pic = cat_pic;

    }

    public String getCatPic() {
        return cat_pic;
    }

    public void setCatPic(String cat_pic) {
        this.cat_pic = cat_pic;
    }

    public Cat withCatPic(String cat_pic) {
        this.cat_pic = cat_pic;
        return this;
    }

    public String getCatName() {
        return cat_name;
    }

    public void setCatName(String cat_name) {
        this.cat_name = cat_name;
    }

    public Cat withCatName(String cat_name) {
        this.cat_name = cat_name;
        return this;
    }

    public String getCatAge() {
        return cat_age;
    }

    public void setCatAge(String cat_age) {
        this.cat_age = cat_age;
    }

    public Cat withCatAge(String cat_age) {
        this.cat_age = cat_age;
        return this;
    }

    public String getCatMood() {
        return cat_mood;
    }

    public void setCatMood(String cat_mood) {
        this.cat_mood = cat_mood;
    }

    public Cat withCatMood(String cat_mood) {
        this.cat_mood = cat_mood;
        return this;
    }

    public String getCatColor() {
        return cat_color;
    }

    public void setCatColor(String cat_color) {
        this.cat_color = cat_color;
    }

    public Cat withCatColor(String cat_color) {
        this.cat_color = cat_color;
        return this;
    }

    public String getCatNum() {
        return cat_num;
    }

    public void setCatNum(String cat_num) {
        this.cat_num = cat_num;
    }

    public Cat withCatNum(String cat_num) {
        this.cat_num = cat_num;
        return this;
    }

    public String getCatHeight() {
        return cat_height;
    }

    public void setCatHeight(String cat_height) {
        this.cat_height = cat_height;
    }

    public Cat withCatHeight(String cat_height) {
        this.cat_height = cat_height;
        return this;
    }

    public String getCatCoat() {
        return cat_coat;
    }

    public void setCatCoat(String cat_coat) {
        this.cat_coat = cat_coat;
    }

    public Cat withCatCoat(String cat_coat) {
        this.cat_coat = cat_coat;
        return this;
    }
}
