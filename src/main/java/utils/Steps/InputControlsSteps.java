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
    }

    public void AcessarInputControlsCheckbox()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsCheckboxPage();
    }

    public void AcessarInputControlsRadioButtons()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsRadioButtonsPage();
    }

    public void AcessarInputControlsToggleButton()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsToggleButtonPage();
    }

    public void AcessarInputControlsSpinner()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsSpinnerPage();
    }

    public void AcessarInputControlsPullToRefresh()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsPullToRefreshPage();
    }

    public void AcessarInputControlsTimePicker()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsTimePickerPage();
    }

    public void AcessarInputControlsDatePicker()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsDatePickerPage();
    }

    public void AcessarInputControlsSubmitButton()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsSubmitButtonPage();
    }

    public void AcessarInputControlsGesture()
    {
        new HomePage().clicarBtnMenu();
        new MenuPage().clicarInputControls();
        new InputControlsPage().acessarInputControlsGesturesPage();
    }

}
