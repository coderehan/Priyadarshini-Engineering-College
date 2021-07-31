package com.pec.priyadarshiniengineeringcollegeapp;

public class ModalNotes {

    String pdf_name, dept, semester, url;

    //empty constructor
    public ModalNotes() {
    }

    public ModalNotes(String pdf_name, String dept, String semester, String url) {
        this.pdf_name = pdf_name;
        this.dept = dept;
        this.semester = semester;
        this.url = url;
    }

    public String getPdf_name() {
        return pdf_name;
    }

    public void setPdf_name(String pdf_name) {
        this.pdf_name = pdf_name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
