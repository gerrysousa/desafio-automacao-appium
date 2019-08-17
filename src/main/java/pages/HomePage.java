package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
    //@AndroidFindBy(accessibility = "ReferenceApp")
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    private MobileElement btnMenu;

    public void clickMenu()
    {
        click(btnMenu);
    }
}
