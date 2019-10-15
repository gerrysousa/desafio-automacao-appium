package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NestedViewsPage extends BasePage {
    @iOSFindBy(id= "xxxxxx")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement btnUpNavigation;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    private MobileElement btnBackNavigation;

    @iOSFindBy(accessibility = "This is the fourth view")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/up_navigation_content_text")
    private MobileElement lblResultadoFinalNext;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement btnNextLevel;

    @iOSFindBy(id = "xxxxxx")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_next_button")
    private MobileElement btnBackNextLevel;

    @iOSFindBy(accessibility = "This is the second view")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_counter")
    private MobileElement lblResultadoFinalBack;

    @iOSFindBy(accessibility = "This is the first view")
    private MobileElement lblFirstView;


    @iOSFindBy(accessibility = "This is the third view")
    private MobileElement  lblThirdView;

    public void clicarBtnUpNavigation()
    {
        clicar(btnUpNavigation);
    }

    public void clicarBtnBackNavigation()
    {
        clicar(btnBackNavigation);
    }

    public void clicarBtnNextLevels() {
        clicar(btnNextLevel);
    }

    public void clicarBtnBackNextLevel() {
        clicar(btnBackNextLevel);
    }

    public String obterTextoLevelFinalNext() {
    String texto = obterTexto(lblResultadoFinalNext);
    return texto;
    }

    public String obterTextoLevelFinalBack() {
        String texto = obterTexto(lblResultadoFinalBack);
        return texto;
    }

    public String obterTextoFirstView() {
        String texto = obterTexto(lblFirstView);
        return texto;
    }

    public String obterTextoThirdView() {
        String texto = obterTexto(lblThirdView);
        return texto;
    }
}
