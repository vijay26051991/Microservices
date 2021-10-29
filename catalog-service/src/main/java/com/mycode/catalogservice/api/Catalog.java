package com.mycode.catalogservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Catalog {

    @MustRequired
    private String catalogName;

    @MustRequired
    private String clientName;

    @MustRequired
    private Integer noOfItems;

    @MustRequired(required = false)
    private List<Item> items;

    private String catalogId;

    private Catalog() {
    }

    private Catalog(final String catalogId,
                    final String catalogName,
                    final String clientName,
                    final Integer noOfItems,
                    final List<Item> items) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.clientName = clientName;
        this.noOfItems = noOfItems;
        this.items = items;
    }

    public static Catalog createCatalog() {
        return new Catalog();
    }

    @JsonCreator
    public static Catalog createCatalog(@JsonProperty("catalog_id") String catalogId,
                                        @JsonProperty("catalog_name") String catalogName,
                                        @JsonProperty("client_name") String clientName,
                                        @JsonProperty("no_of_items") Integer noOfItems,
                                        @JsonProperty("items") List<Item> items) {

        return new Catalog(catalogId, catalogName, clientName, noOfItems, items);
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getNoOfItems() {
        return noOfItems;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogName='" + catalogName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", noOfItems=" + noOfItems +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (catalogName != null ? !catalogName.equals(catalog.catalogName) : catalog.catalogName != null) return false;
        if (clientName != null ? !clientName.equals(catalog.clientName) : catalog.clientName != null) return false;
        if (noOfItems != null ? !noOfItems.equals(catalog.noOfItems) : catalog.noOfItems != null) return false;
        return items != null ? items.equals(catalog.items) : catalog.items == null;
    }

    @Override
    public int hashCode() {
        int result = catalogName != null ? catalogName.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (noOfItems != null ? noOfItems.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }
}
