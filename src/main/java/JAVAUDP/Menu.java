package JAVAUDP;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        //Palabras que el sistema puede escoger aleatoriamente
        String [] palabras = {"perro", "mono", "gato"};
        
        //Selecionar palabra de manera aleatoria
        Random a = new Random();
        int n = a.nextInt(palabras.length);
        String opcionPalabra = palabras[n];
        //System.out.println(opcionPalabra);
        
        //Contar la cantidad de letras que tiene la palabra
        int cantidadLetras = opcionPalabra.length();
        
        //Recorrer las letras que contiene la palabra selecionada
        char [] letrasPalabra = new char[cantidadLetras];        
        
        //Convertir la cantidad de letras en guiones bajos
        for (int i = 0; i < letrasPalabra.length; i++) {            
            letrasPalabra[i] = '_';            
        }
        
        //Crear variable para deterrminar si el juego esta terminado o no
        boolean gameover = false;
        
        //Solicitar una letra al usuario
        Scanner entrada = new Scanner(System.in);
        
        //Hacer un ciclo para ver si la letra ingresada por el usuairo esta dentro de la palabra escogida
        do {
            System.out.println("Introduce una letra: ");
            //Usar solo la primera letra ingresada por el usuario
            char letra = entrada.next().charAt(0);
            
            //Crear una variable para ver si acierto letra
            boolean acierto = false;
            
            for (int i = 0; i < cantidadLetras; i++) {
                if (opcionPalabra.charAt(i) == letra) {
                    letrasPalabra[i] = letra;
                    acierto = true;
                }
            }
        } while (gameover);
        
    }

}
