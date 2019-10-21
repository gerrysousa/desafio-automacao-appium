package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsPushToRefreshPage extends BasePage {
    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_refresh_display")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_refresh_display")
    private MobileElement lblMensagem;


    public String obterMensagemExibida()
    {
        String mensagem = obterTexto(lblMensagem);
        return mensagem;
    }
}
