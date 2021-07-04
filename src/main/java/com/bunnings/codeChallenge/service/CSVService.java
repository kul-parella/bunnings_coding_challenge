package com.bunnings.codeChallenge.service;

import com.bunnings.codeChallenge.helper.CSVHelper;
import com.bunnings.codeChallenge.model.*;
import com.bunnings.codeChallenge.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    CatalogA_Repo catalogA_repo;

    @Autowired
    CatalogB_Repo catalogB_repo;

    @Autowired
    BarcodesA_Repo barcodesA_repo;

    @Autowired
    BarcodesB_Repo barcodesB_repo;

    @Autowired
    SuppliersA_Repo suppliersA_Repo;

    @Autowired
    SuppliersB_Repo suppliersB_Repo;



    public void saveCatalogA(MultipartFile file) {
        try {
            List<CatalogA> catalogItems = CSVHelper.csvToCatalog(file.getInputStream(), "CATALOGA");
            catalogA_repo.saveAll(catalogItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveCatalogB(MultipartFile file) {
        try {
            List<CatalogB> catalogItems = CSVHelper.csvToCatalog(file.getInputStream(), "CATALOGB");
            catalogB_repo.saveAll(catalogItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


    public void saveBarcodesA(MultipartFile file) {
        try {
            List<BarcodesA> barcodesAItems = CSVHelper.csvToCatalog(file.getInputStream(), "BARCODESA");
            barcodesA_repo.saveAll(barcodesAItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveBarcodesB(MultipartFile file) {
        try {
            List<BarcodesB> barcodesBItems = CSVHelper.csvToCatalog(file.getInputStream(), "BARCODESB");
            barcodesB_repo.saveAll(barcodesBItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveSuppliersA(MultipartFile file) {
        try {
            List<SuppliersA> suppliersAItems = CSVHelper.csvToCatalog(file.getInputStream(), "SUPPLIERSA");
            suppliersA_Repo.saveAll(suppliersAItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveSuppliersB(MultipartFile file) {
        try {
            List<SuppliersB> suppliersBItems = CSVHelper.csvToCatalog(file.getInputStream(), "SUPPLIERSB");
            suppliersB_Repo.saveAll(suppliersBItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


    public ByteArrayInputStream getMergedCatalog() {
        List<CatalogA> catalogAItems =  catalogA_repo.findAll();
        return CSVHelper.CatalogAToCSV(catalogAItems);

    }
}

