
package cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuCliente {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        final String IP = "192.168.100.14";
        final int PUERTO = 8080;        
        
       try {
            Socket socket = new Socket(IP, PUERTO);

       System.out.println("Esperando server");
            //Leer los paquetes
            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isw);
            
            //Escribir los paquetes
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
       final String fin = "fin";
       String respuesta = "";
       Scanner entrada = new Scanner(System.in);
       
       while (respuesta != fin) {
           System.out.println("Esperando ");
           respuesta = br.readLine();
           
           if(!respuesta.equals(fin)) {
               
               System.out.println("Palabra hasta el momento");
               System.out.println(respuesta);
                System.out.println("Ingrese letra");
                String letra = entrada.nextLine();
           
                bw.write(letra);
                bw.newLine();
                bw.flush();
           
           }
       } 
               } catch (IOException ex) {
            Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
