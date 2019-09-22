package ru.r5am.tests;


import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import org.apache.logging.log4j.Logger;
import org.aeonbits.owner.ConfigFactory;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;

import ru.r5am.configs.AppConfig;


/**
 * Запускатель тестов
 * Название класса должно иметь окончание Test, иначе тесты не будут запускаться.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ru.r5am.tests"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
)
public class CucumberRunnerTest {

    protected CucumberRunnerTest() {}

    private static final Logger log = LogManager.getLogger();
    private static final AppConfig config = ConfigFactory.create(AppConfig.class);

    /**
     * Sets Selenide parameters
     */
    @BeforeClass
    public static void selenideSetup() {

        // Browser parameters
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.startMaximized = true;

        // Do not take screenshots using Selenide
        Configuration.screenshots = false;

        // Timeout to tests fail
        Configuration.timeout = 1000 * config.failTestTimeout();     // From seconds to milliseconds

        // Для работы через Selenium Grid
        log.info("remoteBrowserFlag: {}", config.remoteBrowser());
        if (config.remoteBrowser()) {

            String remoteSeleniumHub = config.remoteSeleniumHub();
            log.info("Remote Selenium Hub: {}", config.remoteSeleniumHub());

            String remoteSeleniumHubPort = config.remoteSeleniumHubPort();
            log.info("Remote port of Selenium Hub: {}", remoteSeleniumHubPort);

            Configuration.remote = String.format("http://%s:%s/wd/hub", remoteSeleniumHub, remoteSeleniumHubPort);
            Configuration.browserCapabilities.setCapability("enableVNC", true);
        }

    }

}
