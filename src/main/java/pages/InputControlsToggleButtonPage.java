package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsToggleButtonPage extends BasePage {

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_switch")
    private MobileElement btnSwitch;

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_switch_display")
    private MobileElement lblStatusSwitch;

    public void clicarBtnSwitch()
    {
        clicar(btnSwitch);
    }

    public String obterStatusSwitch() {
        String aux = obterDescricaoDoElemento(lblStatusSwitch);
        return aux;
    }
}