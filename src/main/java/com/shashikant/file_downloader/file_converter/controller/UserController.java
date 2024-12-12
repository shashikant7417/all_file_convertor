package com.shashikant.file_downloader.file_converter.controller;

import com.shashikant.file_downloader.file_converter.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/convertor")
public class UserController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/excel")
    public ResponseEntity<Resource> databaseToExcel() throws IOException {

        String fileName = "user.xlsx";
         ByteArrayInputStream actualData = excelService.getActualData();
        InputStreamResource inputStreamResource = new InputStreamResource(actualData);

         return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName).
                contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(inputStreamResource);




    }
}
