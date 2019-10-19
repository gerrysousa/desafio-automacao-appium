package tests;

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

        String textoAlerta = "This is the alert message";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnAlertsDialogsPage();

        alertsDialogsPage.clicarBtnAlert();

        String teste2 = alertsDialogsPage.obterMensagemDoAlerta();
        Assert.assertEquals(teste2, textoAlerta);
    }

    @Test(priority = 1, description = "Teste para manipular Toast Alert")
    public void Test_AlertsToast() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        alertsDialogsPage= new AlertsDialogsPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnAlertsDialogsPage();

        alertsDialogsPage.clicarBtnToast();
        alertsDialogsPage.tirarScreenShotDaTela();
    }
}
