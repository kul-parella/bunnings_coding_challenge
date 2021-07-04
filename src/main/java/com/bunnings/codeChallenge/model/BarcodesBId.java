package com.bunnings.codeChallenge.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BarcodesBId implements Serializable {

    private Long supplierId;
    private String sku;

    public BarcodesBId() {
    }

    public BarcodesBId(Long supplierId, String sku) {
        this.supplierId = supplierId;
        this.sku = sku;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarcodesBId that = (BarcodesBId) o;

        if (!supplierId.equals(that.supplierId)) return false;
        return sku.equals(that.sku);
    }

    @Override
    public int hashCode() {
        int result = supplierId.hashCode();
        result = 31 * result + sku.hashCode();
        return result;
    }
}
