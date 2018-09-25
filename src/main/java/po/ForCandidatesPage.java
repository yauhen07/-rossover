package po;

import org.openqa.selenium.By;

import static core.WebDriverSingleton.getWebDriver;

public class ForCandidatesPage {
    private static final String FOR_CONDIDATES_PAGE_TITLE = "For Candidates — Crossover";
    private static final By SEE_AVAILABLE_JOBS_BUTTON = By.xpath("//a[text()='SEE AVAILABLE JOBS' and @id]");

    public boolean isOnForCandidatesPage() {
        return getWebDriver().getTitle().equals(FOR_CONDIDATES_PAGE_TITLE);
    }

    public ListOfJobsPage clickSeeAvaliableJobsLink() {
        getWebDriver().findElement(SEE_AVAILABLE_JOBS_BUTTON).click();
        return new ListOfJobsPage();
    }
}
