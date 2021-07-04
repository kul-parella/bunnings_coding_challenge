package com.bunnings.codeChallenge.helper;

import com.bunnings.codeChallenge.model.CatalogA;
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

    public static List<CatalogA> csvToCatalog(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){

            List<CatalogA> catalogItems = new ArrayList<CatalogA>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CatalogA catalogA = new CatalogA(
                        csvRecord.get(0),
                        csvRecord.get(1)
                );
                catalogItems.add(catalogA);
            }
            return catalogItems;
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
