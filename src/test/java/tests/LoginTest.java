package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @DataProvider(name =  "loginData")
    public Object[][] loginCredentials(){
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true}
        };
    }


    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expectedSuccess){
        test = extent.createTest("Login Test with user: " +username);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

//        test.info("Login attempted with user: " +username);
//
//        test.pass("Login test executed successfully");

        boolean actualSuccess = loginPage.isLoginSuccessful();
        test.info("Expected login success: " +expectedSuccess);
        test.info("Actual login success: " +actualSuccess);

        try {

            Assert.assertEquals(actualSuccess, expectedSuccess);
            test.pass("Login result matched expected outcome.");

        }catch (AssertionError e){
            test.fail("Login result did not match expected. " + e.getMessage());
            throw e;

        }



    }
}
