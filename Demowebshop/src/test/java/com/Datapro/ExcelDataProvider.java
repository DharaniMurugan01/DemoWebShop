package com.Datapro;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class ExcelDataProvider {
    @DataProvider(name = "exceldata")
    public Object[][] excelDP() throws IOException {
        String loc = "C:\\Users\\ADMIN\\eclipse-workspace\\Demowebshop\\src\\test\\resources\\Book1.xlsx";
        return getData(loc, "Sheet1");
    }
    public String[][] getData(String file, String sheet) throws IOException {
        String[][] data = null;
        try (FileInputStream fis=new FileInputStream(file);
             XSSFWorkbook wrkBk=new XSSFWorkbook(fis)) {
            XSSFSheet sht=wrkBk.getSheet(sheet);
            int r=sht.getPhysicalNumberOfRows();
            int c=sht.getRow(0).getLastCellNum();
            data=new String[r][c];
            DataFormatter formatter=new DataFormatter();
            for (int i=0;i<r; i++) {
                XSSFRow row=sht.getRow(i);
                if (row !=null) {
                    for (int j=0; j < c; j++) {
                        Cell cell=row.getCell(j);
                        data[i][j]=(cell==null) ? "" :formatter.formatCellValue(cell);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
