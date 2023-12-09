package com.petshop.ambrozziospetshop.domain.utils.singleton;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;

public class LoggerUtil {
    private static LoggerUtil instance;
    private final File debugFile;
    private final File warnFile;
    private final File errorFile;

    private LoggerUtil() {
        debugFile = new File("debug.log");
        warnFile = new File("warn.log");
        errorFile = new File("error.log");
    }

    public static LoggerUtil getInstance() {
        if (instance == null) {
            LoggerUtil.instance = new LoggerUtil();
        }

        return LoggerUtil.instance;
    }

    @SneakyThrows
    public void debug(String message) {
        FileWriter fileWriter = new FileWriter(debugFile, true);

        fileWriter.write("DEBUG -> [" + new Date() + "]: "+ message);
        fileWriter.write("\n");

        fileWriter.close();
    }

    @SneakyThrows
    public void warn(String message)  {
        FileWriter fileWriter = new FileWriter(warnFile, true);

        fileWriter.write("WARN -> [" + new Date() + "]: "+ message);
        fileWriter.write("\n");

        fileWriter.close();
    }

    @SneakyThrows
    public void error(String message)  {
        FileWriter fileWriter = new FileWriter(errorFile, true);

        fileWriter.write("ERROR -> [" + new Date() + "]: "+ message);
        fileWriter.write("\n");

        fileWriter.close();
    }
}
