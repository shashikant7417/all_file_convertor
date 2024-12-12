package com.shashikant.file_downloader.file_converter.helper;

import com.shashikant.file_downloader.file_converter.models.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper {

    public static String[] HEADERS = {
            "id",
            "about",
            "email",
            "name",
            "password"
    };

    public static String SHEET_NAME = "user_data";

    public static ByteArrayInputStream dataToExcel(List<User> list) throws IOException {

        // create Workbook

        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            // create Sheet

            Sheet sheet = workbook.createSheet(SHEET_NAME);

            // create Row Header

            Row row = sheet.createRow(0);

            // create cells

            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            // Values Rows

            int rowIndex = 1;

            for (User u : list) {

                Row dataRow = sheet.createRow(rowIndex);
                rowIndex++;
                dataRow.createCell(0).setCellValue(u.getId());
                dataRow.createCell(1).setCellValue(u.getAbout());
                dataRow.createCell(2).setCellValue(u.getEmail());
                dataRow.createCell(3).setCellValue(u.getName());
                dataRow.createCell(4).setCellValue(u.getPassword());
            }

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed to Import data in Excel");
            return null;

        } finally {
            workbook.close();
            out.close();
        }

    }
}
