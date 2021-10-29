package com.mycode.catalogservice.controller;

import com.mycode.catalogservice.api.Catalog;
import com.mycode.catalogservice.api.CatalogResponse;
import com.mycode.catalogservice.service.CatalogServiceImpl;
import com.mycode.catalogservice.service.ICatalogService;
import com.mycode.catalogservice.validators.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

//    private RequestValidator catalogRequestValidator;

    @Autowired
    private ICatalogService catalogService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CatalogResponse createCatalog(@RequestBody final Catalog catalog) throws IllegalAccessException {
        return new CatalogResponse(catalogService.createCatalog(catalog), HttpStatus.OK);
    }

    @DeleteMapping(value = "byId/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CatalogResponse deleteCatalog(@PathParam("catalogId") String catalogId) throws IllegalAccessException {
        catalogService.deleteCatalog(catalogId);
        return new CatalogResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CatalogResponse allCatalogs() throws IllegalAccessException {
        return new CatalogResponse(catalogService.getAllCatalogs(), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "byId/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CatalogResponse byCatalogId(@PathParam("catalogId") String catalogId) throws IllegalAccessException {
        return new CatalogResponse(catalogService.getCatalogById(catalogId), HttpStatus.OK);
    }
}
