package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsSubmitButtonPage extends BasePage {
    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_submit_button")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_submit_button")
    private MobileElement btnSubmit;

    @iOSFindBy(className= "android.widget.RelativeLayout")
    @AndroidFindBy(className= "android.widget.RelativeLayout")
    private MobileElement lblMensagem;


    public void clicarBtnSubmit() {
        clicar(btnSubmit);
    }

    public String obterMensagemExibida() {
        String texto = obterTexto(lblMensagem);
        return texto;
    }
}
