package cn.itcast.day05.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LogTest.class.getName());
        logger.log(Level.WARNING, "Warning information");
        logger.log(Level.INFO, "Info information");
        logger.log(Level.CONFIG, "Config information");
        logger.log(Level.FINE, "Fine information");
    }
}
