package cz.czechitas;

import org.openqa.selenium.*;

public class SearchResultPage {
    WebDriver browser;

    //tohle se zavola kdyz dam new
    public SearchResultPage(WebDriver webDriver){
        browser = webDriver;
    }

    private String getResultText(){
        //todo doprogramovat si :)
        return "todo doprogramovat si :)";
    }

}
