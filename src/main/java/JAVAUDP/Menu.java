package JAVAUDP;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        String palabra = eligePalabra();
        char [ ] guiones = cambioGuiones(palabra);
        
        // Permite que el usuario ingrese las letras para adivinar la palabra
        boolean terminaJuego = false; // permite que el juego termine
        Scanner lectura = new Scanner(System.in);  //Solicita una letra al usuario 
        int intentos = 3;
       
        do{
            System.out.println("Te quedan " + intentos + " intentos");
            System.out.println(guiones);
            System.out.println("Introduce una letra: ");
            char letra = lectura.next().charAt(0); //toma la letra ingresada por el usuario
            boolean letraAcertada = false;
            // Revisa si la letra esta en la palabra
            for(int i = 0; i < palabra.length(); i++){
                if(palabra.charAt(i) == letra){ // si la letra esta en la palabra
                    guiones[i] = letra; //cambia el guion por la letra
                    letraAcertada = true;
                }
            }
            if(!letraAcertada){ // Si la letra no esta en la palabra 
                System.out.println("Esa letra no esta en la palabra. Ingresa otra.");
                -- intentos;
                if(intentos == 0 ) {
                    System.out.println("Has perdido. Se agotaron los intentos.");
                    terminaJuego = true; // Permite que el juego pare de ejecutarse
                }
            } else{
               boolean GanoJuego = !verificaGuiones(guiones); //verifica si ha ganado, si no hay ningun guion
               if(GanoJuego){
                   System.out.println("Has ganado el juego");
                   terminaJuego = true; // Permite que el juego pare de ejecutarse
               }
            }
        } while(!terminaJuego);
        
        lectura.close(); // Termina de pedir las letras porque ha ganado
      
    }
    
    // Metodo para generar la palabra 
    static String eligePalabra(){
        String [ ] listPalabras = {"vaca", "perro", "cabra", "mono"};
        Random random = new Random();
        int n = random.nextInt(listPalabras.length);
        return listPalabras[n];
    }
    
    //Metodo para cambiar palabra a guiones
    static char[ ] cambioGuiones(String palabra){
        
        int cantLetras = palabra.length();
        char [ ] guiones = new char[cantLetras];
        
        for(int i = 0; i < guiones.length; i++){
            guiones[i] = '_';
        }
        
        return guiones;
        
    }
    
    // Metodo que verifica si hay guiones en la palabra
    static boolean verificaGuiones(char[] array){
        for(char l: array){
            if(l == '_') return true;
        }
        return false;
    }

}
