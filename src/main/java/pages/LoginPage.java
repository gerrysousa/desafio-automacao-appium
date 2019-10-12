package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends BasePage
{
    @iOSFindBy(xpath= "//XCUIElementTypeApplication[@name='AWSDeviceFarmiOSReferenceApp']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(accessibility= "Username Input Field")
    private MobileElement usernameField;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"AWSDeviceFarmiOSReferenceApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField\n")
    @AndroidFindBy(accessibility = "Password Input Field")
    private MobileElement passwordField;

    @iOSFindBy(accessibility = "Login")
    @AndroidFindBy(accessibility = "Login Button")
    private MobileElement loginBtn;

    @iOSFindBy(accessibility = "Alt Message")
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
