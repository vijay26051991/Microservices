package com.mycode.catalogservice.data;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.mycode.catalogservice.api.Item;
import com.mycode.catalogservice.converters.ItemsConverter;

import java.util.List;
import java.util.UUID;

@DynamoDBTable(tableName = "CATALOG")
public class CatalogEntity {

    @DynamoDBHashKey(attributeName = "CATALOG_ID")
    @DynamoDBAutoGeneratedKey
    private UUID catalogId;

    @DynamoDBAttribute(attributeName = "CATALOG_NAME")
    private String catalogName;

    @DynamoDBAttribute(attributeName = "CLIENT_NAME")
    private String clientName;

    @DynamoDBAttribute(attributeName = "ITEMS")
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    @DynamoDBTypeConverted(converter = ItemsConverter.class)
    private List<Item> items;


    public UUID getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(UUID catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}