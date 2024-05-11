package com.keysafe.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickCommands {
    public static void clear() {
        // No funciona en IDE
            System.out.print("\033\143");
    };

    public static void exit() {
        clear();
        System.out.println("Hasta pronto 👋");
        System.exit(0);
    };

    public static Date parseDate(String date) {
        Date dateFormatted;
        try {
             dateFormatted = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(date);
        } catch (ParseException e) {
            dateFormatted = new Date();
        }
        return dateFormatted;
    };
}
