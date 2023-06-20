package ExcelManipulation;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    public void readExcel (String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row;
        row = newSheet.getRow(0);
        int originalCellCount = row.getLastCellNum() - row.getFirstCellNum();

        for (int i = 1; i < originalCellCount; i++) {
            row = newSheet.getRow(i);

            for (int j = 0; j < originalCellCount; j++) {
                if (row.getCell(j) == null) {
                   //row.createCell(j, CellType.BLANK);
                    System.out.print("VV" +j+ "||");
                }
                else{
                    System.out.print(row.getCell(j).getStringCellValue() + "||");
                }
            }
            System.out.println(".");
        }
    }

    public String getExcelCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException{
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        if (cell != null) return cell.getStringCellValue();
        else return " ";
    }
}
