package stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @Given("User opens {string} page")
    public void openHomePage (final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on 'News' button")
    public void userClicksOnNewsButton() { homePage.userClicksOnNewsButton(); }


    @Then("User checks that the name of headline article is {string}")
    public void userChecksThatTheNameOfHeadlineArticleIsTitle(final String title) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.getTitleOfHeadlineArticle();
        System.out.println(searchResultsPage.getTitleOfHeadlineArticle());
        Assert.assertTrue(searchResultsPage.getTitleOfHeadlineArticle().contains(title));
    }

    @Then("User checks that the name of the second article is {string}")
    public void userChecksThatTheNameOfTheSecondArticleIsTitle(final String title) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        List<String> list = new ArrayList<String>();
        for (WebElement webElement : searchResultsPage.getNewsStoriesContainersList()) {
            list.add(webElement.getText());
        }
        assertTrue(list.get(2).contains(title));
        System.out.println(list);
        System.out.println(list.get(0));
    }

    @And("User stores the text of category link of the headline article")
    public void userStoresTheTextOfCategoryLinkOfTheHeadlineArticle() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.getCategoryText();
        System.out.println(searchResultsPage.getCategoryText());
    }

    @When("User inputs this text in the search filed")
    public void userInputsThisTextInTheSearchFiled() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.inputsThisTextInTheSearchFiled();
    }

    @And("User clicks on search field button")
    public void userClicksOnSearchFieldButton() { searchResultsPage.userClicksOnSearchFieldButton(); }


    @Then("User checks that the name of the first article is {string}")
    public void userChecksThatTheNameOfTheFirstArticleIsTitle(final String title) {
        searchResultsPage.getTitleOfTheFirstArticle();
        Assert.assertTrue(searchResultsPage.getTitleOfTheFirstArticle().contains(title));
        System.out.println(searchResultsPage.getTitleOfTheFirstArticle());
    }

    @And("User clicks on 'Coronavirus' tab")
    public void userClicksOnCoronavirusTab() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.userClicksOnCoronavirusTab();
    }

    @And("User clicks on 'Your Coronavirus Stories' tab")
    public void userClicksOnYourCoronavirusStoriesTab() { searchResultsPage.userClicksOnYourCoronavirusStoriesTab();}

    @When("User clicks on 'How to share with BBC NEWS'")
    public void userClicksOnHowToShareWithBBCNEWS() { searchResultsPage.userClicksOnHowToShareWithBBCNEWS(); }

    @And("User shares his or her {string}")
    public void userSharesHisOrHerStory(final String story) {
        searchResultsPage.clicksOnTextField();
        searchResultsPage.userSharesHisOrHerStory(story);
    }

    @And("User inputs his or her {string}")
    public void userInputsHisOrHerName(final String name) {
        searchResultsPage.clicksOnNameField();
        searchResultsPage.userInputsHisOrHerName(name);
    }

    @And("User accepts the Terms of Service")
    public void userAcceptsTheTermsOfService() { searchResultsPage.userAcceptsTheTermsOfService(); }

    @And("User clicks on 'Submit' button")
    public void userClicksOnSubmitButton() {

        searchResultsPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSubmitButton());
        searchResultsPage.userClicksOnSubmitButton(); }

    @And("User refreshes page")
    public void userReloadsPage() { driver.navigate().refresh(); }

    @And("User checks the acceptance of the Terms of Service error message visibility")
    public void userChecksTheAcceptanceOfTheTermsOfServiceErrorMessageVisibility() {
        searchResultsPage.waitForVisibilityOfElement(
                DEFAULT_TIMEOUT, searchResultsPage.getTheAcceptanceOfTheTermsOfServiceErrorMessageVisible());
        assertTrue(searchResultsPage.getTheAcceptanceOfTheTermsOfServiceErrorMessage());
    }

    @And("User checks the name error message visibility")
    public void userChecksTheNameErrorMessageVisibility() {
        searchResultsPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getTheNameErrorMessageVisible());
        assertTrue(searchResultsPage.getTheNameErrorMessage());
    }

    @Then("User checks the story error message visibility")
    public void userChecksTheStoryErrorMessageVisibility() {
        searchResultsPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getTheStoryErrorMessageVisible());
        assertTrue(searchResultsPage.getTheStoryErrorMessage());
    }

    @And("User clicks on 'Sport' button")
    public void userClicksOnSportButton() { homePage.userClicksOnSportButton(); }

    @And("User clicks on 'Football' tab")
    public void userClicksOnFootballTab() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.userClicksOnFootballTab();
    }

    @And("User clicks on 'Scores and Fixtures' tab")
    public void userClicksOnScoresAndFixturesTab() { searchResultsPage.userClicksOnScoresAndFixturesTab(); }

    @And("User inputs a {string} in the search field")
    public void userInputsAChampionshipInTheSearchField(String championship) {
        searchResultsPage.clicksOnChampionshipSearchField();
        searchResultsPage.userInputsAChampionshipInTheSearchField (championship);
        searchResultsPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getChampionshipSearchResult());
        searchResultsPage.clicksOnChampionshipSearchResult();
    }

    @And("User selects results for a {string}")
    public void userSelectsResultsForAMonth(final String month) {
        searchResultsPage.chooseMonth(month);
    }

    @And("User checks that {string} played with {string} and have {string} and {string} results")
    public void userChecksThatOneTeamPlayedWithAnotherTeamAndHaveOneAndAnotherResults(
            final String oneTeam, final String anotherTeam, final String oneResult, final String anotherResult) {
        searchResultsPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSecondLineVisible());
        assertTrue(searchResultsPage.getOneTeam().contains(oneTeam));
        assertTrue(searchResultsPage.getAnotherTeam().contains(anotherTeam));
        assertTrue(searchResultsPage.getOneResult().contains(oneResult));
        assertTrue(searchResultsPage.getAnotherResult().contains(anotherResult));
    }

    @And("User clicks on the first team")
    public void userClicksOnTheFirstTeam() { searchResultsPage.userClicksOnTheFirstTeam(); }

    @And("User checks that the score is {string} and {string}")
    public void userChecksThatTheScoreIsOneAndAnother(final String oneResult, final String anotherResult) {
        assertTrue(searchResultsPage.scoreBanner().getText().contains(oneResult));
        assertTrue(searchResultsPage.scoreBanner().getText().contains(anotherResult));
    }

    @And("User checks that teams are {string} and {string}")
    public void userChecksThatTeamsAreOneTeamAndAnotherTeam(final String oneTeam, final String anotherTeam) {
        assertTrue(searchResultsPage.scoreBanner().getText().contains(oneTeam));
        assertTrue(searchResultsPage.scoreBanner().getText().contains(anotherTeam));
    }

    @After
    public void tearDown () { driver.close(); }



}
