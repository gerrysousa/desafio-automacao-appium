package tests;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InputControlsDatePickerPage;
import utils.ExcelUtils;
import utils.Steps.InputControlsSteps;

import static utils.GlobalParameters.PathProject;

public class InputControlsDataDrivenTests extends BaseTests {
    @DataProvider
    public Object[][] obterDadosParaSimulacao(){
        Object[][] testObjArray = ExcelUtils.getTableArray(PathProject+"/src/main/resources/TestData.xlsx","datePicker");
        return (testObjArray);
    }

    @Test(dataProvider="obterDadosParaSimulacao")
    public void Test_DataDrivenTestSimularPropostasNovoCliente(
            String dataEscolhida
    ){
        new InputControlsSteps().AcessarInputControlsDatePicker();
        String dataInicial = new InputControlsDatePickerPage().obterDataSelecionada();


    }
}
