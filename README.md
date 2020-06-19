**Used technologies:**
- Java 8
- JUnit 5
- Selenide 5.12
- Maven 3.3.3
- Allure 2.13
- Surefire-plugin 3.0

**Run all tests command:**
- using Chrome browser by default: mvn clean test
- using Firefox browser: mvn clean test -Dselenide.browser="firefox"

**Run allure reporting locally:**

*allure server is needed to be installed*

on Windows: run {project-root}/allure.bat

**Task:**
1. Открыть сайт sportmaster.ru
2. В левом верхнем углу кликнуть на название города
3. В открывшемся окошке введите название города 'Липецк'
4. Из выпадашки выберите 'г Липецк, Липецкая обл' Нажмите кнопку 'Ок'  
- Проверьте что в левом верхнем углу отображается город 'Липецк'

**Tests:**

*Data-providers are used for list of cases*

Positive cases:
- Scenario: Find and select not-default city using city-search 
- Expected result: chosen city is used.

Negative cases:
- use invalid city name;
- use latin letters instead of Cyrillic;
- use special characters ;
- use SQL-injection in search;
Expected result: string that city was not found
