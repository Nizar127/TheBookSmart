package com.thebooksmart.booksmart.Model;

public class businessList {
    private String bizName;
    private String bizDetails;
    private String bizMainProduct;
    private String bizKeywords;
    private String bizImg;
    private String bizPosition;

    public businessList(String bizName, String bizDetails, String bizMainProduct, String bizKeywords, String bizImg, String bizPosition) {
        this.bizName = bizName;
        this.bizDetails = bizDetails;
        this.bizMainProduct = bizMainProduct;
        this.bizKeywords = bizKeywords;
        this.bizImg = bizImg;
        this.bizPosition = bizPosition;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getBizDetails() {
        return bizDetails;
    }

    public void setBizDetails(String bizDetails) {
        this.bizDetails = bizDetails;
    }

    public String getBizMainProduct() {
        return bizMainProduct;
    }

    public void setBizMainProduct(String bizMainProduct) {
        this.bizMainProduct = bizMainProduct;
    }

    public String getBizKeywords() {
        return bizKeywords;
    }

    public void setBizKeywords(String bizKeywords) {
        this.bizKeywords = bizKeywords;
    }

    public String getBizImg() {
        return bizImg;
    }

    public void setBizImg(String bizImg) {
        this.bizImg = bizImg;
    }

    public String getBizPosition() {
        return bizPosition;
    }

    public void setBizPosition(String bizPosition) {
        this.bizPosition = bizPosition;
    }
}
