package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsCameraPage extends BasePage {
    @iOSFindBy(xpath= "//android.widget.TextView[@text='Camera']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Camera']")
    private MobileElement lblTitulo;

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }
}
