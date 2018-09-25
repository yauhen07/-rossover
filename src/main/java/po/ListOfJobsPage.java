package po;

import logging.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.WebDriverSingleton.getWebDriver;

public class ListOfJobsPage {
    private static final By INPUT_FILTER_LOCATOR = By.xpath("//input[@placeholder='Job title, keywords']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");
    private static final By JOBS_TITLES_LOCATOR = By.xpath("//div[@class='cell title ng-binding']");
    private static final By RESET_BUTTON_LOCATOR = By.xpath("//button[@type='button']");

    public boolean isOnListOfJobsPage() {
        return getWebDriver().getTitle().equals(INPUT_FILTER_LOCATOR);
    }

    public void inputFilterCriteria(String s) {
        getWebDriver().findElement(INPUT_FILTER_LOCATOR).clear();
        getWebDriver().findElement(INPUT_FILTER_LOCATOR).sendKeys(s);
    }

    public void clickSearchButton() {
        getWebDriver().findElement(SEARCH_BUTTON_LOCATOR).click();
    }

    public boolean jobsFilteredDisplayed(String chief) {
        List<WebElement> listOfResults = getWebDriver().findElements(JOBS_TITLES_LOCATOR);
        for (WebElement a : listOfResults) {
            if (!a.getText().contains(chief)) {
                return false;
            }
        }
        return true;
    }

    public void clickResetButton() {
        getWebDriver().findElement(RESET_BUTTON_LOCATOR).click();
    }

    public boolean jobsNotFilteredDisplayed(String chief) {
        List<WebElement> listOfResults = getWebDriver().findElements(JOBS_TITLES_LOCATOR);
        for (WebElement a : listOfResults) {
            if (!a.getText().contains(chief)) {
                return true;
            }
        }
        return false;
    }


    public void loggingDisplayedList() {
        List<WebElement> listOfResults = getWebDriver().findElements(JOBS_TITLES_LOCATOR);
        for (WebElement a : listOfResults) {
            CustomLogger.info(a.getText());
        }
    }
}
