package utils.Steps;

import base.BasePage;
import pages.*;

public class InputControlsTimePickerSteps extends BasePage {
    InputControlsTimePickerPage inputControlsTimePickerPage;

    public void SelecionarNovaHora(String hora, String minutos, String AmPm) {
        inputControlsTimePickerPage = new InputControlsTimePickerPage();

        inputControlsTimePickerPage.clicarBtnTeclado();
        inputControlsTimePickerPage.escreverHora(hora);
        inputControlsTimePickerPage.escreverMinutos(minutos);
        inputControlsTimePickerPage.clicarBtnRelogio();

        if (AmPm.equals("AM"))
        {
            inputControlsTimePickerPage.clicarLblAM();
        }
        else
        {
            inputControlsTimePickerPage.clicarLblPM();
        }
    }

    public String converterAmPmNovaHora(String hora, String minutos, String AmPm) {
        String horaNova;
        if (AmPm.equals("PM"))
        {
            int horaInt = Integer.parseInt(hora);

            if(horaInt==12){
                hora = "0";
            }
            else {
                horaInt = horaInt + 12;
                hora = Integer.toString(horaInt);
            }
            horaNova = hora+" : "+minutos;//12 : 30
        }
        else
        {
            horaNova = hora+" : "+minutos;//12 : 30
        }
        return horaNova;
    }
}
