import static com.codeborne.selenide.Selenide.open;

public class CommonPage {


    public static void goToUrl(String url) {
        open(url);
    }


}
