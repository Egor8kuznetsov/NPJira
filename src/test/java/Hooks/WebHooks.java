package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.time.Duration;

import static Elements.AutorizeData.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @BeforeAll
    public static void setWebDriverFormat() {

        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        Configuration.startMaximized = true;
        login.shouldBe(visible, Duration.ofSeconds(60)).click();
        login.sendKeys("ekuznecov");

        password.shouldBe(visible, Duration.ofSeconds(60)).click();
        password.sendKeys("123Qwerty");
        loginbutton.click();
    }

    @AfterAll
    public static void driverClose() { WebDriverRunner.closeWebDriver(); }

}
