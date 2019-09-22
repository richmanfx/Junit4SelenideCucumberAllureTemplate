package ru.r5am.pageobjects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class StartPage extends BasePage {

    /**
     * Проверить отображение стартовой страницы
     */
    @Override
    @Step("Проверить отображение стартовой страницы")
    public void checkPageShow() {
        String logo = "//h1[contains(string(),'R5AM')]";
        try {
            $(By.xpath(logo)).shouldBe(visible);
            log.debug("Стартовая страница удачно отобразилась");
        } catch (NoSuchElementException ex) {
            log.error("Стартовая страница не отобразилась: '{}'", ex.toString());
            assert false;
        }
    }

}
