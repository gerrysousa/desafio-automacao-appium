package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class FixturesPage extends BasePage {
    @iOSFindBy(xpath= "//android.widget.TextView[@text='Fixtures]")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Fixtures']")
    private MobileElement lblTitulo;

    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/nfc")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/nfc")
    private MobileElement lblStatusNFC;

    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/gps")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/gps")
    private MobileElement lblStatusGPS;

   // @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/gps")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/bluetooth")
    private MobileElement lblStatusBluetooth;

    // @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/gps")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/wifi")
    private MobileElement lblStatusWiFi;

    //Ações
    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }

    public String obterStatusNFC() {
        String texto = obterTexto(lblStatusNFC);
        return texto;
    }

    public String obterStatusGPS() {
        String texto = obterTexto(lblStatusGPS);
        return texto;
    }

    public String obterStatusBluetooth() {
        String texto = obterTexto(lblStatusBluetooth);
        return texto;
    }

    public String obterStatusWiFi() {
        String texto = obterTexto(lblStatusWiFi);
        return texto;
    }
}
