package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Steps.LoginSteps;

public class LoginTests extends BaseTests {
  private LoginSteps loginSteps;

    @Test(priority = 1, description = "teste de login valido")
    public void Test_LoginSucesso() {
        loginSteps  = new LoginSteps();

        String username = "admin";
        String password = "password";
        String mensagemEsperada ="You are logged on as admin";

        loginSteps.IrParaLoginPage();
        String message = loginSteps.fazerLogin(username,password);

        Assert.assertEquals(message, mensagemEsperada);
    }
    @Test (priority = 1, description = "teste de login invalido")
    public void Test_LoginInvalido() {
        loginSteps  = new LoginSteps();

        String username = "teste123";
        String password = "teste123";
        String mensagemEsperada = "You gave me the wrong username and password";

        loginSteps.IrParaLoginPage();
        String message = loginSteps.fazerLogin(username,password);

        Assert.assertEquals(message,mensagemEsperada);
    }
}
