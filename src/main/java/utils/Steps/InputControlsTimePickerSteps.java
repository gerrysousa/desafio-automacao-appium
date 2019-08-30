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
}
