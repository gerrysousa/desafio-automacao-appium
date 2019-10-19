package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsCampoInformacaoPage extends BasePage {

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeButton[1]")
    private MobileElement btnMaisInformacao;

    public void clicarBtnMaisInformacao() {
        clicar(btnMaisInformacao);
    }

    public String obterTextoBtnMaisInformacao() {
        String aux = obterTexto(btnMaisInformacao);
        return aux;
    }
}