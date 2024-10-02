package org.datadriventesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TaskExcelReadData {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream(new File("CTD.xlsx"));
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowiterataor = sheet.iterator();
        while (rowiterataor.hasNext()){
           Row row= rowiterataor.next();
            Iterator<Cell> celliterator = row.cellIterator();
            while (celliterator.hasNext()){
                Cell cell = celliterator.next();
                if (cell.getCellType()== CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }
                if (cell.getCellType()== CellType.STRING){
                    System.out.println(cell.getStringCellValue());
                }
            }

        }


    }
}
