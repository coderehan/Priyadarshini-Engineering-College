package com.pec.priyadarshiniengineeringcollegeapp;

public class ModalCorrespondent {

    String image, name, message, unique_key;

    //empty constructor
    public ModalCorrespondent() {
    }

    public ModalCorrespondent(String image, String name, String message, String unique_key) {
        this.image = image;
        this.name = name;
        this.message = message;
        this.unique_key = unique_key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }
}
