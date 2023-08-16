package com.xmlreader.testproject.controller;

import com.xmlreader.testproject.service.ParsedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ParsedDataController {

    private final ParsedDataService parsedDataService;

    @Autowired
    public ParsedDataController(ParsedDataService parsedDataService) {
        this.parsedDataService = parsedDataService;
    }

    @PostMapping("/parsed-data/save")
    public ResponseEntity<String> saveParsedData(@RequestParam("xmlFile") MultipartFile xmlFile) {
        try {
            // Read bytes from the MultipartFile's InputStream
            byte[] bytes = xmlFile.getBytes();

            // Create a String from the byte array using the appropriate encoding
            // For example, using UTF-8 encoding:
            String xmlData = new String(bytes, "UTF-8");
            parsedDataService.saveParsedDataFromXml(xmlData);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data successfully saved to the database.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data to the database.");
        }
    }
}

