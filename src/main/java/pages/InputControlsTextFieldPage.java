package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsTextFieldPage extends BasePage {
    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_edit_text")
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
