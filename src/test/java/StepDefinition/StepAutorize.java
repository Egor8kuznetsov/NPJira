package StepDefinition;

import io.cucumber.java.ru.Когда;

import java.time.Duration;

import static Elements.AutorizeData.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertEquals;

public class StepAutorize {
    @Когда("^авторизируемся")
        public void autorize() {
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        login.shouldBe(visible, Duration.ofSeconds(60)).click();
        login.sendKeys("ekuznecov");
        password.shouldBe(visible, Duration.ofSeconds(60)).click();
        password.sendKeys("123Qwerty");
        loginbutton.click();

        assertEquals("Ошибка при авторизации", examinationOne.getText(),examinationOne.getText());
    }





}
