import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCityTest {
    MainPage mainPage = new MainPage();

    @ParameterizedTest
    @CsvFileSource(resources = "/cityData.csv", numLinesToSkip = 1, delimiter = ';')
    public void SetCityPositiveTest(String inputCityName, String readableCityName, String fullCityName) {
        mainPage.searchCity(inputCityName);
        mainPage.selectCityFromList(fullCityName);
        mainPage.waitCityNameUpdated(readableCityName);
        assertEquals(mainPage.getCurrentCityName(), readableCityName,
                    "Wrong city name: " + mainPage.getCurrentCityName());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "dgsdfg",
            "%@#!^&*()_+<>?|~",
            "MOCKBA",
            "SELECT * FROM products WHERE category = 'Gifts' OR 1=1--' AND released = 1"
    })
    public void SetCityNegativeTest(String inputCityName) {
        mainPage.searchCity(inputCityName);
            assertTrue(mainPage.nothingFoundPresented());
    }
}
