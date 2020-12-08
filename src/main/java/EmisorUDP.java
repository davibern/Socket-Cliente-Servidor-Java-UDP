import java.io.*;
import java.net.*;

/**
 * Clase servidor que genera mensajes vía UDP
 * @author Davibern
 * @version 1.0
 */
public class EmisorUDP {

    // Atributos de clase
    private static final int PUERTO = 1500;

    public static void main(String[] args) {

        // Se comprueba los argumentos
        if (args.length != 2) {
            System.err.println("uso: java EmisorUDP maquina mensaje");
        } else try {

            // Se crea el socket
            DatagramSocket socket = new DatagramSocket();

            // Construir la dirección del socket receptor
            InetAddress maquina = InetAddress.getByName(args[0]);

            // Crear el mensaje
            byte[] cadena = args[1].getBytes();
            DatagramPacket mensaje = new DatagramPacket(cadena, args[1].length(), maquina, PUERTO);

            // Enviar el mensaje
            socket.send(mensaje);

            // Cerrar el socket
            socket.close();

        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }

    }

}
