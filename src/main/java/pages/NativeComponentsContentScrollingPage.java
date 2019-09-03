package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsContentScrollingPage extends BasePage {
    @iOSFindBy(xpath= "//android.widget.TextView[@text='Content Scrolling']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Scrolling']")
    private MobileElement lblTitulo;

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }
}
