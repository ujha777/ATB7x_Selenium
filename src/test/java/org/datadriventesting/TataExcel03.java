package org.datadriventesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TataExcel03 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("Gangesh");

        

        FileOutputStream outputStream = new FileOutputStream("SELLSPECIFIC.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }
}
