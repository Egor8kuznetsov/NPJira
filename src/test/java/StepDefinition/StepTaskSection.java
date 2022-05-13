package StepDefinition;

import Elements.TaskData;
import io.cucumber.java.ru.Когда;

import static junit.framework.TestCase.assertEquals;

public class StepTaskSection extends TaskData {
    @Когда("^перешли в раздел задачи")
    public void taskSection() {
        buttonProject.click();
        buttonTest.click();
        task.click();
        System.out.println("Количество задач: " + taskNumber.getText().substring(5));
        assertEquals("Ошибка при переходе к списку задач", examinationTwo.getText(), examinationTwo.getText());
    }
}