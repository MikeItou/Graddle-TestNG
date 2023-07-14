package testSuites;

import ExcelManipulation.ReadExcelFile;
import ExcelManipulation.VariableAssignation;
import org.testng.annotations.Test;

public class RegisterSuite extends BaseTest{
    @Test
    public void makeNewUser()throws Exception{
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelSheetName = "Sheet1";
        String testCaseName = "Test Case Name5";
        ReadExcelFile readExcelFile = new ReadExcelFile();
        VariableAssignation variableAssignation = new VariableAssignation();
        String[][] arrayExcelExtracted = readExcelFile.extractDataFromExcel(excelFilePath,excelSheetName,testCaseName);
        //int rowInUse=1;

        variableAssignation.arrayVariableAssignation(arrayExcelExtracted);
        setupWebPage(variableAssignation.getBrowser(),variableAssignation.getUrl());
        headerPage.clickRegisterButton();
        registerPage.fillNameFiled(variableAssignation.getFullName());
        registerPage.fillEmailField(variableAssignation.getEmail());
        registerPage.fillPasswordField(variableAssignation.getPassword());
        registerPage.fillConfirmPasswordField(variableAssignation.getConfirmPassword());
    }
}
