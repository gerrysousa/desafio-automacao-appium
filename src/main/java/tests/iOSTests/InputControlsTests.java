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

        String toggleInativo = "0";
        String toggleAtivo = "1";

        inputControlsSteps.AcessarInputControlsToggleButton();
        String toggleInicial = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleInicial, toggleInativo);

        inputControlsToggleButtonPage.clicarBtnSwitch();
        String toggleFinal = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleFinal, toggleAtivo);
    }

    @Test(priority = 1, description = "Teste para manipular campo mais informacao")
    public void Test_ManipularCampoMaisInformacao() {
       inputControlsSteps = new InputControlsSteps();
       inputControlsCampoInformacaoPage = new InputControlsCampoInformacaoPage();

       String textoEsperado = "More Info";

       inputControlsSteps.AcessarInputControlsBotaoMaisInformacao();
       inputControlsCampoInformacaoPage.clicarBtnMaisInformacao();
       String statusFinal = inputControlsCampoInformacaoPage.obterTextoBtnMaisInformacao();
       Assert.assertEquals(statusFinal,textoEsperado);
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

        String opcaoNaoSelecionada = "Submit";
        String opcaoSelecionada = "Selection 1";

        inputControlsSteps.AcessarInputControlsSpinner();
        String opcaoInicialSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoInicialSelecionada, opcaoNaoSelecionada);

        inputControlsSpinnerPage.selecionarOpcaoGenerica(opcaoSelecionada);
        String opcaoFinalSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoFinalSelecionada, opcaoSelecionada);
    }

    @Test(priority = 1, description = "Teste para manipular campo Text Field unico")
    public void Test_ManipularCampoTextField() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsTextFieldSinglePage = new  InputControlsTextFieldSinglePage();

        String texto = "Testando campo text view.";
        inputControlsSteps.AcessarInputControlsTextFieldSingle();
        inputControlsTextFieldSinglePage.preencherCampoTexto(texto);

        String textoEsperado =  inputControlsTextFieldSinglePage.obterTextoDoElementoCampoTexto();
        Assert.assertEquals(texto,textoEsperado);
    }

}
