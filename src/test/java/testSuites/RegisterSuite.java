package testSuites;

import ExcelManipulation.ReadExcelFile;
import org.testng.annotations.Test;

public class RegisterSuite extends BaseTest{
    @Test
    public void makeNewUser()throws Exception{
        String excelFilePath = "C:/Users/MiguelTorres/Documents/SELENIUM PROJECTS/Gradle-Tutorial-IntelliJIDEA/data/New User.xlsx";
        String excelSheetName = "Sheet1";
        ReadExcelFile readExcelFile = new ReadExcelFile();
        int rowInUse=1;

        setupWebPage(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,0),readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,1));
        headerPage.clickRegisterButton();
        registerPage.fillNameFiled(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,2));
        registerPage.fillEmailField(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,3));
        registerPage.fillPasswordField(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,4));
        registerPage.fillConfirmPasswordField(readExcelFile.getExcelCellValue(excelFilePath,excelSheetName,rowInUse,5));
    }
}
