package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InputControlsPage extends BasePage {

    @iOSFindBy(xpath= "//XCUIElementTypeTextView")
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

    @iOSFindBy(xpath= "//XCUIElementTypePageIndicator")
    private MobileElement elementoGenerico;


    public void acessarInputControlsTextFieldPage() {
        clicar(pageTextField);
    }

    public void acessarInputControlsCheckboxPage() {
        acessarInputControlsTextFieldPage();
        clicar(pageCheckbox);
    }

    public void acessarInputControlsRadioButtonsPage() {
        acessarInputControlsCheckboxPage();
        clicar(pageRadioButtons);
    }

    public void acessarInputControlsToggleButtonPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            acessarInputControlsRadioButtonsPage();
            clicar(pageToggleButton);
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            for (int i=0;i<5;i++)
            {
                swipeRightIOS();
            }
        }
    }

    public void acessarInputControlsSpinnerPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            acessarInputControlsToggleButtonPage();
            clicar(pageSpinner);
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            for (int i=0;i<8;i++)
            {
                swipeRightIOS();
            }
        }
    }

    public void acessarInputControlsPullToRefreshPage() {
        acessarInputControlsSpinnerPage();
        clicar(pagePullToRefresh);
    }

    public void acessarInputControlsTimePickerPage() {
        acessarInputControlsPullToRefreshPage();
        clicar(pageTimePicker);
    }

    public void acessarInputControlsDatePickerPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            acessarInputControlsTimePickerPage();
            clicar(pageDatePicker);
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            for (int i=0;i<2;i++)
            {
                swipeRightIOS();
            }
        }
    }

    public void acessarInputControlsSubmitButtonPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            acessarInputControlsDatePickerPage();
            clicar(pageSubmitButton);
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            for (int i=0;i<7;i++)
            {
                swipeRightIOS();
            }
        }
    }

    public void acessarInputControlsGesturesPage() {
        acessarInputControlsSubmitButtonPage();
        clicar(pageGestures);
    }

    public void acessarInputControlsBotaoMaisInformacaoPage() {
        swipe(0.9,0.1);
    }

    public void acessarInputControlsTextFieldSinglePage() {
        for (int i=0;i<6;i++)
        {
            swipeRightIOS();
        }
    }
}
