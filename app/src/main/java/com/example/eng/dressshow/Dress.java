package com.example.eng.dressshow;

import java.io.Serializable;

public class Dress implements Serializable {
    private  String dressDescription;
    private  String dressImage ;
    private  String expectedWieght;
    private  String contactInfo;
    private  String price;

    public Dress(String dressDescription, String dressImage, String expectedWieght, String contactInfo, String price) {
        this.dressDescription = dressDescription;
        this.dressImage = dressImage;
        this.expectedWieght = expectedWieght;
        this.contactInfo = contactInfo;
        this.price = price;
    }

    public Dress() {
    }

    public String getDressDescription() {
        return dressDescription;
    }

    public void setDressDescription(String dressDescription) {
        this.dressDescription = dressDescription;
    }

    public String getDressImage() {
        return dressImage;
    }

    public void setDressImage(String dressImage) {
        this.dressImage = dressImage;
    }

    public String getExpectedWieght() {
        return expectedWieght;
    }

    public void setExpectedWieght(String expectedWieght) {
        this.expectedWieght = expectedWieght;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
