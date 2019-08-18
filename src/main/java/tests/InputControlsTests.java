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
        String texto = "Testando campo text field.";
        new InputControlsPage().acessarInputControlsTextFieldPage();
        new InputControlsTextFieldPage().preencherCampoTexto(texto);

        Assert.assertEquals(texto, new InputControlsTextFieldPage().obterTextoDoElementoCampoTexto());
    }

}
