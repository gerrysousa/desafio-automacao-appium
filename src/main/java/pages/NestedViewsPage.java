package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NestedViewsPage extends BasePage {
    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement btnUpNavigation;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    private MobileElement btnBackNavigation;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/up_navigation_content_text")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/up_navigation_content_text")
    private MobileElement lblResultadoFinalNext;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement btnNextLevel;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_next_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_next_button")
    private MobileElement btnBackNextLevel;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_counter")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_counter")
    private MobileElement lblResultadoFinalBack;

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
}
