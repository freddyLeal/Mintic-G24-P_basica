package inicios;

import java.util.Scanner;

public class Inicios {

    public static void main(String[] args) {       
        // Entradas y salidas
        String nombre;
        
        System.out.println("Hola Mundo!!!");
       
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        nombre = in.nextLine();
        System.out.println("Hola " + nombre);
        
        System.out.print("Ingrese su edad: ");
        int edad = in.nextInt();
        System.out.println("Su edad es " + edad);
        
        System.out.print("Ingrese un número ramdon: ");
        float numero = in.nextFloat();
        System.out.println("Su número es " + numero);


        // condicionales
        boolean es_verdad = false;
        boolean segunda_pregunta = false;
        if( es_verdad ){
            System.out.println("La primera es verdad");
        } else if( segunda_pregunta ){
            System.out.println("La segunda es verdad");
        } else {
            System.err.println("Las dos son mentira");
        }

        // switch
        int i = 2;
        switch( i ){
            case 0:
                System.out.println("Es cero");
                break;
            case 1:
                System.out.println("Es uno");
                break;
            case 2:
                System.out.println("Es dos");
                break;
            default:
                System.out.println("No es ni cero, ni uno, ni dos");
        }
        
        String letra = "b";
        switch( letra ){
            case "a":
                System.out.println("es a.");
                break;
            case "b":
                System.out.println("es b.");
                break;
            default:
                System.out.println("No es a ni b.");
        }
        
        

        // manejo de string
        String nombre = "Freddy";
        System.out.println( nombre.toLowerCase() );
        System.out.println( nombre.toUpperCase() );
        
        String password = "contraseña";
        if( password.equals("contraseña") ){
            System.out.println("Usuario autorizado");
        } else {
            System.out.println("Usuario NO autorizado");
        }
        
        
        
        // Ciclos FOR
//        for item in range(10):
//            print( item )
        
        for(int i=0; i < 10; ++i ){
//            i++; - Este se ejecuta después de pasar la linea
//            ++i; - Este se ejecuta antes de pasar la linea
            System.out.println(i);
        }
        
//        for caracter in "palabras":
//            print(caracter)
        
        String palabra = "Palabras pero muchas palabras";
        for(char caracter : palabra.toCharArray()){
            System.out.println(caracter);
        }
        
        // while
        int contador = 0;
        while( contador <= 10 ){
            System.out.println(contador);
            contador++;
//            break;
//            continue;
        }
        
        // do - while
        int numero_2 = 15;
        do {
            System.out.println(numero_2);
            numero_2++;
        } while ( numero_2 <= 20);
        
        
    }
    
}


