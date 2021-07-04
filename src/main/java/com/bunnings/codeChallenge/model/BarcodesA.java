package com.bunnings.codeChallenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/*
Created by Kuladeep Parella on 05/07/2021
 */
@Data
@Entity
public class BarcodesA {

    @EmbeddedId
    private BarcodesAId barcodesAId;
    private String barcode;

    public BarcodesA() {
    }

    public BarcodesA(BarcodesAId barcodesAId, String barcode) {
        this.barcodesAId = barcodesAId;
        this.barcode = barcode;
    }

    public BarcodesAId getBarcodesAId() {
        return barcodesAId;
    }

    public void setBarcodesAId(BarcodesAId barcodesAId) {
        this.barcodesAId = barcodesAId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
