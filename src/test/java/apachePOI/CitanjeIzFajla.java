package apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CitanjeIzFajla {
    public static void main(String[] args) throws IOException {

        File file = new File("data/podaci.xlsx"); //pronalazi fajl
        FileInputStream fis = new FileInputStream(file); //ucitava fajl

        XSSFWorkbook wb = new XSSFWorkbook(fis); //pronalazi workbook
        XSSFSheet sheet1 = wb.getSheet("Zadatak1"); //pronalazi sheet

        int a = sheet1.getLastRowNum();

        //System.out.println(a);

        XSSFRow prviRed = sheet1.getRow(0);
        XSSFRow treciRed = sheet1.getRow(2);
        XSSFCell treciRedPrvaCelija = treciRed.getCell(0);

        //System.out.println(treciRedPrvaCelija);

        for (int i = 0 ; i<a ; i++){  //ako cemo bez zaglavlja, odnosno bez prvog reda onda stavljamo int i = 1 ...
            XSSFRow redUPetlji = sheet1.getRow(i);
            XSSFCell ime = redUPetlji.getCell(0);
            XSSFCell prezime = redUPetlji.getCell(1);
            XSSFCell email = redUPetlji.getCell(2);

            System.out.print(ime.getStringCellValue() + ", ");
            System.out.print(prezime.getStringCellValue() + ", ");
            System.out.println(email.getStringCellValue());
        }

        fis.close();
        wb.close();

    }
}
