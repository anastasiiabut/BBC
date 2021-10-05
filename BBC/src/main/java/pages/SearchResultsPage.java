package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends  BasePage {

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']")
    private WebElement titleOfHeadlineArticle;
    @FindBy(xpath = "//div[@class='gel-wrap gs-u-pt+']//h3")
    private List<WebElement> newsStoriesContainersList;
    @FindBy(xpath =
            "//div[@data-entityid='container-top-stories#1']//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//li[@class='nw-c-promo-meta']/a")
    private WebElement categoryText;
    @FindBy(xpath = "//button[@id='orb-search-button']")
    private WebElement searchFieldButton;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;
    @FindBy(xpath = "//li[1]//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']")
    private WebElement titleOfTheFirstArticle;
    @FindBy(xpath =
            "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//a[@href='/news/coronavirus']")
    private WebElement coronavirusTab;
    @FindBy(xpath =
            "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__secondary-sections']//a[@href='/news/have_your_say']")
    private WebElement yourCoronavirusStoriesTab;
    @FindBy(xpath = "//a[@href='/news/10725415']")
    private WebElement howToShareWithBBCNEWS;
    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
    private WebElement textField;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;
    @FindBy(xpath = "//div[@class='checkbox'][2]//input[@type='checkbox']")
    private WebElement acceptTheTermsOfServiceButton;
    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='input-error-message'][contains(text(), 'must be accepted')]")
    private WebElement theAcceptanceOfTheTermsOfServiceErrorMessage;
    @FindBy(xpath = "//div[@class='input-error-message'][contains(text(), 'Name')]")
    private WebElement theNameErrorMessage;
    @FindBy(xpath = "//div[@class='input-error-message'][contains(text(), 'be blank')]")
    private WebElement theStoryErrorMessage;
    @FindBy (xpath = "//div[@aria-label='Primary']//a[@href='/sport/football']")
    private WebElement footballTab;
    @FindBy (xpath = "//ul[@aria-label='Secondary']//a[@href='/sport/football/scores-fixtures']")
    private WebElement scoresAndFixturesTab;
    @FindBy (xpath = "//input[@placeholder='Enter a team or competition']")
    private WebElement championshipSearchField;
    @FindBy (xpath = "//div[@id='search-results']//li[1]")
    private WebElement championshipSearchResult;
    @FindBy (xpath = "//ul[@id='sp-timeline-past-dates']//span[@class='gel-long-primer-bold gs-u-display-block']")
    private List<WebElement> monthsList;
    @FindBy (xpath =
            "//div[@class='qa-match-block'][2]//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--home']")
    private WebElement oneTeam;
    @FindBy (xpath =
            "//div[@class='qa-match-block'][2]//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--away']")
    private WebElement anotherTeam;
    @FindBy (xpath =
            "//div[@class='qa-match-block'][2]//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']")
    private WebElement oneResult;
    @FindBy (xpath =
            "//div[@class='qa-match-block'][2]//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']")
    private WebElement anotherResult;
    @FindBy (xpath = "//div[@class='qa-match-block'][2]")
    private WebElement secondLine;
    @FindBy (xpath = "//div[@class='football-oppm-header']")
    private WebElement scoreBanner;

    public SearchResultsPage(WebDriver driver) { super(driver);}
    public String getTitleOfHeadlineArticle() { return titleOfHeadlineArticle.getText(); }
    public List<WebElement> getNewsStoriesContainersList() { return newsStoriesContainersList; }
    public String getCategoryText() {return categoryText.getText(); }
    public void userClicksOnSearchFieldButton() { searchFieldButton.click();  }
    public void inputsThisTextInTheSearchFiled() { searchField.sendKeys(getCategoryText()); }
    public String getTitleOfTheFirstArticle() { return titleOfTheFirstArticle.getText(); }
    public void userClicksOnCoronavirusTab() { coronavirusTab.click();}
    public void userClicksOnYourCoronavirusStoriesTab() {yourCoronavirusStoriesTab.click();}
    public void userClicksOnHowToShareWithBBCNEWS() {howToShareWithBBCNEWS.click();}
    public void clicksOnTextField() {textField.click();}
    public void userSharesHisOrHerStory(String story) {textField.sendKeys(story); }
    public void clicksOnNameField() {nameField.click();}
    public void userInputsHisOrHerName(String name) {nameField.sendKeys(name);}
    public void userAcceptsTheTermsOfService() { acceptTheTermsOfServiceButton.click(); }
    public void userClicksOnSubmitButton() {submitButton.click();}
    public WebElement getSubmitButton() { return submitButton;}
    public boolean getTheAcceptanceOfTheTermsOfServiceErrorMessage() {
        return theAcceptanceOfTheTermsOfServiceErrorMessage.isDisplayed();
    }
    public WebElement getTheAcceptanceOfTheTermsOfServiceErrorMessageVisible() {
        return theAcceptanceOfTheTermsOfServiceErrorMessage;
    }
    public boolean getTheNameErrorMessage() { return theNameErrorMessage.isDisplayed();}
    public WebElement getTheNameErrorMessageVisible() { return theNameErrorMessage; }
    public boolean getTheStoryErrorMessage() { return theStoryErrorMessage.isDisplayed(); }
    public WebElement getTheStoryErrorMessageVisible() {return theStoryErrorMessage;}
    public void userClicksOnFootballTab() { footballTab.click(); }
    public void userClicksOnScoresAndFixturesTab() {scoresAndFixturesTab.click();}
    public void clicksOnChampionshipSearchField() {championshipSearchField.click();}
    public void userInputsAChampionshipInTheSearchField (String championship) {
        championshipSearchField.sendKeys(championship);
    }
    public void clicksOnChampionshipSearchResult() {championshipSearchResult.click();}
    public WebElement getChampionshipSearchResult () {return championshipSearchResult;}
    public void chooseMonth (String month) {
        for (WebElement webElement : monthsList) {
            if (webElement.getText().contains(month))
                webElement.click();
        }
    }
    public String getOneTeam () {return oneTeam.getText(); }
    public String getAnotherTeam () {return anotherTeam.getText();}
    public String getOneResult () {return oneResult.getText(); }
    public String getAnotherResult () {return anotherResult.getText(); }
    public WebElement getSecondLineVisible () { return secondLine;}
    public void userClicksOnTheFirstTeam() { oneTeam.click(); }
    public WebElement scoreBanner() {return scoreBanner;}



}

