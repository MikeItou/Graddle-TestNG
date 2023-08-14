package ExcelManipulation;

import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    public  String[][] extractDataFromExcel(String filePath, String sheetName, String testCaseName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row;

        //se cuenta desde cero para ver el total de columnas
        row = newSheet.getRow(0);
        int originalCellCount = row.getLastCellNum() - row.getFirstCellNum() - 1;
        String excelDataExtracted[][]  = new String[2][originalCellCount];
        String testCaseNameArray;
        int rowNumber = 0;

        //Busca la fila del caso a ocupar
        for (int i = 0; i <= newSheet.getLastRowNum(); i++) {

            row = newSheet.getRow(i);
            testCaseNameArray = row.getCell(0).getStringCellValue();

            if (testCaseNameArray.equals(testCaseName)){
                rowNumber = i;
                break;
            }
        }
        //Extraer la data con base en la fila obtenida del ciclo previo
        for (int i = 0; i <= 1; i++) {

            if (i == 0) row = newSheet.getRow(i);
            else row = newSheet.getRow(rowNumber);

            for (int j = 1; j <= originalCellCount; j++) {

                if (row.getCell(j) != null) excelDataExtracted[i][j-1] = row.getCell(j).getStringCellValue();
                else excelDataExtracted[i][j-1] = "";
            }
        }
        return excelDataExtracted;
    }

    public int[][] getRowColumExcel(String filePath, String sheetName) throws Exception{
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row;

        row = newSheet.getRow(0);
        int originalCellCount = row.getLastCellNum() - row.getFirstCellNum() - 1;
        int originalRowCount = newSheet.getLastRowNum();
        int rowAndColumExcel[][] = new int[originalRowCount][originalCellCount];

        //System.out.println("Fila: " + originalRowCount);
        //System.out.println("Columna: " + originalCellCount);
        return rowAndColumExcel;
    }
}
