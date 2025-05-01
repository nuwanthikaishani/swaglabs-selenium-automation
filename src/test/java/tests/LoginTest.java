package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @DataProvider(name =  "loginData")
    public Object[][] loginCredentials(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };
    }


    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

    }
}
