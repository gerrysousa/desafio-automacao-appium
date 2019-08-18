package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsCheckboxPage extends BasePage {

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_checkbox")
    private MobileElement ckbCheckbox;

    @iOSFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_checkbox_status")
    private MobileElement lblStatusCheckbox;

    public void clicarCkbCheckbox()
    {
        clicar(ckbCheckbox);
    }

    public String obterStatusCheckbox() {
        String aux = obterTexto(lblStatusCheckbox);
        return aux;
    }
}
