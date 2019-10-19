package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.commons.lang3.StringUtils;
import utils.DataUtils;

public class InputControlsDatePickerPage extends BasePage {
    //Mapeamento
    @iOSFindBy(id= "android:id/date_picker_header_year")
    @AndroidFindBy(id= "android:id/date_picker_header_year")
    private MobileElement lblAno;

    @iOSFindBy(id= "android:id/date_picker_header_date")
    @AndroidFindBy(id= "android:id/date_picker_header_date")
    private MobileElement lblDiaSelecionado;

    @iOSFindBy(id= "android:id/next")
    @AndroidFindBy(id= "android:id/next")
    private MobileElement btnMesProximo;

    @iOSFindBy(id= "android:id/prev")
    @AndroidFindBy(id= "android:id/prev")
    private MobileElement btnMesAnterior;

    @iOSFindBy(xpath= "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
    @AndroidFindBy(id= "com.amazonaws.devicefarm.android.referenceapp:id/input_date_display")
    private MobileElement lblDataCompletaSelecionada;

    @iOSFindBy(id= "android:id/month_view")
    @AndroidFindBy(id= "android:id/month_view")
    private MobileElement gridCalendario;



    //Fim mapeamento
    //Ações
    public void clicarLblAno()
    {
        clicar(lblAno);
    }

    public void clicarBtnMesProximo()
    {
        clicar(btnMesProximo);
    }

    public void clicarBtnMesAnterior()
    {
        clicar(btnMesAnterior);
    }

    public void clicarNoDiaDoCalendario(String dia)
    {
        clicarPorTexto(dia);
    }

    public String obterDataSelecionada() {
        String aux = obterTexto(lblDataCompletaSelecionada);
        aux= DataUtils.converterDataAndroid(aux);

        return aux;
    }

    public String obterDataSelecionadaIos() {
        String aux = obterTexto(lblDataCompletaSelecionada);//Oct 10, 2019
        aux= DataUtils.converterDataIos(aux);

        return aux;
    }


    //Fim Ações
}
