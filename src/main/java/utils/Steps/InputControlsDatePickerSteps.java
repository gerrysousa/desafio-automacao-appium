package utils.Steps;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import pages.*;

public class InputControlsDatePickerSteps extends BasePage {


    @iOSFindBy(xpath= "//XCUIElementTypePickerWheel[1]")
    private MobileElement lblMes;

    @iOSFindBy(xpath= "//XCUIElementTypePickerWheel[2]")
    private MobileElement lblDia;

    @iOSFindBy(xpath= "//XCUIElementTypePickerWheel[3]")
    private MobileElement lblAno;


    InputControlsDatePickerPage inputControlsDatePickerPage;

    public void SelecionarNovaData(String dataEscolhida) {
        String [] dateParts = dataEscolhida.split("/");
        String dia = dateParts[0];
        String mes = dateParts[1];
        String ano = dateParts[2];

        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            // codigo para android
            escolherAno(ano);
            escolherMes(mes);
            escolherDia(dia);
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            //codigo para iOS
            escolherAnoIos(ano);
            escolherMesIos(mes);
            escolherDiaIos(dia);
        }


    }

    public void escolherAno(String ano) {
        inputControlsDatePickerPage = new InputControlsDatePickerPage();
        int i = 0;
        int anoInt = Integer.parseInt(ano.trim());

        inputControlsDatePickerPage.clicarLblAno();

        while (!verificarSeExisteTextoNaPagina(ano)&&i<10) {
            if((anoInt<1994))
            {
               scroll(0.5,0.8);
            }
            else
            {
                scroll(0.7,0.4);
            }
            i++;
        }
        clicarPorTexto(ano);
    }

    public void escolherMes(String mes) {
        inputControlsDatePickerPage = new InputControlsDatePickerPage();
        int i = 0;
        int mesInt = Integer.parseInt(mes.trim());

        String mesString[];
        mesString = new String[ 13 ];
        mesString[ 0 ] = null;
        mesString[ 1 ] = "January";
        mesString[ 2 ] = "February";
        mesString[ 3 ] = "March";
        mesString[ 4 ] = "April";
        mesString[ 5 ] = "May";
        mesString[ 6 ] = "June";
        mesString[ 7 ] = "July";
        mesString[ 8 ] = "August";
        mesString[ 9 ] = "September";
        mesString[ 10 ] = "October";
        mesString[ 11 ] = "November";
        mesString[ 12 ] = "December";

        while (!(verificarSeExisteTextoNaPagina(mesString[mesInt]))&&i<10) {
            if((mesInt>7))
            {
                inputControlsDatePickerPage.clicarBtnMesProximo();
            }
            else
            {
                inputControlsDatePickerPage.clicarBtnMesAnterior();
            }
            i++;
        }
        //clicarPorTexto(mes);
    }

    public void escolherDia(String dia) {
        inputControlsDatePickerPage = new InputControlsDatePickerPage();
        clicarPorTexto(dia);
    }

    public void escolherAnoIos(String ano) {
        inputControlsDatePickerPage = new InputControlsDatePickerPage();
        int i = 0;
        int anoInt = Integer.parseInt(ano.trim());

        while (!verificarSeExisteTextoNoElemento(lblAno, ano)&&i<40) {
            if((anoInt<2019))
            {
                scrollDirecao(280,280,280,314);
            }
            else
            {
                scrollDirecao(280,280,280,243);
            }
            i++;
        }
       //clicarPorTexto(ano);
    }

    public void escolherDiaIos(String dia) {
        int i=0;
        while (!verificarSeExisteTextoNoElemento(lblDia, dia)&&i<32) {
            scrollDirecao(205,280,205,314);
            i++;
        }
        //clicarPorTexto(dia);
    }

    public void escolherMesIos(String mes) {
        inputControlsDatePickerPage = new InputControlsDatePickerPage();
        int i = 0;
        int mesInt = Integer.parseInt(mes.trim());

        String mesString[];
        mesString = new String[ 13 ];
        mesString[ 0 ] = null;
        mesString[ 1 ] = "January";
        mesString[ 2 ] = "February";
        mesString[ 3 ] = "March";
        mesString[ 4 ] = "April";
        mesString[ 5 ] = "May";
        mesString[ 6 ] = "June";
        mesString[ 7 ] = "July";
        mesString[ 8 ] = "August";
        mesString[ 9 ] = "September";
        mesString[ 10 ] = "October";
        mesString[ 11 ] = "November";
        mesString[ 12 ] = "December";

        while (!(verificarSeExisteTextoNoElemento(lblMes, mesString[mesInt]))&&i<12) {
            scrollDirecao(90,280,90,314);
            i++;
        }
        //clicarPorTexto(mes);
    }
}
