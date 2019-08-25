package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.InputControlsSteps;


public class InputControlsTests extends BaseTests {

    @Test(priority = 1, description = "Teste para manipular campo Text Tield")
    public void Test_ManipularCampoTextField() {
        String texto = "Testando campo text field.";
        new InputControlsSteps().AcessarInputControlsTextField();
        new InputControlsTextFieldPage().preencherCampoTexto(texto);

        Assert.assertEquals(texto, new InputControlsTextFieldPage().obterTextoDoElementoCampoTexto());
    }

    @Test(priority = 1, description = "Teste para manipular campo Checkbox")
    public void Test_ManipularCampoCheckBox() {
        new InputControlsSteps().AcessarInputControlsCheckbox();
        String statusInicial = new InputControlsCheckboxPage().obterStatusCheckbox();
        Assert.assertEquals(statusInicial, "Unchecked");

        new InputControlsCheckboxPage().clicarCkbCheckbox();
        String statusFinal = new InputControlsCheckboxPage().obterStatusCheckbox();
        Assert.assertEquals(statusFinal, "Checked");
    }

    @Test(priority = 1, description = "Teste para manipular campo Radio buttons")
    public void Test_ManipularCampoRadioButtons() {
        new InputControlsSteps().AcessarInputControlsRadioButtons();
        String radioMarcadoInicial = new InputControlsRadioButtonsPage().obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoInicial, "Amazon");

        new InputControlsRadioButtonsPage().clicarRdbService();
        String radioMarcadoFinal = new InputControlsRadioButtonsPage().obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoFinal, "Services");
    }

    @Test(priority = 1, description = "Teste para manipular campo Toggle buttons")
    public void Test_ManipularCampoToggleButtons() {
        new InputControlsSteps().AcessarInputControlsToggleButton();
        String toggleInicial = new InputControlsToggleButtonPage().obterStatusSwitch();
        Assert.assertEquals(toggleInicial, "OFF");

        new InputControlsToggleButtonPage().clicarBtnSwitch();
        String toggleFinal = new InputControlsToggleButtonPage().obterStatusSwitch();
        Assert.assertEquals(toggleFinal, "ON");
    }

    @Test(priority = 1, description = "Teste para manipular campo Spinner")
    public void Test_ManipularCampoSpinner() {
        new InputControlsSteps().AcessarInputControlsSpinner();
        String opcaoInicialSelecionada = new InputControlsSpinnerPage().obterOpcaoSelecionada();
        Assert.assertEquals(opcaoInicialSelecionada, "Selected: option 1");

        new InputControlsSpinnerPage().selecionarOpcaoGenerica("option 3");
        String opcaoFinalSelecionada = new InputControlsSpinnerPage().obterOpcaoSelecionada();
        Assert.assertEquals(opcaoFinalSelecionada, "Selected: option 3");
    }

    @Test(priority = 1, description = "Teste para manipular campo Pull to Resfresh")
    public void Test_ManipularCampoPullToRefresh() {
        new InputControlsSteps().AcessarInputControlsPullToRefresh();
        String textoInicial = new InputControlsPushToRefreshPage().obterMensagemExibida();
        Assert.assertEquals(textoInicial, "Pull to refresh time");

        new InputControlsPushToRefreshPage().scrollDown();//.scroll(0.3, 0.8);
        String textoFinal = new InputControlsPushToRefreshPage().obterMensagemExibida();
        Assert.assertTrue(textoFinal.contains(":"));
    }

    @Test(priority = 1, description = "Teste para manipular campo Botão Submit")
    public void Test_ManipularCampoBotaoSubmit() {
        new InputControlsSteps().AcessarInputControlsSubmitButton();
        new InputControlsSubmitButtonPage().clicarBtnSubmit();

        //new InputControlsSubmitButtonPage().TirarScreenShot();
        //String textoFinal = new InputControlsSubmitButtonPage().obterMensagemExibida();
        //Assert.assertTrue(textoFinal.contains("Submitted"));
    }

}
