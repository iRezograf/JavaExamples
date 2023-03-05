package org.example.suleimanov.singleton;


public class SingleTonEx {
    public static void main(String[] args) {

//        видим одинаковый хэш код
        System.out.println(LoggerBySingleTone
                .getLoggerBySingleTone()
                .toString() );
        System.out.println(LoggerBySingleTone
                .getLoggerBySingleTone()
                .toString() );
        System.out.println(LoggerBySingleTone
                .getLoggerBySingleTone()
                .toString() );

        LoggerBySingleTone.getLoggerBySingleTone().writeLogInfo("first string");
        LoggerBySingleTone.getLoggerBySingleTone().writeLogInfo("second string");
        LoggerBySingleTone.getLoggerBySingleTone().writeLogInfo("firth string");

        String log = LoggerBySingleTone.getLoggerBySingleTone().readLogInfo();
        System.out.println(log);





    }


}
