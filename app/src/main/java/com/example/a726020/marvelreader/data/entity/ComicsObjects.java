package com.example.a726020.marvelreader.data.entity;

import java.util.Date;

public class ComicsObjects {

    private String title;
    private String image;
    private String description;
    private String diamondCode;
    private Date date;
    private int pageCount;
    private double price;
    private Creators creators;

    public ComicsObjects(String title, String image, String description, String diamondCode, Date date, int pageCount, double price, Creators creators) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.diamondCode = diamondCode;
        this.date = date;
        this.pageCount = pageCount;
        this.price = price;
        this.creators = creators;
    }

    public ComicsObjects() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", diamondCode='" + diamondCode + '\'' +
                ", date=" + date +
                ", pageCount=" + pageCount +
                ", price=" + price +
                ", creators=" + creators ;
    }
}
