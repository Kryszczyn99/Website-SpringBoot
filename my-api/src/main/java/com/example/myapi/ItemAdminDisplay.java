package com.example.myapi;

import java.util.ArrayList;
import java.util.List;

public class ItemAdminDisplay {

    List<String> itemName;
    List<Integer> count;


    public ItemAdminDisplay()
    {
        itemName = new ArrayList<>();
        count = new ArrayList<>();
    }
    public List<String> getItemName() {
        return itemName;
    }

    public void setItemName(List<String> itemName) {
        this.itemName = itemName;
    }

    public List<Integer> getCount() {
        return count;
    }

    public void setCount(List<Integer> count) {
        this.count = count;
    }
    public void addItemName(String itemName)
    {
        this.itemName.add(itemName);
    }
    public void addCount(int count)
    {
        this.count.add(count);
    }
}
