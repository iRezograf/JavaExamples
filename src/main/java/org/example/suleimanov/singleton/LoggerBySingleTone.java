package org.example.suleimanov.singleton;

import java.util.Timer;

public class LoggerBySingleTone {

    private static LoggerBySingleTone loggerBySingleTone;
    private static String logInfo = "This is logFile: \n\n";

     public static LoggerBySingleTone getLoggerBySingleTone(){
//    public static synchronized LoggerBySingleTone getLoggerBySingleTone(){
        if (loggerBySingleTone == null){
            loggerBySingleTone = new LoggerBySingleTone();
        }
        return loggerBySingleTone;
    }
    private LoggerBySingleTone(){};

    public void writeLogInfo(String logInfo) {
        loggerBySingleTone.logInfo += logInfo + "\n";
    }

    public String readLogInfo() {
        return logInfo;
    }
}
