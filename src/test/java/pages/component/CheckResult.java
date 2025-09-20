package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResult {
    private SelenideElement checkResult =  $(".table-responsive");
    private SelenideElement modalAppear = $(".modal-content");

    public CheckResult checkFormAppears(){
        modalAppear.shouldBe(visible);

        return this;
    }
    public CheckResult checkFormNotAppears(){
        modalAppear.shouldNotBe(visible);

        return this;
    }
    public CheckResult checkResult(String key, String value){
        checkResult.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
