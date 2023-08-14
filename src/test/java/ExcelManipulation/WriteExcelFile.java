package ExcelManipulation;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {
    public void writeInExcel(String filepath, String sheetName, String[] dataToWrite, int columNumberStoreData) throws IOException {
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row;
        row = newSheet.getRow(0);
        int originalCellCount = row.getLastCellNum() - row.getFirstCellNum();
        int newCellCount = originalCellCount + 2 + dataToWrite.length;
        row = newSheet.getRow(columNumberStoreData);

        for (int j = 0; j < newCellCount; j++) {
            if (j <= originalCellCount) {
                if (row.getCell(j) == null) {
                    row.createCell(j, CellType.BLANK);
                }
            } else {
                for (; j < newCellCount; j++) {
                    if (j <= originalCellCount + 1) {
                        row.createCell(j, CellType.BLANK);
                    } else {
                        for (String s : dataToWrite) {
                            XSSFCell newCell = row.createCell(j);
                            newCell.setCellValue(s);
                            j++;
                        }
                    }
                }
            }
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();
    }

    public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell firstCell = row.getCell(cellNumber - 1);

        System.out.println("first cell Value is:"+ firstCell.getStringCellValue());

        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);

        System.out.println("next Cell value: " + nextCell.getStringCellValue());
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();
    }
}
