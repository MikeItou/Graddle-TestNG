package testSuites;

import ExcelManipulation.ReadExcelFile;
import ExcelManipulation.VariableAssignation;
import org.testng.annotations.Test;

public class RegisterSuite extends BaseTest{
    @Test
    public void makeNewUser()throws Exception{
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelSheetName = "Sheet1";
        String testCaseName;
        // crear un ciclo para que lea todas las filas de los datos a usar
        ReadExcelFile readExcelFile = new ReadExcelFile();
        VariableAssignation variableAssignation = new VariableAssignation();
        String[][] arrayExcelExtracted;
        int[][] rowColumExcelData = readExcelFile.getRowColumExcel(excelFilePath,excelSheetName);

        for (int i = 0; i < rowColumExcelData.length ; i++) {
            testCaseName = String.format("Test Case Name%s",i+1);
            arrayExcelExtracted = readExcelFile.extractDataFromExcel(excelFilePath,excelSheetName,testCaseName);
            variableAssignation.arrayVariableAssignation(arrayExcelExtracted);

            setupWebPage(variableAssignation.getBrowser(),variableAssignation.getUrl());
            headerPage.clickRegisterButton();
            registerPage.fillNameFiled(variableAssignation.getFullName());
            registerPage.fillEmailField(variableAssignation.getEmail());
            registerPage.fillPasswordField(variableAssignation.getPassword());
            registerPage.fillConfirmPasswordField(variableAssignation.getConfirmPassword());
        }

    }
}
