package co.edu.unicauca.mvc;

import co.edu.unicauca.mvc.vistas.VtnLoginn;

/**
 * Clase principal de la aplicación MVC.
 * 
 * Esta clase sirve como punto de entrada para la aplicación, inicializando y mostrando
 * la ventana de login (VtnLoginn) al usuario.
 * 
 * @author SANTIAGO DORADO
 */
public class Aplicacion_capas_mvc {
    /**
     * Método principal (main) de la aplicación.
     * 
     * Este método crea una instancia de la ventana de login (VtnLoginn) y la hace visible.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        VtnLoginn objVtnLogin = new VtnLoginn();
        objVtnLogin.setVisible(true);
    }
}
