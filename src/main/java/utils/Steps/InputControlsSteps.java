package utils.Steps;

import pages.HomePage;
import pages.InputControlsPage;
import pages.MenuPage;

public class InputControlsSteps {
    private HomePage homePage = new HomePage();
    private MenuPage menuPage = new MenuPage();
    private InputControlsPage inputControlsPage = new InputControlsPage();


    public void AcessarInputControlsTextField()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsTextFieldPage();
    }

    public void AcessarInputControlsCheckbox()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsCheckboxPage();
    }

    public void AcessarInputControlsRadioButtons()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsRadioButtonsPage();
    }

    public void AcessarInputControlsToggleButton()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsToggleButtonPage();
    }

    public void AcessarInputControlsSpinner()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsSpinnerPage();
    }

    public void AcessarInputControlsPullToRefresh()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsPullToRefreshPage();
    }

    public void AcessarInputControlsTimePicker()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsTimePickerPage();
    }

    public void AcessarInputControlsDatePicker()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsDatePickerPage();
    }

    public void AcessarInputControlsSubmitButton()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsSubmitButtonPage();
    }

    public void AcessarInputControlsGesture()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarInputControls();
        inputControlsPage.acessarInputControlsGesturesPage();
    }

}
