package com.keysafe.util;

import java.util.Scanner;
import com.keysafe.service.Session;


public class Menu {
    Session session;
    Scanner scanner = new Scanner(System.in);

    public Menu(Session session) {
        this.session = session;
    };

    // Menu (logged)
    public void showMenu() {
        QuickCommands.clear();
        System.out.println("🔒 KeySafe 🔑");
        System.out.println("Hola, " + session.user.getName() + "!\n");
        System.out.println("Menu");
        System.out.println("1. Ver credenciales");
        System.out.println("2. Añadir nueva credencial");
        System.out.println("0. Cerrar");
        System.out.print("\nSelecciona una opción: ");
        byte userChoice = scanner.nextByte();

        switch (userChoice) {
            case 1:
                // Show credentials
                break;
            case 2:
                QuickCommands.clear();
                System.out.println("➕ Añadir nueva credencial 🪪\n");
                System.out.print("Nombre: ");
                String name = scanner.next();
                System.out.print("URL: ");
                String site = scanner.next();
                System.out.print("Email: ");
                String email = scanner.next();
                System.out.print("Contraseña: ");
                String password = scanner.next();
                session.user.addCredential(name, email, password, site);
                System.out.println("\n✅ Guardado");
                break;
            case 0:
                QuickCommands.exit();
        }

    };

    // Login Menu
    public void loginMenu() {
        boolean loopMenu = true;
        QuickCommands.clear();
            System.out.println("Hola de nuevo 👋");
            while (loopMenu) {
                System.out.print("\n Email: ");
                String email = scanner.next();
                System.out.print(" Contraseña: ");
                String password = scanner.next();
                boolean loginStatus = session.login(email, password);
                if (loginStatus) return;
                System.out.println("\n⚠️ Nombre de usuario o contraseña incorrecta ⚠️\n");
                System.out.println("1. Intentar de nuevo\n");
                System.out.println("2. Regresar al menu principal\n");
                System.out.print("Selecciona una opcion: ");
                byte userChoice = scanner.nextByte();
                if (userChoice == 2) loopMenu = false;

            }

    };

    // Register Menu
    public void registerMenu() {
        QuickCommands.clear();
        System.out.println("📝Registro 📝");
        System.out.print("\n Email: ");
        String email = scanner.next();
        System.out.print(" Nombre: ");
        String name = scanner.next();
        System.out.print("Contraseña: ");
        String password = scanner.next();
        session.register(email, name, password);
    }

    // Guest Menu
    public void guestMenu() {
        QuickCommands.clear();
        System.out.println("🔐 KeySafe CLI v1.0 🔐");
        System.out.println("\nMenu");
        System.out.println("1) Iniciar Sesión");
        System.out.println("2) Registro");
        System.out.println("\n0) Cerrar app");
        System.out.print("\nSelecciona una opción: ");
        byte userChoice = scanner.nextByte();

        switch (userChoice) {
            case 1 :
                loginMenu();
                break;
            case 2:
                registerMenu();
                break;
            case 0:
                QuickCommands.exit();
            default:
                System.out.println("Opción invalida");

        }


    };
}
