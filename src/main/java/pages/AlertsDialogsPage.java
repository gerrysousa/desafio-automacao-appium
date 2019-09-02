package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AlertsDialogsPage extends BasePage {
    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_toast_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_toast_button")
    private MobileElement btnToast;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_alert_button")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_alert_button")
    private MobileElement btnAlert;

    @iOSFindBy(id = "android:id/message")
    @AndroidFindBy(id = "android:id/message")
    private MobileElement lblMensagemAlerta;

    @iOSFindBy(id = "android:id/button1")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnAlertaOK;


    public void clicarBtnToast()
    {
        clicar(btnToast);
    }

    public void clicarBtnAlert()
    {
        clicar(btnAlert);
    }

    public void clicarBtnAlertaOK()
    {
        clicar(btnAlertaOK);
    }

    public String obterMensagemDoAlerta()
    {
        String texto = obterTexto(lblMensagemAlerta);
        return texto;
    }
}
