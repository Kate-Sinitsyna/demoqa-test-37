import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {
    static void setConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //открыть главную страницу
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").setValue("selenide").pressEnter();
        //кликнуть на первый репозиторий из списка
        $$("['data-testid'='results-list']").first().$("a").click();
        //проверка: заголовок selenide/selenide

    }

    @Test
    void findExampleForJunit5InSoftAssertions() {
        //Открыть главную страницу selenide в gitHub
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедится, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").$$("li").findBy(text("Soft assertions")).$("a").click();


       // $(".wiki-rightbar").$("ul").$$("li").findBy(text("Soft assertions")).$("a").click();
       // $("div.d-flex.flex-items-start").shouldHave(text("SoftAssertions"));
      //  $("a[href=/selenide/selenide/wiki/SoftAssertions]").click();
       // $(".Box-row.wiki-more-pages-link").$("button[type=button]").click();
       // $(byText("SoftAssertions")).shouldBe(visible);

        //Открыть страницу SoftAssertions
       // $(".Truncate").$("a").click();
        //$(".markdown-heading").shouldHave(text("How to soft assert using Selenide"));
        sleep(5000);
        //Проверить, что внутри есть пример кода для JUnit5

    }
}


//$("[placeholder='Google Chrome']").click();
//$("[placeholder=Google]").click();