package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InputControlsDatePickerPage;
import utils.ExcelUtils;
import utils.Steps.*;

import static utils.GlobalParameters.PathProject;

public class InputControlsDataDrivenTests extends BaseTests {

    InputControlsSteps inputControlsSteps;
    InputControlsDatePickerPage inputControlsDatePickerPage;
    InputControlsDatePickerSteps inputControlsDatePickerSteps;

    @DataProvider
    public Object[][] obterDadosParaSimulacao(){
        Object[][] testObjArray = ExcelUtils.getTableArray(PathProject+"/src/main/resources/TestData.xlsx","datePicker");
        return (testObjArray);
    }

    @Test(dataProvider="obterDadosParaSimulacao")
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
}
