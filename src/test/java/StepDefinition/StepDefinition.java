package StepDefinition;

import Hooks.WebHooks;
import io.cucumber.java.ru.Когда;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static Elements.AutorizeData.*;
import static Elements.BugData.*;
import static Elements.ProjectData.*;
import static Elements.TaskData.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertEquals;

public class StepDefinition extends WebHooks {
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

    @Когда("^перешли в раздел задачи")
        public void taskSection() {
        buttonProject.click();
        buttonTest.click();
        task.click();
        System.out.println("Количество задач: " + taskNumber.getText().substring(5));
        assertEquals("Ошибка при переходе к списку задач", examinationTwo.getText(),examinationTwo.getText());
    }
    @Когда("^проверяем статус и версию задачи")
        public void statusTask() {
        taskList.click();
        taskSearch.click();
        taskSearch1.shouldBe(visible, Duration.ofSeconds(60)).click();
        taskSearch2.sendKeys("TestSelenium");
        search.click();
        testSelenium.click();
        System.out.println(statusIn.getText());
        String fail = "В РАБОТЕ";
        assertEquals(statusIn.getText(), statusIn.getText(), fail);
        System.out.println(version.getText());
        String failTwo = "Version 2.0";
        assertEquals(version.getText(), version.getText(), failTwo);
    }
    @Когда("^создали новый баг")
        public void newBug() {
        create.click();
        clickBug.shouldBe(visible, Duration.ofSeconds(60)).click();
        clickBug.sendKeys("Ошибка");
        subject.shouldBe(visible, Duration.ofSeconds(60)).click();
        subject.sendKeys("Test_AT_2022_12");
        textClick.click();
        description.shouldBe(visible, Duration.ofSeconds(60)).click();
        description.sendKeys("Описание пробного теста");
        environment.click();
        tryut.shouldBe(visible,Duration.ofSeconds(60)).click();
        tryut.sendKeys("Окружение");
        clickCreate.click();

        buttonProject.click();
        buttonTest.click();
        switchFilter.click();
        createByMe.click();
        testBug12.click();
        String statusProject = "СДЕЛАТЬ";
        assertEquals(statusPr.getText(), statusProject);
        buisnessProcess.click();
        done.click();
        String statusProjectNew = "ГОТОВО";
        statusPr.shouldBe(visible, Duration.ofSeconds(60)).click();
        assertEquals(statusPr.getText(), statusProjectNew);

    }
}
