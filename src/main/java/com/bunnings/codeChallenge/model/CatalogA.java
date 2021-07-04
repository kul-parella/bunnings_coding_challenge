package com.bunnings.codeChallenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Created by Kuladeep Parella on 04/07/2021
 */
@Data
@NoArgsConstructor
@Entity
public class CatalogA {

    @Id
    private String sku;
    private String description;

    public CatalogA(String sku, String description) {
        this.sku = sku;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
