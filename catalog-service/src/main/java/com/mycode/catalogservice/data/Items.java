package com.mycode.catalogservice.data;

import com.mycode.catalogservice.api.Item;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }


    private Items() {
        items = new ArrayList<>();
    }

    public static Items create(List<Item> items) {
        return new Items(items);
    }

    public static Items create() {
        final Items items = new Items();
        items.getItems().add(new Item());
        return items;
    }

    public void appendItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
