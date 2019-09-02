package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsPage extends BasePage {
    @iOSFindBy(xpath= "com.amazonaws.devicefarm.android.referenceapp:id/toolbar_title")
    @AndroidFindBy(xpath= "com.amazonaws.devicefarm.android.referenceapp:id/toolbar_title")
    private MobileElement lblTitulo;

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }
}
