package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsContentOutOfViewPage extends BasePage {
    @iOSFindBy(xpath= "//android.widget.TextView[@text='Content Out of View']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Out of View']")
    private MobileElement lblTitulo;

    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/hidden_text")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/hidden_text")
    private MobileElement lblComponenteEscondido;

    //Ações
    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }

    public String obterTextoDoComponenteEscondido() {
        String texto = obterTexto(lblComponenteEscondido);
        return texto;
    }
}
