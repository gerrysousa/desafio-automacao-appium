package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Steps.LoginSteps;

public class LoginTests extends BaseTests {
    LoginSteps loginFlow;

    @Test(priority = 1, description = "teste de login valido")
    public void loginTest() {
        String username = "admin";
        String password = "password";

        loginFlow = new LoginSteps();
        loginFlow.goToLoginPage();
        String message = loginFlow.login(username,password);

        Assert.assertEquals("You are logged on as admin",message);
    }
    @Test (priority = 1, description = "teste de login invalido")
    public void loginInvalidTest() {
        String username = "teste123";
        String password = "teste123";

        loginFlow = new LoginSteps();
        loginFlow.goToLoginPage();
        String message = loginFlow.login(username,password);

        Assert.assertEquals("You gave me the wrong username and password",message);
    }
}
