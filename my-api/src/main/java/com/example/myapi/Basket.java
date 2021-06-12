package com.example.myapi;

import javax.persistence.*;

@Entity
@Table(name ="basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="id_klient")
    private int idClient;

    @Column(nullable = false,name="id_item")
    private int idItem;

    @Column(nullable = false,name="liczba_sztuk")
    private int itemCountered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getItemCountered() {
        return itemCountered;
    }

    public void setItemCountered(int itemCountered) {
        this.itemCountered = itemCountered;
    }



    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idItem=" + idItem +
                ", itemCountered=" + itemCountered +
                '}'+'\n';
    }
}
