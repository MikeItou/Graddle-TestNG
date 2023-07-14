package ExcelManipulation;
public class VariableAssignation {
    private String browser, url, fullName, email, password, confirmPassword;
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public void arrayVariableAssignation(String[][] excelDataExtraction){

        for (int i = 0; i < excelDataExtraction.length ;) {
            for (int j = 0; j < excelDataExtraction[i].length ; j++) {
                switch (excelDataExtraction[i][j]){
                    case "Browser":
                        setBrowser(excelDataExtraction[i+1][j]);
                        break;
                    case "URL":
                        setUrl(excelDataExtraction[i+1][j]);
                        break;
                    case "FullName":
                        setFullName(excelDataExtraction[i+1][j]);
                        break;
                    case "Email":
                        setEmail(excelDataExtraction[i+1][j]);
                        break;
                    case "Password":
                        setPassword(excelDataExtraction[i+1][j]);
                        break;
                    case "ConfirmPassword":
                        setConfirmPassword(excelDataExtraction[i+1][j]);
                        break;
                }
            }
            break;
        }

    }
}

