/* PROGRAMACION DE APLICACIONES Y SERVICIOS PARA LA NUBE

   Simulación básica de mi proyecto final KeySafe en CLI

   ⚠️ No recomiendo utilizarlo para guardar datos reales,
   no se han implementado medidas de seguridad basicas. ⚠️

   Realizado por Wilson Chavarria (GitHub: @wchro)
*/


package com.keysafe;

import com.keysafe.service.Session;
import com.keysafe.util.Database;
import com.keysafe.util.Menu;


public class KeySafe {
    static Boolean run = true;
    public static Database db = new Database("keysafe.db");

    public static void main(String[] args) {

        Session session = new Session();
        Menu menu = new Menu(session);
        while (run) {
            if (session.isLogged()) {
                menu.showMenu();
            } else {
                menu.guestMenu();
            }
        }
    };
}