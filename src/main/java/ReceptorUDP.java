// Librerías
import java.net.*;

/**
 * Clase servidor que aceptará conexiones por UDP
 * @author Davibern
 * @version 1.0
 */
public class Servidor {

    // Atributos de clase
    private static final int PUERTO = 2000;

    /**
     * Constructor de clase
     */
    public Servidor() {

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Escucho");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }

}
