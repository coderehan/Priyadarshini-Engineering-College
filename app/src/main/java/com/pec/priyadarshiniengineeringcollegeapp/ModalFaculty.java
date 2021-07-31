package com.pec.priyadarshiniengineeringcollegeapp;

public class ModalFaculty {

    String image, name, designation, dept, unique_key;

    //empty constructor
    public ModalFaculty() {
    }

    public ModalFaculty(String image, String name, String designation, String dept, String unique_key) {
        this.image = image;
        this.name = name;
        this.designation = designation;
        this.dept = dept;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }
}
