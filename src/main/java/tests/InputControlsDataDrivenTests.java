package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InputControlsDatePickerPage;
import pages.InputControlsTimePickerPage;
import utils.ExcelUtils;
import utils.Steps.*;

import static utils.GlobalParameters.PathProject;

public class InputControlsDataDrivenTests extends BaseTests {

    InputControlsSteps inputControlsSteps;
    InputControlsDatePickerPage inputControlsDatePickerPage;
    InputControlsTimePickerPage inputControlsTimePickerPage;

    InputControlsDatePickerSteps inputControlsDatePickerSteps;
    InputControlsTimePickerSteps inputControlsTimePickerSteps;

    @DataProvider
    public Object[][] obterDadosParaTesteDatePicker(){
        Object[][] testObjArray = ExcelUtils.getTableArray(PathProject+"/src/main/resources/TestData.xlsx","datePicker");
        return (testObjArray);
    }

    @Test(dataProvider="obterDadosParaTesteDatePicker")
    public void Test_ManipularCampoDatePicker(
            String dataEscolhida
    ){
        String dataPadrao = "05/07/1994";
        inputControlsSteps = new InputControlsSteps();
        inputControlsDatePickerPage= new InputControlsDatePickerPage();
        inputControlsDatePickerSteps= new InputControlsDatePickerSteps();


        inputControlsSteps.AcessarInputControlsDatePicker();
        String dataInicial = inputControlsDatePickerPage.obterDataSelecionada();
        Assert.assertEquals(dataInicial, dataPadrao);

        inputControlsDatePickerSteps.SelecionarNovaData(dataEscolhida);

        String dataFinal = inputControlsDatePickerPage.obterDataSelecionada();
        Assert.assertEquals(dataFinal, dataEscolhida);//Expected:21/01/1990 --- Actual:1/21/1990
    }

    @Test(dataProvider="obterDadosParaTesteTimePicker")
    public void Test_ManipularCampoTimePicker(
            String hora,
            String minutos,
            String AmPm
    ){
        String horaNaoSelecionada = "Select a time";
        inputControlsSteps = new InputControlsSteps();
        inputControlsTimePickerPage= new InputControlsTimePickerPage();
        inputControlsTimePickerSteps= new InputControlsTimePickerSteps();


        inputControlsSteps.AcessarInputControlsTimePicker();
        String textoInicial = inputControlsTimePickerPage.obterHoraSelecionada();
        Assert.assertEquals(textoInicial, horaNaoSelecionada);

//        inputControlsDatePickerSteps.SelecionarNovaData(dataEscolhida);
//
//        String dataFinal = inputControlsDatePickerPage.obterDataSelecionada();
//        Assert.assertEquals(dataFinal, dataEscolhida);//Expected:21/01/1990 --- Actual:1/21/1990
    }


}
