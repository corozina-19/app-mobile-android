package com.latam.covid.models;


import java.io.Serializable;

public class EQuestions implements Serializable {

    private String name;
    private Boolean info;
    private boolean covid19;
    private boolean checked;


    public EQuestions(String oName, Boolean oDetail, Boolean checked, Boolean covid19) {

        this.name = oName;
        this.info = oDetail;
        this.checked = checked;
        this.covid19 = covid19;

    }

    public EQuestions() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDetail() {
        return info;
    }

    public void setDetail(Boolean detail) {
        this.info = detail;
    }

    public Boolean getInfo() {
        return info;
    }

    public void setInfo(Boolean info) {
        this.info = info;
    }

    public boolean isCovid19() {
        return covid19;
    }

    public void setCovid19(boolean covid19) {
        this.covid19 = covid19;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}