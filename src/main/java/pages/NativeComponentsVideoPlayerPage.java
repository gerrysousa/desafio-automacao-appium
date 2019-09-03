package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsVideoPlayerPage extends BasePage {
    @iOSFindBy(xpath= "//android.widget.TextView[@text='Video Player']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Video Player']")
    private MobileElement lblTitulo;

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }
}
