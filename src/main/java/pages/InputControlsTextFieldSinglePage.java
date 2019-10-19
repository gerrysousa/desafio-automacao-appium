package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsTextFieldSinglePage extends BasePage {
    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement txtCampoTexto;

    public void preencherCampoTexto(String texto)
    {
        escrever(txtCampoTexto,texto);
    }

    public String obterTextoDoElementoCampoTexto() {
        String aux = obterTexto(txtCampoTexto);
        return aux;
    }
}
