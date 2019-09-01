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
    private MobileElement lblResultadoFinal;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement btnNextLevel;


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

    public String obterTextoLevelFinal() {
    String texto = obterTexto(lblResultadoFinal);
    return texto;
    }
}
