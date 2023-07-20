package testSuites;

import ExcelManipulation.ReadExcelFile;
import ExcelManipulation.VariableAssignation;
import org.testng.annotations.Test;

public class HeaderSuite extends BaseTest {
    @Test
    public void checkCustomMenu() throws Exception{
        //String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/Navigate Data.xlsx";
        String excelSheetName = "Sheet1";
        String testCaseName;
        VariableAssignation variableAssignation = new VariableAssignation();
        //String [] excelData= new String[]{"Apple","Banana","Orange"};
        ReadExcelFile readExcelFile = new ReadExcelFile();
        //WriteExcelFile writeExcelFile = new WriteExcelFile();
        String[][] arrayExcelExtracted;

        //readExcelFile.readExcel(excelFilePath,excelSheetName);

        int[][] rowColumExcelData = readExcelFile.getRowColumExcel(excelFilePath,excelSheetName);

        for (int i = 0; i < rowColumExcelData.length; i++) {
            testCaseName = String.format("Test Case Name%s",i+1);
            arrayExcelExtracted = readExcelFile.extractDataFromExcel(excelFilePath, excelSheetName, testCaseName);
            variableAssignation.arrayVariableAssignation(arrayExcelExtracted);

            setupWebPage(variableAssignation.getBrowser(), variableAssignation.getUrl());
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


       /*
        //writeExcelFile.writeInExcel(excelFilePath,excelSheetName,excelData,rowInUse);

        */
    }
}
