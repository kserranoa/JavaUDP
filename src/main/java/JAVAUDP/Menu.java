package JAVAUDP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    public static void main(String[] args) throws SocketException {
        final int PUERTO = 8080;
        ServerSocket socketServer = null;
        Socket socket = null;
        
        try {
            socketServer = new ServerSocket(PUERTO);
            System.out.println("Server wait");
            socket = socketServer.accept();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cliente connect");

    }
}