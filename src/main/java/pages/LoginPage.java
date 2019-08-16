package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends BasePage
{
    @iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(accessibility= "Username Input Field")
    private MobileElement usernameField;
    @iOSFindBy(accessibility = "Password Input Field")
    @AndroidFindBy(accessibility = "Password Input Field")
    private MobileElement passwordField;
    @iOSFindBy(accessibility = "Login Button")
    @AndroidFindBy(accessibility = "Login Button")
    private MobileElement loginBtn;
    @iOSFindBy(accessibility = "Alt Message")
    @AndroidFindBy(accessibility = "Alt Message")
    private MobileElement message;

    public void usernameFill(String username)
    {
        sendKeys(usernameField,username);
    }
    public void passwordFill(String password)
    {
        sendKeys(passwordField,password);
    }
    public void clickLoginBtn()
    {
        click(loginBtn);
    }
    public String getMessageText()
    {
        return message.getText();
    }
}
