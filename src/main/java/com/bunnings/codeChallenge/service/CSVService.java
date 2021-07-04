package com.bunnings.codeChallenge.service;

import com.bunnings.codeChallenge.helper.CSVHelper;
import com.bunnings.codeChallenge.model.CatalogA;
import com.bunnings.codeChallenge.repository.CatalogA_Repo;
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

    public void saveCatalogA(MultipartFile file) {
        try {
            List<CatalogA> catalogItems = CSVHelper.csvToCatalog(file.getInputStream());
            catalogA_repo.saveAll(catalogItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


    public ByteArrayInputStream getMergedCatalog() {
        List<CatalogA> catalogAItems =  catalogA_repo.findAll();
        return CSVHelper.CatalogAToCSV(catalogAItems);

    }
}

