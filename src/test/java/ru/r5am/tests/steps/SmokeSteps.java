package ru.r5am.tests.steps;


import io.qameta.allure.Step;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.Logger;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import static com.codeborne.selenide.Selenide.open;

import ru.r5am.configs.AppConfig;
import ru.r5am.pageobjects.StartPage;


public class SmokeSteps {

    private static final Logger log = LogManager.getLogger();
    private static final AppConfig config = ConfigFactory.create(AppConfig.class);

    @Step("Открыть стартовую страницу сайта")
    @Дано("Открыть стартовую страницу сайта")
    public void openHost() {
        open(config.testUrl());
        log.info("Открывается страница сайта: '{}'", config.testUrl());
    }

    @Step("Отображается стартовая страница")
    @Тогда("Отображается стартовая страница")
    public void checkStartPageShow() {
        StartPage startPage = new StartPage();
        startPage.checkPageShow();
        log.info("Страница '{}' сайта успешно отображена", config.testUrl());
    }

}
