package cz.czechitas;

import org.openqa.selenium.*;

public class HomePage {

    WebDriver browser;

    //tohle se zavola kdyz dam new
    public HomePage(WebDriver webDriver){
         browser = webDriver;
    }
    
    public void fillSearchText(String text){
        WebElement searchBox = browser.findElement(By.id("searchField"));;

        searchBox.sendKeys(text);
    }

    public void fillSearchNumber(int katalogoveCislo){
        WebElement searchBox = browser.findElement(By.id("searchBox"));;

        searchBox.sendKeys(Integer.toString(katalogoveCislo));
    }

    public SearchResultPage clickOnSearch(){
        System.out.println("klikam na search button");

        WebElement searchButton = browser.findElement(By.className("searchButton"));
        searchButton.click();

        return new SearchResultPage(browser);
    }

}
