package gitHubAllure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем страницу")
    public void openThePage() {
        open("https://github.com");

    }

    @Step("Ищем репозиторий {Search}")
    public void lookingRepository(String Search) {
        $(".header-search-input").setValue(Search).submit();

    }

    @Step("Переходим в репозиторий {repository}")
    public void goRepository(String repository) {
        $(By.linkText(repository)).click();

    }

    @Step("Открываем таб Issues в репозитории")
    public void openIssuesTabRepository() {
        $(withText("Issues")).click();

    }

    @Step("Проверяем что Issues с номером {number} существует")
    public void checkIssuesNumberExists(int number) {
        $(withText("#" + number)).should(Condition.visible);

    }
}
