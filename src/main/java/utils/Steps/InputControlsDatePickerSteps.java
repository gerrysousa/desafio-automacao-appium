package utils.Steps;

import base.BasePage;
import pages.*;

public class InputControlsDatePickerSteps extends BasePage {

    InputControlsDatePickerPage inputControlsDatePickerPage;

    public void SelecionarNovaData(String dataEscolhida) {
//        String mes="05";
//        String dia="21";
//        String ano="1990";
        String [] dateParts = dataEscolhida.split("/");
        String dia = dateParts[0];
        String mes = dateParts[1];
        String ano = dateParts[2];


        escolherAno(ano);
        escolherMes(mes);
        escolherDia(dia);
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
}
