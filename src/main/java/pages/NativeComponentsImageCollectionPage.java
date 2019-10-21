package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsImageCollectionPage extends BasePage {

    @iOSFindBy(xpath= "//XCUIElementTypeOther[@name='Image Gallery']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Image Collection']")
    private MobileElement lblTitulo;

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }
}
