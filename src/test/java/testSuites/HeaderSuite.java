package testSuites;

import ExcelManipulation.ReadExcelFile;
import ExcelManipulation.VariableAssignation;
import org.testng.annotations.Test;

public class HeaderSuite extends BaseTest {
    @Test
    public void checkCustomMenu() throws Exception{
        //String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/Browser Data.xlsx";
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelSheetName = "Sheet1";
        String testCaseName = "Test Case Name1";
        VariableAssignation variableAssignation = new VariableAssignation();
        //String [] excelData= new String[]{"Apple","Banana","Orange"};
        ReadExcelFile readExcelFile = new ReadExcelFile();
        //WriteExcelFile writeExcelFile = new WriteExcelFile();
        String[][] arrayExcelExtracted;

        //readExcelFile.readExcel(excelFilePath,excelSheetName);
        arrayExcelExtracted = readExcelFile.extractDataFromExcel(excelFilePath, excelSheetName, testCaseName);
        variableAssignation.arrayVariableAssignation(arrayExcelExtracted);

        setupWebPage(variableAssignation.getBrowser(), variableAssignation.getUrl());
        //writeExcelFile.writeInExcel(excelFilePath,excelSheetName,excelData,rowInUse);
        headerPage.clickCustomMenuButton();
        headerPage.clickMyLocationButton();
        myLocationPage.clickCloseCrossButton();
        headerPage.clickMyUnitsButton();
        headerPage.clickMyEventsButton();
        headerPage.clickMyWorldClockButton();
        headerPage.clickMyPrivacyButton();
        headerPage.clickPaidServiceButton();
        headerPage.clickSingInButton();
        signInPage.clickCloseCrossButton();
        headerPage.clickRegisterButton();
        registerPage.clickCloseCrossButton();
    }
}
