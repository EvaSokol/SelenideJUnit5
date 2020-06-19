import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends CommonPage{

    public static String mainUrl = "https://www.sportmaster.ru/";
    public static By notThatCityButton = By.className("sm-btn-gray");
    public static By currentCityValue = By.xpath("//a[@data-selenium = 'open_city_menu']");
    public static By searchCityInput = By.xpath("//input[@data-selenium = 'search_city_input']");
    public static String expectedCityNameLocator = "//a[@data-selenium = 'search_city_autocomplete_item' and text() ='%s']";
    public static By okCityButton = By.xpath("//input[@data-selenium = 'search_city_select_button']");
    public static By nothingFoundMessage = By.className("citySelect__emptySearch");

    public MainPage(){
        goToUrl(mainUrl);
    }

    public String getCurrentCityName(){
        return $(currentCityValue).getText();
    }

    public void waitCityNameUpdated(String expectedText){
        $(currentCityValue).waitUntil(exactText(expectedText), 10000, 1000);
    }

    public void searchCity(String shortCityName){
        if ($(notThatCityButton).isDisplayed())
            $(notThatCityButton).click();
        $(currentCityValue).click();
        $(searchCityInput).setValue(shortCityName);
    }

    public void selectCityFromList(String fullCityName){
        $(By.xpath(String.format(expectedCityNameLocator, fullCityName))).click();
        $(okCityButton).click();
    }

    public Boolean nothingFoundPresented(){
        return $(nothingFoundMessage).exists();
    }
}


