package base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
    //ovo nam je potrebno sve da bi procitali jedan podatak
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    public excelReader(String filePath) throws IOException {
        file = new File(filePath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
    }
    // prima sheet name i broj reda i kolona
    public String getStringData(String sheetName, int rowNumber, int colNumber) {
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(colNumber);

        return cell.getStringCellValue();

    }
    public int getIntegergData(String sheetName, int rowNumber, int colNumber) {
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(colNumber);

        return (int)cell.getNumericCellValue();

    }

}
