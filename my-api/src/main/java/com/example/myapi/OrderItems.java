package com.example.myapi;

import javax.persistence.*;

@Entity
@Table(name ="orders_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="id_zamowienie")
    private Long idOrder;

    @Column(nullable = false,name="id_item")
    private Long idItem;

    @Column(nullable = false,name="liczba_sztuk")
    private int itemCountered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
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


}
