package StepDefinition;


import Elements.ProjectData;
import io.cucumber.java.ru.Когда;

import java.time.Duration;


import static com.codeborne.selenide.Condition.visible;
import static junit.framework.TestCase.assertEquals;

public class StepStatusTask extends ProjectData {
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
}
