package com.zzp.pratise.Useful;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class GeneratePDF {

    //        10. 使用iText JAR生成PDF

    public static void main(String[] args) {
        try {
            OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));

            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("Hello Kiran"));
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
