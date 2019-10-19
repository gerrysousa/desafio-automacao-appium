package tests.iOSTests;


import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.InputControlsSteps;


public class InputControlsTests extends BaseTests {

    InputControlsSteps inputControlsSteps;
    InputControlsTextFieldPage inputControlsTextFieldPage;
    InputControlsToggleButtonPage inputControlsToggleButtonPage;
    InputControlsSpinnerPage inputControlsSpinnerPage;
    InputControlsSubmitButtonPage inputControlsSubmitButtonPage;
    InputControlsCampoInformacaoPage inputControlsCampoInformacaoPage;
    InputControlsTextFieldSinglePage inputControlsTextFieldSinglePage;

    @Test(priority = 1, description = "Teste para manipular campo Text View")
    public void Test_ManipularCampoTextView() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsTextFieldPage = new  InputControlsTextFieldPage();

        String texto = "Testando campo text view.";
        String textoEsperado = "Testando campo text view.I am a textview";
        inputControlsSteps.AcessarInputControlsTextField();
        inputControlsTextFieldPage.preencherCampoTexto(texto);

        Assert.assertEquals(textoEsperado, inputControlsTextFieldPage.obterTextoDoElementoCampoTexto());
    }

    @Test(priority = 1, description = "Teste para manipular campo Toggle buttons")
    public void Test_ManipularCampoToggleButtons() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsToggleButtonPage = new  InputControlsToggleButtonPage();

        inputControlsSteps.AcessarInputControlsToggleButton();
        String toggleInicial = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleInicial, "0");

        inputControlsToggleButtonPage.clicarBtnSwitch();
        String toggleFinal = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleFinal, "1");
    }

    @Test(priority = 1, description = "Teste para manipular campo informacao")
    public void Test_ManipularCampoInformacao() {
       inputControlsSteps = new InputControlsSteps();
       inputControlsCampoInformacaoPage = new InputControlsCampoInformacaoPage();

       inputControlsSteps.AcessarInputControlsBotaoMaisInformacao();
       inputControlsCampoInformacaoPage.clicarBtnMaisInformacao();
       String statusFinal = inputControlsCampoInformacaoPage.obterTextoBtnMaisInformacao();
       Assert.assertEquals(statusFinal, "true");
    }

    @Test(priority = 1, description = "Teste para manipular campo Botão Submit")
    public void Test_ManipularCampoBotaoSubmit() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSubmitButtonPage = new  InputControlsSubmitButtonPage();

        inputControlsSteps.AcessarInputControlsSubmitButton();
        inputControlsSubmitButtonPage.clicarBtnSubmit();
        inputControlsSubmitButtonPage.tirarScreenShotDaTela();
    }

    @Test(priority = 1, description = "Teste para manipular campo Spinner")
    public void Test_ManipularCampoSpinner() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSpinnerPage = new  InputControlsSpinnerPage();

        inputControlsSteps.AcessarInputControlsSpinner();
        String opcaoInicialSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoInicialSelecionada, "Submit");

        inputControlsSpinnerPage.selecionarOpcaoGenerica("Selection 1");
        String opcaoFinalSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoFinalSelecionada, "Selection 1");
    }

    @Test(priority = 1, description = "Teste para manipular campo Text Field unico")
    public void Test_ManipularCampoTextField() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsTextFieldSinglePage = new  InputControlsTextFieldSinglePage();

        String texto = "Testando campo text view.";
        inputControlsSteps.AcessarInputControlsTextField();
        inputControlsTextFieldSinglePage.preencherCampoTexto(texto);

        Assert.assertEquals(texto, inputControlsTextFieldPage.obterTextoDoElementoCampoTexto());
    }



}
