package tests.androidTests;

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
    InputControlsGesturesPage inputControlsGesturesPage;

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

        String Unchecked = "Unchecked";
        String Checked = "Checked";

        inputControlsSteps.AcessarInputControlsCheckbox();
        String statusInicial = inputControlsCheckboxPage.obterStatusCheckbox();
        Assert.assertEquals(statusInicial, Unchecked);

        inputControlsCheckboxPage.clicarCkbCheckbox();
        String statusFinal = inputControlsCheckboxPage.obterStatusCheckbox();
        Assert.assertEquals(statusFinal, Checked);
    }

    @Test(priority = 1, description = "Teste para manipular campo Radio buttons")
    public void Test_ManipularCampoRadioButtons() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsRadioButtonsPage = new  InputControlsRadioButtonsPage();

        String amazon ="Amazon";
        String services ="Services";

        inputControlsSteps.AcessarInputControlsRadioButtons();
        String radioMarcadoInicial = inputControlsRadioButtonsPage.obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoInicial, amazon);

        inputControlsRadioButtonsPage.clicarRdbService();
        String radioMarcadoFinal = inputControlsRadioButtonsPage.obterRadioButtonMarcado();
        Assert.assertEquals(radioMarcadoFinal, services);
    }

    @Test(priority = 1, description = "Teste para manipular campo Toggle buttons")
    public void Test_ManipularCampoToggleButtons() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsToggleButtonPage = new  InputControlsToggleButtonPage();

        String OFF ="OFF";
        String ON ="ON";

        inputControlsSteps.AcessarInputControlsToggleButton();
        String toggleInicial = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleInicial, OFF);

        inputControlsToggleButtonPage.clicarBtnSwitch();
        String toggleFinal = inputControlsToggleButtonPage.obterStatusSwitch();
        Assert.assertEquals(toggleFinal, ON);
    }

    @Test(priority = 1, description = "Teste para manipular campo Spinner")
    public void Test_ManipularCampoSpinner() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSpinnerPage = new  InputControlsSpinnerPage();

        String opcao3 = "option 3";
        String opcao1selecionada = "Selected: option 1";
        String opcao3selecionada = "Selected: option 3";

        inputControlsSteps.AcessarInputControlsSpinner();
        String opcaoInicialSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoInicialSelecionada, opcao1selecionada);

        inputControlsSpinnerPage.selecionarOpcaoGenerica(opcao3);
        String opcaoFinalSelecionada = inputControlsSpinnerPage.obterOpcaoSelecionada();
        Assert.assertEquals(opcaoFinalSelecionada, opcao3selecionada);
    }

    @Test(priority = 1, description = "Teste para manipular campo Pull to Resfresh")
    public void Test_ManipularCampoPullToRefresh() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsPushToRefreshPage = new  InputControlsPushToRefreshPage();

        String statusInicial = "Pull to refresh time";
        String doisPontosDaHora=":";

        inputControlsSteps.AcessarInputControlsPullToRefresh();
        String textoInicial = inputControlsPushToRefreshPage.obterMensagemExibida();
        Assert.assertEquals(textoInicial, statusInicial);

        inputControlsPushToRefreshPage.scrollDown();//.scroll(0.3, 0.8);
        String textoFinal = inputControlsPushToRefreshPage.obterMensagemExibida();
        Assert.assertTrue(textoFinal.contains(doisPontosDaHora));
    }

    @Test(priority = 1, description = "Teste para manipular campo Botão Submit")
    public void Test_ManipularCampoBotaoSubmit() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsSubmitButtonPage = new  InputControlsSubmitButtonPage();

        inputControlsSteps.AcessarInputControlsSubmitButton();
        inputControlsSubmitButtonPage.clicarBtnSubmit();
        inputControlsSubmitButtonPage.tirarScreenShotDaTela();
    }

    @Test(priority = 1, description = "Teste para manipular campo Botão Submit")
    public void Test_ManipularCampoGestures() {
        inputControlsSteps = new InputControlsSteps();
        inputControlsGesturesPage = new  InputControlsGesturesPage();

        String resultado = "Single Tap Up";

        inputControlsSteps.AcessarInputControlsGesture();
        inputControlsGesturesPage.clicarPadGestos();
        inputControlsGesturesPage.tirarScreenShotDaTela();
        String textoFinal = inputControlsGesturesPage.obterTextoLblDisplayGestosExecutados();

        Assert.assertTrue(textoFinal.contains(resultado));
    }

}
