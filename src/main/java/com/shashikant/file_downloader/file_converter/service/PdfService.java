package com.shashikant.file_downloader.file_converter.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    public ByteArrayInputStream createPdf(){
        logger.info("create PDF started");

        String title = "Welcome to first PDF creation by Shashikant";
        String content = "Data hi data ";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Document document = new Document();

        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
        Paragraph titlePara = new Paragraph(title,titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        Font paraFont = FontFactory.getFont(FontFactory.COURIER_BOLD,15);
        Paragraph contentPara = new Paragraph(content,paraFont);
        contentPara.setAlignment(Element.ALIGN_CENTER);
        contentPara.add(new Chunk("Wow this is the chunk in this PARAGRAPH"));
        document.add(contentPara);

        document.close();

        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());





    }
}
