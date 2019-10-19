package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WebViewPage extends BasePage {

    @iOSFindBy(xpath= "//XCUIElementTypeStaticText[@name='Sign In']")
    @AndroidFindBy(xpath = "xxxxxxx")
    private MobileElement btnSignIn;

    @iOSFindBy(xpath= "//XCUIElementTypeStaticText[@name='Welcome']")
    @AndroidFindBy(xpath = "xxxxxxx")
    private MobileElement lblMensagemBemVindo;


    public void clicarBtnSignIn() {
        clicar(btnSignIn);
    }

    public String obterMensagemDeBemVindo() {
        String texto = obterTexto(lblMensagemBemVindo);
        return texto;
    }
}
