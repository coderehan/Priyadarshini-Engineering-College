package com.pec.priyadarshiniengineeringcollegeapp;

public class ModalNotice {

    String title, image, date, time, unique_key;

    //empty constructor
    public ModalNotice() {
    }

    public ModalNotice(String title, String image, String date, String time, String unique_key) {
        this.title = title;
        this.image = image;
        this.date = date;
        this.time = time;
        this.unique_key = unique_key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }
}
