package com.pec.priyadarshiniengineeringcollegeapp;

public class ModalGallery {

    String image, category;

    //empty constructor
    public ModalGallery() {
    }

    public ModalGallery(String image, String category) {
        this.image = image;
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
