package tests.iOSTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AlertsTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    AlertsDialogsPage alertsDialogsPage;

    @Test(priority = 1, description = "Teste para manipular Alert")
    public void Test_MensagemAlerta() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        alertsDialogsPage= new AlertsDialogsPage();

        String textoAlerta = "This is an alert";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnAlertsDialogsPage();

        alertsDialogsPage.clicarBtnAlert();

        String teste2 = alertsDialogsPage.obterMensagemDoAlerta();
        Assert.assertEquals(teste2, textoAlerta);
    }

    @Test(priority = 1, description = "Teste para manipular Modal Alert")
    public void Test_AlertsModal() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        alertsDialogsPage= new AlertsDialogsPage();

        String textoAlerta = "This is a modal view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnAlertsDialogsPage();

        alertsDialogsPage.clicarBtnToast();
        String teste2 = alertsDialogsPage.obterMensagemDoModal();
        Assert.assertEquals(teste2, textoAlerta);
    }
}
