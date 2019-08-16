package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
    @AndroidFindBy(accessibility = "ReferenceApp")
    private MobileElement menu;

    public void clickMenu()
    {
        click(menu);
    }
}
