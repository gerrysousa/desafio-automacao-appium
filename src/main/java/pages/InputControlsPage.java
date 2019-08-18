package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsPage extends BasePage {

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Text Field']")
    private MobileElement pageTextField;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Checkbox']")
    private MobileElement pageCheckbox;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Radio Buttons']")
    private MobileElement pageRadioButtons;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Toggle Button']")
    private MobileElement pageToggleButton;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Spinner']")
    private MobileElement pageSpinner;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Pull To Refresh']")
    private MobileElement pagePullToRefresh;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Time Picker']")
    private MobileElement pageTimePicker;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Date Picker']")
    private MobileElement pageDatePicker;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Text Field']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Submit Button']")
    private MobileElement pageSubmitButton;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Gestures']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Gestures']")
    private MobileElement pageGestures;


    public void acessarInputControlsTextFieldPage() {
        new MenuPage().clicarInputControls();
    }

    public void acessarInputControlsCheckboxPage() {
        new InputControlsPage().acessarInputControlsTextFieldPage();
        clicar(pageCheckbox);
    }

    public void acessarInputControlsRadioButtonsPage() {
        new InputControlsPage().acessarInputControlsCheckboxPage();
        clicar(pageRadioButtons);
    }

    public void acessarInputControlsToggleButtonPage() {
        new InputControlsPage().acessarInputControlsRadioButtonsPage();
        clicar(pageToggleButton);
    }

    public void acessarInputControlsSpinnerPage() {
        new InputControlsPage().acessarInputControlsToggleButtonPage();
        clicar(pageSpinner);
    }

    public void acessarInputControlsPullToRefreshPage() {
        new InputControlsPage().acessarInputControlsSpinnerPage();
        clicar(pagePullToRefresh);
    }


    public void acessarInputControlsTimePickerPage() {
        new InputControlsPage().acessarInputControlsPullToRefreshPage();
        clicar(pageTimePicker);
    }

    public void acessarInputControlsDatePickerPage() {
        new InputControlsPage().acessarInputControlsTimePickerPage();
        clicar(pageDatePicker);
    }

    public void acessarInputControlsSubmitButtonPage() {
        new InputControlsPage().acessarInputControlsDatePickerPage();
        clicar(pageSubmitButton);
    }

    public void acessarInputControlsGesturesPage() {
        new InputControlsPage().acessarInputControlsSubmitButtonPage();
        clicar(pageGestures);
    }

}
