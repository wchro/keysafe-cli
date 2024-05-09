package com.keysafe.util;

public class QuickCommands {
    static void clear() {
        // No funciona en IDE
            System.out.print("\033\143");
    }

    static void exit() {
        clear();
        System.out.println("Hasta pronto 👋");
        System.exit(0);
    }
}
