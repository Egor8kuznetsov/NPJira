package StepDefinition;

import Elements.BugData;
import io.cucumber.java.ru.Когда;

import java.time.Duration;

import static Elements.TaskData.buttonProject;
import static Elements.TaskData.buttonTest;
import static com.codeborne.selenide.Condition.visible;
import static junit.framework.TestCase.assertEquals;

public class StepNewBug extends BugData {

    @Когда("^создали новый баг")
    public void newBug () {
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
        while (!statusPr.getText().equals("ГОТОВО")) {
            statusPr.getText();
        }
        assertEquals(statusPr.getText(), statusProjectNew);

    }
}
