package apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CitanjeIzFajla2 {
    public static void main(String[] args) throws IOException {

        File file = new File("data/podaci.xlsx"); //pronalazi fajl
        FileInputStream fis = new FileInputStream(file); //ucitava fajl

        XSSFWorkbook wb = new XSSFWorkbook(fis); //pronalazi workbook
        XSSFSheet sheet2 = wb.getSheet("Sheet1"); //pronalazi sheet

        int a = sheet2.getLastRowNum();


        for (int i = 0 ; i<a ; i++){  //ako cemo bez zaglavlja, odnosno bez prvog reda onda stavljamo int i = 1 ...
            XSSFRow redUPetlji = sheet2.getRow(i);
            XSSFCell kolona1 = redUPetlji.getCell(0);
            XSSFCell kolona2 = redUPetlji.getCell(1);
            XSSFCell kolona3 = redUPetlji.getCell(2);
            XSSFCell kolona4 = redUPetlji.getCell(3);
            XSSFCell kolona5 = redUPetlji.getCell(4);

            System.out.print(kolona1.getStringCellValue() + ", ");
            System.out.print(kolona2.getStringCellValue() + ", ");
            System.out.print(kolona3.getStringCellValue() + ", ");
            System.out.print(kolona4.getStringCellValue() + ", ");
            System.out.println(kolona5.getStringCellValue());
        }

        fis.close();
        wb.close();

    }
}
