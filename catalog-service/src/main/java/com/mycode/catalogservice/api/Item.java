package com.mycode.catalogservice.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@DynamoDBDocument
public class Item {

    @MustRequired
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String itemName;

    @MustRequired
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String itemDescription;

    @MustRequired(required = false)
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private LocalDateTime availableStTime;

    @MustRequired(required = false)
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private LocalDateTime endStTime;

    @MustRequired
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private BigDecimal price;

    @MustRequired
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private Integer availableQuantity;

    @MustRequired
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private Availability availability;

    public Item() {

    }

    @JsonCreator
    public static Item createItem(
                @JsonProperty("item_name") String itemName,
                @JsonProperty("item_desc") String itemDescription,
                @JsonProperty("item_avail_start") LocalDateTime availableStTime,
                @JsonProperty("item_avail_end") LocalDateTime endStTime,
                @JsonProperty("price") BigDecimal price,
                @JsonProperty("available_quantity") Integer availableQuantity,
                @JsonProperty("item_availability") Availability itemAvailability) {
        return new Item(itemName, itemDescription, availableStTime, endStTime, price, availableQuantity, itemAvailability);
    }

    private Item(String itemName, String itemDescription, LocalDateTime availableStTime, LocalDateTime endStTime, BigDecimal price, Integer availableQuantity, Availability itemAvailability) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.availableStTime = availableStTime;
        this.endStTime = endStTime;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.availability = itemAvailability;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public LocalDateTime getAvailableStTime() {
        return availableStTime;
    }

    public LocalDateTime getEndStTime() {
        return endStTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public Availability getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", availableStTime=" + availableStTime +
                ", endStTime=" + endStTime +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemName != null ? !itemName.equals(item.itemName) : item.itemName != null) return false;
        if (itemDescription != null ? !itemDescription.equals(item.itemDescription) : item.itemDescription != null)
            return false;
        if (availableStTime != null ? !availableStTime.equals(item.availableStTime) : item.availableStTime != null)
            return false;
        if (endStTime != null ? !endStTime.equals(item.endStTime) : item.endStTime != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        return availableQuantity != null ? availableQuantity.equals(item.availableQuantity) : item.availableQuantity == null;
    }

    @Override
    public int hashCode() {
        int result = itemName != null ? itemName.hashCode() : 0;
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (availableStTime != null ? availableStTime.hashCode() : 0);
        result = 31 * result + (endStTime != null ? endStTime.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (availableQuantity != null ? availableQuantity.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }
}
