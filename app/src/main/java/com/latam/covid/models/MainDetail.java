package com.latam.covid.models;

public class MainDetail {

    private int imageBigIcon;
    private String name;
    private String detail;

    public MainDetail (String oName, String oDetail, int oImage){

        this.name = oName;
        this.detail = oDetail;
        this.imageBigIcon = oImage;

     }
     public MainDetail(){

     }

    public int getImageBigIcon() {
        return imageBigIcon;
    }

    public void setImageBigIcon(int imageBigIcon) {
        this.imageBigIcon = imageBigIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
