package com_ui_testing.pages;

import com_ui_testing_utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));;

    public HomePage() {
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='commonModal__close']")
    private WebElement loginPopupClose;

    @FindBy(xpath = "//ul[@class=\"makeFlex font12 headerIconsGap\"]/li[6]/span")
    private WebElement busesTab;

    @FindBy(xpath = "//ul[@class=\"makeFlex font12 headerIconsGap\"]/li[4]/span")
    private WebElement holidayTab;

    public void closePopupIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPopupClose));
            loginPopupClose.click();
            System.out.println("Popup closed successfully.");
        } catch (Exception e) {
            System.out.println("Popup not present, skipping close.");
        }
    }

    public void clickBusesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(busesTab));
        busesTab.click();
        System.out.println("Navigated to Buses tab.");
    }

    public void clickHolidayPackageTab(){
        wait.until(ExpectedConditions.elementToBeClickable(holidayTab));
        holidayTab.click();
    }





}
