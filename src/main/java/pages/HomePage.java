package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends BasePage {
    //@AndroidFindBy(accessibility = "ReferenceApp")
    @iOSFindBy(xpath= "//XCUIElementTypeButton[@name='More']")
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    private MobileElement btnMenu;

    public void clicarBtnMenu()
    {
        clicar(btnMenu);
    }
}
