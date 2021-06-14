package com.example.myapi;

import javax.persistence.Column;

public class BasketItemDisplay {

    private Long id;
    private String itemName;
    private String category;
    private String imageName;
    private String description;
    private double price;

    private Long idClient;
    private Long idItem;
    private int itemCountered;


    BasketItemDisplay(Item i, Basket b)
    {
        this.id = i.getId();
        this.itemName = i.getItemName();
        this.category = i.getCategory();
        this.imageName = i.getImageName();
        this.description = i.getDescription();
        this.price =  i.getPrice();

        this.idClient = b.getIdClient();
        this.idItem = b.getIdItem();
        this.itemCountered = b.getItemCountered();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public int getItemCountered() {
        return itemCountered;
    }

    public void setItemCountered(int itemCountered) {
        this.itemCountered = itemCountered;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
