package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsSpinnerPage extends BasePage {

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_spinner")
    private MobileElement btnSelecao;

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_spinner_message")
    private MobileElement lblOpcaoSelecionada;

    public void clicarBtnSelecao()
    {
        clicar(btnSelecao);
    }

    public String obterOpcaoSelecionada() {
        String aux = obterTexto(lblOpcaoSelecionada);
        return aux;
    }

    public void selecionarOpcaoGenerica(String opcaoEscolhida) {
        clicarBtnSelecao();
        clicarPorTexto(opcaoEscolhida);
    }
}

