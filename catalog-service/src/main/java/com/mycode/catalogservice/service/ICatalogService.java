package com.mycode.catalogservice.service;

import com.mycode.catalogservice.api.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICatalogService {

    UUID createCatalog(final Catalog catalog);

    void deleteCatalog(final String catalogId);

    List<Catalog> getAllCatalogs();

    Optional<Catalog> getCatalogById(final String catalogId);

    Catalog updateCatalog(final String catalogId, final Catalog catalog);
}
