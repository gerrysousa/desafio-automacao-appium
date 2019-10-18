package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HttpPage extends BasePage {

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name='navigation bar']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_edit_text")
    private MobileElement txtCampoURL;

    @iOSFindBy(accessibility = "Go")
    @AndroidFindBy(id = "xxxxxxxx")
    private MobileElement btnGo;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Faulty URL Entered']")
    @AndroidFindBy(id = "xxxxxxxx")
    private MobileElement lblAlerta;



    public void preencherCampoTexto(String texto)
    {
        escrever(txtCampoURL,texto);
    }

    public void clicarBtnGo()
    {
        clicar(btnGo);
    }

    public String obterTextoTituloDoAlerta() {
        String aux = obterTexto(lblAlerta);
        return aux;
    }

    public boolean verificarSeBotaoVoltarExiste() {
        boolean existe = verificarSeExisteTextoNaPagina("Input a website");
        return existe;
    }
}
