package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (xpath = "//div[@id='orb-nav-links']//a[@href='https://www.bbc.com/news']")
    private WebElement newsButton;
    @FindBy (xpath = "//div[@id='orb-nav-links']//a[@href='https://www.bbc.com/sport']")
    private WebElement sportButton;


    public HomePage(WebDriver driver) { super(driver);}

    public void openHomePage (String url) { driver.get(url); }
    public void userClicksOnNewsButton() { newsButton.click(); }
    public void userClicksOnSportButton() { sportButton.click(); }

}
