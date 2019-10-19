package tests.androidTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Steps.LoginSteps;

public class __ExemploTests extends BaseTests {

    @Test(priority = 1, description = "teste de login valido")
    public void Test_LoginSucesso() {
        String username = "admin";
        String password = "password";

        new LoginSteps().IrParaLoginPage();
        String message = new LoginSteps().fazerLogin(username,password);

        Assert.assertEquals("You are logged on as admin",message);
    }
    @Test (priority = 1, description = "teste de login invalido")
    public void Test_LoginInvalido() {
        String username = "teste123";
        String password = "teste123";

        new LoginSteps().IrParaLoginPage();
        String message = new LoginSteps().fazerLogin(username,password);

        Assert.assertEquals("You gave me the wrong username and password",message);
    }
}
