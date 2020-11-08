
package cliente;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuCliente {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        final String IP = "192.168.100.14";
        final int PUERTO = 8080;
        
        
       try {
            Socket socket = new Socket(IP, PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
