package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    private MobileElement btnLoginPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Input Controls']")
    private MobileElement btnInputControls;

    public void clickBtnLoginPage()
    {
        clicar(btnLoginPage);
    }
    public void clickInputControls()
    {
        clicar(btnInputControls);
    }
}
