package utils.Steps;


import pages.*;


public class LoginSteps {
    public void IrParaLoginPage()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarBtnLoginPage();
    }
    public String fazerLogin(String username, String password)
    {
        new LoginPage().preencherNome(username);
        new LoginPage().preencherSenha(password);
        new LoginPage().clicarBtnLogin();
        return new LoginPage().getMessageText();
    }
}