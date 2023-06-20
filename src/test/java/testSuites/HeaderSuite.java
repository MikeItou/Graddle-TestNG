package testSuites;

import ExcelManipulation.ReadExcelFile;
import ExcelManipulation.WriteExcelFile;
import org.testng.annotations.Test;

public class HeaderSuite extends BaseTest {

    @Test
    //@Parameters({"browser","url"})
    public void checkCustomMenu() throws Exception{
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/Browser Data.xlsx";
        //String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelSheetName = "Sheet1";
        String [] excelData= new String[]{"Apple","Banana","Orange"};
        ReadExcelFile readExcelFile = new ReadExcelFile();
        WriteExcelFile writeExcelFile = new WriteExcelFile();
        int rowInUse=1;

        //readExcelFile.readExcel(excelFilePath,excelSheetName);
        setupWebPage(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,0),readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,1));
        writeExcelFile.writeInExcel(excelFilePath,excelSheetName,excelData,rowInUse);
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
