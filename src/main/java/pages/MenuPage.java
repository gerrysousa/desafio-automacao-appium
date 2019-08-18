package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    private MobileElement btnLoginPage;

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Input Controls']")
    private MobileElement btnInputControls;

    public void clicarBtnLoginPage()
    {
        clicar(btnLoginPage);
    }
    public void clicarInputControls()
    {
        clicar(btnInputControls);
    }
}
