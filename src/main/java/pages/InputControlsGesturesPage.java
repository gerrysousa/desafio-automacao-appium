package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsGesturesPage extends BasePage {
    //Mapeamento
    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_gesture_action_pad")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_gesture_action_pad")
    private MobileElement padDeGestos;

    @iOSFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_gesture_content")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/input_gesture_content")
    private MobileElement lblDisplayGestosExecutados;


    //Fim Mapeamento
    //Acoes

    public void clicarPadGestos()
    {
        clicar(padDeGestos);
    }
    public String obterTextoLblDisplayGestosExecutados()
    {
        String texto = obterTexto(lblDisplayGestosExecutados);
        return texto;
    }
}
