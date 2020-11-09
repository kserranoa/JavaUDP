package JAVAUDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
            
            //Leer los paquetes
            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isw);
            
            //Escribir los paquetes
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            //Palabra a advinar
            final String palabra = "colombia";
            final String fin = "FIN";
            String respuesta = inicializar(palabra);
            String letra;
            
            do {
                bw.write(respuesta);
                bw.newLine();
                bw.flush();
                
                //Le solicita al cliente una letra
                letra = br.readLine();
                respuesta = actualizar(palabra, respuesta, letra.charAt(0));
            } while (respuesta != palabra);
            bw.write(fin);
            bw.newLine();
            bw.flush();            
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cliente connect");
    }
    
    static String inicializar (String palabra){
        String resultado = "";
        for (int i = 0; i < palabra.length(); i++) {
            resultado += "_";
        }
        return resultado;
    }
    
    static String actualizar (String palabra, String respuesta, char letra){
        String resultado = "";
        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == letra /*|| palabra.charArt(i) == respuesta.charAt(i)*/){
                resultado += palabra.charAt(i);
            } else {
                resultado += "_";
            }
        }
        return resultado;
    }
}