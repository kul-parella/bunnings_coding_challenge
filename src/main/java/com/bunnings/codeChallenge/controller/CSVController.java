package com.bunnings.codeChallenge.controller;

import com.bunnings.codeChallenge.service.CSVService;
import com.bunnings.codeChallenge.helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/*
Created by Kuladeep Parella on 04/07/2021
 */
@Controller
@RequestMapping("/api/bunnings")
public class CSVController {

        @Autowired
        CSVService fileService;


    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadCatalogA(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {

            try {
                if("catalogA.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveCatalogA(file);
                }
                else  if("catalogB.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveCatalogB(file);
                }
                else  if("barcodesA.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveBarcodesA(file);
                }
                else  if("barcodesB.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveBarcodesB(file);
                }
                else  if("suppliersA.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveSuppliersA(file);
                }else  if("suppliersB.csv".equalsIgnoreCase(file.getOriginalFilename())){
                    fileService.saveSuppliersB(file);
                }else {
                    message = "Could not upload the file as file name is not good: " + file.getOriginalFilename() + "!";
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("\" message \": \" "+ message +" \"");
                }


                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body( "\" message \": \" "+ message +" \"");
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("\" message \": \" "+ message +" \"");
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\" message \": \" "+ message +" \"");
    }


    @GetMapping("/downloadMergedCatalog")
    public ResponseEntity<Resource> getFile() {
        String filename = "result_output.csv";
        InputStreamResource file = new InputStreamResource(fileService.getMergedCatalog());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}


