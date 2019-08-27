package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.InputControlsSteps;


public class InputControlsTests extends BaseTests {

    InputControlsSteps inputControlsSteps;
    InputControlsDatePickerPage inputControlsDatePickerPage;
    InputControlsTextFieldPage inputControlsTextFieldPage;
    InputControlsCheckboxPage inputControlsCheckboxPage;
    InputControlsRadioButtonsPage inputControlsRadioButtonsPage;
    InputControlsToggleButtonPage inputControlsToggleButtonPage;
    InputControlsSpinnerPage inputControlsSpinnerPage;
    InputControlsPushToRefreshPage inputControlsPushToRefreshPage;
    InputControlsSubmitButtonPage inputControlsSubmitButtonPage;

    @Test(priority = 1, description = "Teste para manipular campo Text Tield")
    public void Test_ManipularCampoTextField() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsTextFieldPage = new  InputControlsTextFieldPage();

        String texto = "Testando campo text field.";
        inputControlsSteps.AcessarInputControlsTextField();
        inputControlsTextFieldPage.preencherCampoTexto(texto);

        Assert.assertEquals(texto, inputControlsTextFieldPage.obterTextoDoElementoCampoTexto());
    }

    @Test(priority = 1, description = "Teste para manipular campo Checkbox")
    public void Test_ManipularCampoCheckBox() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsCheckboxPage = new  InputControlsCheckboxPage();

        inputControlsSteps.AcessarInputControlsCheckbox();
        String statusInicial = inputControlsCheckboxPage.obterStatusCheckbox();
        Assert.assertEquals(statusInicial, "Unchecked");

        inputControlsCheckboxPage.clicarCkbCheckbox();
        String statusFinal = inputControlsCheckboxPage.obterStatusCheckbox();
        Assert.assertEquals(statusFinal, "Checked");
    }

    @Test(priority = 1, description = "Teste para manipular campo Radio buttons")
    public void Test_ManipularCampoRadioButtons() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsRadioButtonsPage = new  InputControlsRadioButtonsPage();

        inputControlsSteps.AcessarInputControlsRadioButtons();
        String radioMarcadoInicial = inputControlsRadioButtonsPage.obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoInicial, "Amazon");

        inputControlsRadioButtonsPage.clicarRdbService();
        String radioMarcadoFinal = inputControlsRadioButtonsPage.obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoFinal, "Services");
    }

    @Test(priority = 1, description = "Teste para manipular campo Toggle buttons")
    public void Test_ManipularCampoToggleButtons() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsToggleButtonPage = new  InputControlsToggleButtonPage();

        inputControlsSteps.AcessarInputControlsToggleButton();
        String toggleInicial = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleInicial, "OFF");

        inputControlsToggleButtonPage.clicarBtnSwitch();
        String toggleFinal = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleFinal, "ON");
    }

    @Test(priority = 1, description = "Teste para manipular campo Spinner")
    public void Test_ManipularCampoSpinner() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSpinnerPage = new  InputControlsSpinnerPage();

        inputControlsSteps.AcessarInputControlsSpinner();
        String opcaoInicialSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoInicialSelecionada, "Selected: option 1");

        inputControlsSpinnerPage.selecionarOpcaoGenerica("option 3");
        String opcaoFinalSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoFinalSelecionada, "Selected: option 3");
    }

    @Test(priority = 1, description = "Teste para manipular campo Pull to Resfresh")
    public void Test_ManipularCampoPullToRefresh() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsPushToRefreshPage = new  InputControlsPushToRefreshPage();

        inputControlsSteps.AcessarInputControlsPullToRefresh();
        String textoInicial = inputControlsPushToRefreshPage.obterMensagemExibida();
        Assert.assertEquals(textoInicial, "Pull to refresh time");

        inputControlsPushToRefreshPage.scrollDown();//.scroll(0.3, 0.8);
        String textoFinal = inputControlsPushToRefreshPage.obterMensagemExibida();
        Assert.assertTrue(textoFinal.contains(":"));
    }

    @Test(priority = 1, description = "Teste para manipular campo Botão Submit")
    public void Test_ManipularCampoBotaoSubmit() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSubmitButtonPage = new  InputControlsSubmitButtonPage();

        inputControlsSteps.AcessarInputControlsSubmitButton();
        inputControlsSubmitButtonPage.clicarBtnSubmit();
        inputControlsSubmitButtonPage.tirarScreenShotDaTela();
        //String textoFinal = new InputControlsSubmitButtonPage().obterMensagemExibida();
        //Assert.assertTrue(textoFinal.contains("Submitted"));
    }

}
