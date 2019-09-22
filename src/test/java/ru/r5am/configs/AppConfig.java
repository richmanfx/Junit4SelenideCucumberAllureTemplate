package ru.r5am.configs;


import org.aeonbits.owner.Config;


@Config.Sources({"file:app.config"})
public interface AppConfig extends Config {

    String testUrl();

    @DefaultValue("true")
    Boolean ciServerFlag();

    @DefaultValue("4")
    int failTestTimeout();

    @DefaultValue("false")
    Boolean remoteBrowser();

    @DefaultValue("127.0.0.1")
    String remoteSeleniumHub();

    @DefaultValue("4444")
    String remoteSeleniumHubPort();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("0")
    int eyesViewTimeout();

    @DefaultValue("100")
    int uiActionSlowdownTime();

    @DefaultValue("false")
    Boolean uiActionSlowdownSwitch();

    @DefaultValue("100")
    int uiActionInterval();

    @DefaultValue("#FFFF00")
    String uiFlashColor();

    @DefaultValue("1")
    int uiFlashCount();

    @DefaultValue("false")
    Boolean uiFlashSwitch();

}
