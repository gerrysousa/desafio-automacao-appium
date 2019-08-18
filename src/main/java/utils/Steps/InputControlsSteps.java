package utils.Steps;

import pages.HomePage;
import pages.InputControlsPage;
import pages.MenuPage;

public class InputControlsSteps {

    public void AcessarInputControlsTextField()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsTextFieldPage();
      //  boolean verificar = new InputControlsTextFieldPage().verificaSeAcessouTextField();
        //Assert.assertEquals(true,verificar );
    }
}
