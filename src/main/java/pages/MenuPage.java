package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[8]")
    private MobileElement loginPageBtn;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[4]")
    private MobileElement inputControlsBtn;

    public void clickLoginPage()
    {
        click(loginPageBtn);
    }
    public void clickInputControls()
    {
        click(inputControlsBtn);
    }
}
