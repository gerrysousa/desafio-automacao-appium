package utils.Steps;


import pages.*;


public class LoginSteps {
    private HomePage homePage;
    private MenuPage menuPage;
    private LoginPage loginPage;

    public void IrParaLoginPage()
    {
        homePage = new HomePage();
        menuPage = new MenuPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnLoginPage();
    }
    public String fazerLogin(String username, String password)
    {
        loginPage = new LoginPage();
        
        loginPage.preencherNome(username);
        loginPage.preencherSenha(password);
        loginPage.clicarBtnLogin();
        return loginPage.getMessageText();
    }
}