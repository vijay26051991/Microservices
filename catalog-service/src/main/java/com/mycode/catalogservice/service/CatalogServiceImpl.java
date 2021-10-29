package com.mycode.catalogservice.service;

import com.mycode.catalogservice.api.Catalog;
import com.mycode.catalogservice.data.CatalogEntity;
import com.mycode.catalogservice.repositories.CatalogCrudRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CatalogServiceImpl implements ICatalogService {

    @Autowired
    private CatalogCrudRepository catalogCrudRepository;

    @Override
    public UUID createCatalog(Catalog catalog) {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setCatalogName(catalog.getCatalogName());
        catalogEntity.setClientName(catalog.getClientName());
        catalogEntity.setItems(catalog.getItems());

        final CatalogEntity persistedCataLogEntity = catalogCrudRepository.save(catalogEntity);

        return persistedCataLogEntity.getCatalogId();
    }

    @Override
    public void deleteCatalog(String catalogId) {
        catalogCrudRepository.deleteById(Long.valueOf(catalogId));
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        List<Catalog> catalogs = List.of();
        Iterator<CatalogEntity> catalogEntityIterator = catalogCrudRepository
                .findAll().iterator();
        while (catalogEntityIterator.hasNext()) {
            Catalog catalog = Catalog.createCatalog();
            BeanUtils.copyProperties(catalogEntityIterator.next(), catalog);
            catalogs.add(catalog);
        }
        return catalogs;
    }

    @Override
    public Optional<Catalog> getCatalogById(String catalogId) {
        Catalog catalog = Catalog.createCatalog();
        BeanUtils.copyProperties(catalogCrudRepository.findById(Long.valueOf(catalogId)), catalog);
        return Optional.ofNullable(catalog);
    }

    @Override
    public Catalog updateCatalog(String catalogId, Catalog catalog) {

        return null;
    }
}
