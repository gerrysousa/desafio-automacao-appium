package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.commons.lang3.StringUtils;

import static base.DriverFactory.getDriver;

public class InputControlsTimePickerPage extends BasePage {
    //Mapeamento
    @iOSFindBy(id= "android:id/date_picker_header_year")
    @AndroidFindBy(id= "android:id/am_label")
    private MobileElement lblAM;

    @iOSFindBy(id= "android:id/am_label")
    @AndroidFindBy(id= "android:id/pm_label")
    private MobileElement lblPM;

    @iOSFindBy(id= "android:id/radial_picker")
    @AndroidFindBy(id= "android:id/radial_picker")
    private MobileElement gridRelogio;

    @iOSFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_time_display")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_time_display")
    private MobileElement lblHoraSelecionada;

    @iOSFindBy(id= "android:id/toggle_mode")
    @AndroidFindBy(id= "android:id/toggle_mode")
    private MobileElement btnTeclado;

    @iOSFindBy(id= "android:id/toggle_mode")
    @AndroidFindBy(id= "android:id/input_hour")
    private MobileElement txtHora;

    @iOSFindBy(id= "android:id/toggle_mode")
    @AndroidFindBy(id= "android:id/input_minute")
    private MobileElement txtMinutos;

    @iOSFindBy(id= "android:id/toggle_mode")
    @AndroidFindBy(id= "android:id/toggle_mode")
    private MobileElement btnRelogio;

    //Fim mapeamento
    //Ações
    public void clicarLblAM()
    {
        clicar(lblAM);
    }

    public void clicarLblPM()
    {
        clicar(lblPM);
    }

    public String obterHoraSelecionada() {
        String texto = obterTexto(lblHoraSelecionada);
        return texto;
    }

    public void clicarBtnTeclado(){
        clicar(btnTeclado);
    }

    public void escreverHora(String hora)
    {
        escrever(txtHora, hora);
    }

    public void escreverMinutos(String minutos)
    {
        escrever(txtMinutos, minutos);
    }

    public void clicarBtnRelogio(){
        clicar(btnRelogio);
    }
}
