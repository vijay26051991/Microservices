package com.mycode.catalogservice.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.mycode.catalogservice.api.Item;
import com.mycode.catalogservice.data.Items;

import java.util.List;

public class ItemsConverter implements DynamoDBTypeConverter<List<Item>, Items> {
    @Override
    public List<Item> convert(Items items) {
        return items.getItems();
    }

    @Override
    public Items unconvert(List<Item> items) {
        if (items.isEmpty()) {
            return Items.create();
        }
        return Items.create(items);
    }
}
