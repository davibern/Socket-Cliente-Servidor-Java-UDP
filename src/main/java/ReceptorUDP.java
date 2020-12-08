// Librerías
import java.io.IOException;
import java.net.*;

/**
 * Clase servidor que aceptará conexiones por UDP
 * @author Davibern
 * @version 1.0
 */
public class ReceptorUDP {

    // Atributos de clase
    private static final int PUERTO = 1500;

    public static void main(String[] args) {

        if (args.length != 0) {
            System.err.println("Uso: java ReceptorUDP");
        } else try {

            // Se crea el socket
            DatagramSocket socket = new DatagramSocket(PUERTO);

            // Crear el espacio para los mensajes
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);

            System.out.println("Esperando mensajes...");

            while(true) {
                // Se recibe y se muestra el mensaje
                socket.receive(mensaje);
                String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Mensaje recibido: " + datos);
            }


        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Socket: " + e.getMessage());
        }

    }

}
