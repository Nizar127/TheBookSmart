package com.thebooksmart.booksmart;

public class ListItem {

    private int id;
    private String bizImg;
    private String availBiz;
    private String availBizDetail;
    private String viewPackage;
    private String imageURL;



    public ListItem(int id, String bizImg, String availBiz, String availBizDetail, String viewPackage, String imageURL) {
        this.id = id;
        this.bizImg = bizImg;
        this.availBiz = availBiz;
        this.availBizDetail = availBizDetail;
        this.viewPackage = viewPackage;
        this.imageURL = imageURL;
    }

    public ListItem(int id, String bizImg, String availBiz, String availBizDetail) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBizImg() {
        return bizImg;
    }

    public void setBizImg(String bizImg) {
        this.bizImg = bizImg;
    }

    public String getAvailBiz() {
        return availBiz;
    }

    public void setAvailBiz(String availBiz) {
        this.availBiz = availBiz;
    }

    public String getAvailBizDetail() {
        return availBizDetail;
    }

    public void setAvailBizDetail(String availBizDetail) {
        this.availBizDetail = availBizDetail;
    }

    public String getViewPackage() {
        return viewPackage;
    }

    public void setViewPackage(String viewPackage) {
        this.viewPackage = viewPackage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

