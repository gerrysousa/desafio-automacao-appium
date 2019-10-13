package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends BasePage
{
    @iOSFindBy(xpath= "//XCUIElementTypeTextField[@value='Username']")//XCUIElementTypeButton[@name='More']
    @AndroidFindBy(accessibility= "Username Input Field")
    private MobileElement usernameField;

    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Password']")
    @AndroidFindBy(accessibility = "Password Input Field")
    private MobileElement passwordField;

    @iOSFindBy(accessibility = "Login")
    @AndroidFindBy(accessibility = "Login Button")
    private MobileElement loginBtn;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
    @AndroidFindBy(accessibility = "Alt Message")
    private MobileElement message;

    public void preencherNome(String username)
    {
        escrever(usernameField,username);
    }
    public void preencherSenha(String password)
    {
        escrever(passwordField,password);
    }
    public void clicarBtnLogin()
    {
        clicar(loginBtn);
    }
    public String getMessageText()
    {
        return message.getText();
    }
}
