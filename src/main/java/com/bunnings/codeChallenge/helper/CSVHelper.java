package com.bunnings.codeChallenge.helper;

import com.bunnings.codeChallenge.model.*;
import org.apache.commons.csv.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Created by Kuladeep Parella on 04/07/2021
 */
@Component
public class CSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List csvToCatalog(InputStream is, String nameOfCVSRecord) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){

            List<CSVRecord> csvRecords = csvParser.getRecords();

            List returnList = new ArrayList<>();

           switch (nameOfCVSRecord) {

               case "CATALOGA" :

                   csvRecords.stream().forEach(csvRecord ->
                   returnList.add(new CatalogA(
                           csvRecord.get(0),
                           csvRecord.get(1))));
                   break;

               case "CATALOGB" :

                   csvRecords.stream().forEach(csvRecord ->
                           returnList.add(new CatalogB(
                                   csvRecord.get(0),
                                   csvRecord.get(1))));
                   break;

               case "BARCODESA" :

                   csvRecords.stream().forEach(csvRecord ->
                           returnList.add(

                                   new BarcodesA(
                                   new BarcodesAId(Long.parseLong(csvRecord.get(0)), csvRecord.get(1)),
                                   csvRecord.get(2))));
                   break;

               case "BARCODESB" :

                   csvRecords.stream().forEach(csvRecord ->
                           returnList.add(
                                   new BarcodesB(
                                           new BarcodesBId(Long.parseLong(csvRecord.get(0)), csvRecord.get(1)),
                                           csvRecord.get(2))));
                   break;
               case "SUPPLIERSA" :

                   csvRecords.stream().forEach(csvRecord ->
                           returnList.add(new SuppliersA(
                                   Long.parseLong(csvRecord.get(0)),
                                   csvRecord.get(1))));
                   break;
               case "SUPPLIERSB" :

                   csvRecords.stream().forEach(csvRecord ->
                           returnList.add(new SuppliersB(
                                   Long.parseLong(csvRecord.get(0)),
                                   csvRecord.get(1))));
                   break;
               default:
                       break;

           }
            return returnList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }



    public static ByteArrayInputStream CatalogAToCSV(List<CatalogA> catalogAItems) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (CatalogA catalogA : catalogAItems) {
                List<String> data = Arrays.asList(
                        catalogA.getSku(),
                        catalogA.getDescription()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
