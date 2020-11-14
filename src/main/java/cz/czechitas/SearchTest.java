package cz.czechitas;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class SearchTest {

    WebDriver browser;

    @Before
    public void SetUp() {
        //nastavte si prosím cestu k svemu driveru
        System.setProperty("webdriver.gecko.driver", "C:\\DevGit\\geckodriver.exe");

        //muzete pouzit FirefoxOptions pokud chete nebo jste meli problem s firefox binary
        browser = new FirefoxDriver();
    }

    @Test
    public void Search_NonExistingItem_ZeroItemsFound() throws InterruptedException {

        System.out.println("Jdu na home page eshopu");
        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

        System.out.println("vypisuji Ahoj do search pole");
        WebElement searchBox = browser.findElement(By.className("tt-input"));
        searchBox.sendKeys("nexistujiciVec"); //vypsání ahoj do pole

        Thread.sleep(2000);

        System.out.println("klikam na search button");

        WebElement searchButton = browser.findElement(By.className("searchButton"));
        searchButton.click();

        System.out.println("Kontroluji ze uzivatel byl presmerovan");

        String currentUrl = browser.getCurrentUrl();

        Assert.assertEquals("Po kliknuti na search button by mel byt uzivatel presmerovan na jinou url", "http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", currentUrl);
    }


    @Test
    public void SearchTestSPOM() throws InterruptedException {

        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

        HomePage homePage = new HomePage(browser);

        Thread.sleep(2000);

        homePage.fillSearchText("Bag");

        Thread.sleep(2000);

        homePage.clickOnSearch();
        
        Thread.sleep(2000);

        SearchResultPage resultPage = homePage.clickOnSearch();

        Thread.sleep(2000);
        //...
    }

    @After
    public void CleanUp() {
        browser.quit();
    }
}
