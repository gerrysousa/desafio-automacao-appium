package utils.Steps;


import pages.*;


public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homePage;
    private MenuPage menuPage;

    public LoginSteps(){
        homePage = new HomePage();
        menuPage = new MenuPage();
        loginPage = new LoginPage();
    }
    public void goToLoginPage()
    {
        homePage.clickMenu();
        menuPage.clickLoginPage();
    }
    public String login(String username, String password)
    {
        loginPage.usernameFill(username);
        loginPage.passwordFill(password);
        loginPage.clickLoginBtn();
        return loginPage.getMessageText();
    }
}