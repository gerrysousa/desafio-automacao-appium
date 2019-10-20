package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsSubmitButtonPage extends BasePage {
    @iOSFindBy(accessibility= "Submit")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_submit_button")
    private MobileElement btnSubmit;

    @iOSFindBy(className= "android.widget.RelativeLayout")
    @AndroidFindBy(className= "android.widget.RelativeLayout")
    private MobileElement lblMensagem;


    public void clicarBtnSubmit() {
        cliqueLongo(btnSubmit);
    }

    public String obterMensagemExibida() {
        String texto = obterTexto(lblMensagem);
        return texto;
    }
}
