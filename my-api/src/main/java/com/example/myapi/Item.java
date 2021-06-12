package com.example.myapi;


import javax.persistence.*;

@Entity
@Table(name ="items")
public class Item {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=100,name="nazwa_produktu")
    private String itemName;

    @Column(nullable = false,length=50,name="kategoria")
    private String category;

    @Column(nullable = false,length=50,name="obraz_nazwa")
    private String imageName;

    @Column(nullable = false,length=50,name="opis")
    private String description;

    @Column(nullable = false,name="cena")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
