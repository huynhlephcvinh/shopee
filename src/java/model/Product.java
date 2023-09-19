/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author ACER-PC
 */
public class Product {
    private int id;
    private String img;
    private String name;
    private BigDecimal priceOld;
    private BigDecimal priceNew;
    private int sold;
    private String brand;
    private String origin;
    private int sale;
    private String description;
    private boolean onOffSale;
    private boolean yeuThich;
    private int category;

    public Product(int id, String img, String name, BigDecimal priceOld, BigDecimal priceNew, int sold, String brand, String origin, int sale, String description, boolean onOffSale, boolean yeuThich, int category) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.sold = sold;
        this.brand = brand;
        this.origin = origin;
        this.sale = sale;
        this.description = description;
        this.onOffSale = onOffSale;
        this.yeuThich = yeuThich;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    

    public boolean getOnOffSale() {
        return onOffSale;
    }

    public void setOnOffSale(boolean onOffSale) {
        this.onOffSale = onOffSale;
    }

    public boolean getYeuThich() {
        return yeuThich;
    }

    public void setYeuThich(boolean yeuThich) {
        this.yeuThich = yeuThich;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    public BigDecimal getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
    
}
