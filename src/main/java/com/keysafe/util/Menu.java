package com.keysafe.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.keysafe.model.Credential;
import com.keysafe.model.Ticket;
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
        System.out.println("Menu");
        System.out.println("1. Ver credenciales");
        System.out.println("2. Añadir nueva credencial");
        System.out.println("3. Tickets");
        System.out.println("0. Cerrar");
        System.out.print("\nSelecciona una opción: ");
        byte userChoice = scanner.nextByte();


        switch (userChoice) {
            case 1:
                ArrayList<Credential> credentials = session.user.getCredentials();
                QuickCommands.clear();
                System.out.println("🔒 Credenciales: %s 🔒\n".formatted(credentials.size()));
                for (int i = 0; i < credentials.size(); i++) {
                    Credential credential = credentials.get(i);
                    System.out.println("%s. %s".formatted(i + 1, credential.getName()));
                }

                boolean credentialsLoop = true;
                while (credentialsLoop) {
                    System.out.print("\nSelecciona una credencial (0 para salir): ");
                    int userCredential = scanner.nextInt();

                    if (userCredential == 0) {
                        credentialsLoop = false;
                        return;
                    };

                    Credential selectedCredential = credentials.get(userCredential - 1);

                    if (selectedCredential.getCategory().equals("login")) {
                        selectedCredential.getLogin().showInfo();
                    }

                    if (selectedCredential.getCategory().equals("card")) {
                        selectedCredential.getCard().showInfo();
                    }
                }
                break;
            case 2:
                QuickCommands.clear();
                System.out.println("➕ Añadir nueva credencial 🪪\n");
                System.out.print("Nombre: ");
                String name = scanner.next();
                boolean askUser = true;
                String type = null;
                while (askUser) {
                    System.out.print("Tipo (login/card): ");
                    type = scanner.next().toLowerCase();
                    if (type.equals("login") || type.equals("card")) askUser = false;
                    else System.out.println("Opción invalida");
                };
                switch (type) {
                    case "login":
                        System.out.print("URL: ");
                        String site = scanner.next();
                        System.out.print("Email: ");
                        String email = scanner.next();
                        System.out.print("Contraseña: ");
                        String password = scanner.next();
                        session.user.addCredential(name, email, password, site);
                        System.out.println("\n✅ Guardado");
                        break;
                    case "card":
                        System.out.print("Tipo (VISA, MasterCard...): ");
                        String brand = scanner.next();
                        System.out.print("Propietario: ");
                        String cardHolder = scanner.next();
                        System.out.print("Número: ");
                        String number = scanner.next();
                        System.out.print("Mes de expiración: ");
                        String expMonth = scanner.next();
                        System.out.print("Año de expiración: ");
                        String expYear = scanner.next();
                        System.out.print("CVV: ");
                        String cvv = scanner.next();
                        session.user.addCard(name, brand, cardHolder, number, expMonth, expYear, cvv);
                        System.out.println("\n✅ Guardada");
                        break;
                }
                break;
            case 3:
                QuickCommands.clear();
                System.out.println("✉️ Tickets ✉️");
                System.out.println("\n1. Ver mis tickets");
                System.out.println("2. Abrir ticket");
                System.out.println("0. Cerrar");
                System.out.print("\nSelecciona una opción: ");
                int userTicketChoice = scanner.nextInt();
                switch (userTicketChoice) {
                    case 1:
                        // Ver tickets
                        ArrayList<Ticket> tickets = session.user.getTickets();
                        QuickCommands.clear();
                        System.out.println("🔒 Tickets: %s 🔒\n".formatted(tickets.size()));
                        for (int i = 0; i < tickets.size(); i++) {
                            Ticket ticket = tickets.get(i);
                            System.out.println("%s. %s".formatted(i + 1, ticket.getTitle()));
                        }

                        boolean ticketsLoop = true;
                        while (ticketsLoop) {
                            System.out.print("\nSelecciona un ticket (0 para salir): ");
                            int userTicket = scanner.nextInt();

                            if (userTicket == 0) {
                                ticketsLoop = false;
                                return;
                            };

                            Ticket selectedTicket = tickets.get(userTicket - 1);

                                selectedTicket.showInfo();

                        }
                        break;
                    case 2:
                        // Abrir ticket
                        QuickCommands.clear();
                        System.out.println("📝 Abrir nuevo ticket 📝");
                        System.out.print("\nTitulo: ");
                        String title = scanner.next();
                        System.out.print("Descripción: ");
                        String body = scanner.next();
                        session.user.addTicket(title, body);
                        System.out.println("\nTicket abierto ✅");
                        break;
                    case 0:

                }
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
