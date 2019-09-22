package ru.r5am.pageobjects;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class BasePage {

    public abstract void checkPageShow();
    static final Logger log = LogManager.getLogger();

}
