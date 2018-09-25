package crossovertests;

import org.testng.Assert;
import org.testng.annotations.Test;
import po.ForCandidatesPage;
import po.HomePage;
import po.ListOfJobsPage;

public class JobsFilterTest extends BaseTest {

    @Test(description = "Filter test on List of jobs page")
    public void filterTest() {
        // 1) Open site: www.crossover.com
        HomePage homePage = new HomePage();
        homePage.openURL();
        //   Make sure site is opened.
        Assert.assertTrue(homePage.isOnHomePage(), "Home page 'www.crossover.com' is not opened");
        //2) Go to "FOR CANDIDATES" Page.
        ForCandidatesPage forCandidatesPage = homePage.clickForCandidatesLink();
        //   Make sure page is opened.
        Assert.assertTrue(forCandidatesPage.isOnForCandidatesPage(), "For Candidates Page is not opened");
        //3) Click to "See available Jobs" button
        ListOfJobsPage listOfJobsPage = forCandidatesPage.clickSeeAvaliableJobsLink();
        //   Make sure corresponding page is opened.
        Assert.assertTrue(listOfJobsPage.isOnListOfJobsPage(), "For Candidates Page is not opened");
        //4) Type "chief" at the filter box. Click Search Job button
        listOfJobsPage.inputFilterCriteria("chief");
        listOfJobsPage.clickSearchButton();

        //   Make sure that only "chief" jobs are displayed.
        Assert.assertTrue(listOfJobsPage.jobsFilteredDisplayed("chief"), "Not only 'chief' jobs are displayed");
        //   Log information (all jobs titles)
        listOfJobsPage.loggingDisplayedList();
        //5) click Reset button
        listOfJobsPage.clickResetButton();
        //   Make sure that not only "chief jobs"are displayed.
        Assert.assertTrue(listOfJobsPage.jobsNotFilteredDisplayed("chief"), "Only 'chief' jobs are displayed");
        //   Log information (all jobs titles)
        listOfJobsPage.loggingDisplayedList();
    }
}
