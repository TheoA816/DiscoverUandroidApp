package com.example.universities;

import android.widget.ImageView;

public class university {

    private String uniName;
    private String uniPhoto;
    private String city;
    private Integer QSworldRank;
    private String initial;

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public Integer getQSworldRank() {
        return QSworldRank;
    }

    public void setQSworldRank(Integer QSworldRank) {
        this.QSworldRank = QSworldRank;
    }

    public String getUniPhoto() {
        return uniPhoto;
    }

    public void setUniPhoto(String uniPhoto) {
        this.uniPhoto = uniPhoto;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public university(String uniName, Integer QSworldRank, String uniPhoto, String city, String initial) {
        this.uniName = uniName;
        this.QSworldRank = QSworldRank;
        this.uniPhoto = uniPhoto;
        this.city = city;
        this.initial = initial;
    }


}
