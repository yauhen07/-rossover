package po;

import org.openqa.selenium.By;

import static core.WebDriverSingleton.getWebDriver;

public class HomePage {
    private static final String HOME_URL = "https://www.crossover.com/";
    private static final String HOME_PAGE_TITLE = "Crossover";
    private static final By FOR_CANDIDATES_LINK_LOCATOR = By.xpath("//div[@id='desktopNav']//span[contains(text(),'For Candidates')]");

    public void openURL() {
        getWebDriver().get(HOME_URL);
    }

    public boolean isOnHomePage() {
        return getWebDriver().getTitle().equals(HOME_PAGE_TITLE);
    }

    public ForCandidatesPage clickForCandidatesLink() {
        getWebDriver().findElement(FOR_CANDIDATES_LINK_LOCATOR);
        return new ForCandidatesPage();
    }
}
