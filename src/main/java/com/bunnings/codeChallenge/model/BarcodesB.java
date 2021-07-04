package com.bunnings.codeChallenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
Created by Kuladeep Parella on 05/07/2021
 */
@Data
@NoArgsConstructor
@Entity
public class BarcodesB {

  @EmbeddedId
  private BarcodesBId barcodesBId;

  private String barcode;

    public BarcodesB(BarcodesBId barcodesBId, String barcode) {
        this.barcodesBId = barcodesBId;
        this.barcode = barcode;
    }

    public BarcodesBId getBarcodesBId() {
        return barcodesBId;
    }

    public void setBarcodesBId(BarcodesBId barcodesBId) {
        this.barcodesBId = barcodesBId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
