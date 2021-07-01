package inicios;

import java.util.Scanner;

public class Inicios {

    public static void main(String[] args) {       
        

package origine2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;



public class Origine2 {
    
    
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
//
//
//        // condicionales
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
        nombre = "Freddy";
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
        
        for(i=0; i < 10; ++i ){
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


//         array 
        String array[] = {"Freddy", "Alejandro", "Leal"};
        System.out.println( array[1] );
        for(String x : array){
            System.out.println( x );
        }
        
        String[][] array2d = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"},
        };
        System.out.println( array2d[0][1] );


        // ArrayList (Listas de python)
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int cont=0; cont<100; cont++){
            ar.add(cont);
        }
        System.out.println( ar.size() );
        
        for(int aux : ar){
            System.out.println(aux);
        }
        
        
//         Maps ( los diccionarios de python)
        Map<String, Object> diccionario = new HashMap();
        
        diccionario.put("nombre", "Freddy Leal");
        diccionario.put("edad", 32);
        
        System.out.println( diccionario.get("nombre") );
        
        edad = (int) diccionario.get("edad");
        System.out.println( edad );


        // Operaciones Matematicas 
        // + - * / %
        numero = 5;
        int x = (int) Math.pow(5, 2);
        System.out.println(x);
        int y = (int) Math.sqrt(x);
        System.out.println(y);
        
        System.out.println( Math.PI );
        System.out.println( Math.E );
        

        // operadores logicos
        // == != < > <= >=   .equals  
        // && ||
        
        if(true && true){
            System.out.println("Entro");
        } else {
            System.out.println("Es falso");
        }
        
        if(false || false){
            System.out.println("Entro");
        } else {
            System.out.println("Es falso");
        }
        
        // números aleatorios
        Random generadorNumeros = new Random();
        int aleatorio = 1 + generadorNumeros.nextInt(7);
        System.out.println( aleatorio );
        
        
        // fracciones de cadenas de string
        String holaMundo = "Hola Mundo";
        System.out.println( holaMundo.substring(3, 6) );
        int index = holaMundo.indexOf('a');
        letra = in.nextLine();
        
        if( holaMundo.contains( letra ) ){
            System.out.println("Si esta la letra");
        } else {
            System.out.println("No esta la letra");
        }
        

        // control de errores 
        int a = 1;
        int b = 0;
        int c;
        try{
            c = a / b;
        } catch( ArithmeticException e){
            System.out.println("No se puede dividir por cero.");
        }
//        
        try{
            int d = Integer.parseInt("1234123");
            System.out.println("El número es: " + d);
            c = a / b;
        } catch( NumberFormatException e){
            System.out.println("Esto no es un número.");
        } catch( ArithmeticException e){
            System.out.println("No se puede dividir por cero.");
        } finally {
            System.out.println("Esto se ejecuta siempre");
        }
        
        try{
            float as = Float.parseFloat("asdf");
        } catch( Exception e){
            System.out.println("Atrapa todo si algo sale mal.");
        }
        
        
        // funciones
        saludar("Freddy");
    }
    
    
    public static void saludar(String nombre){
        System.out.println("Hola " + nombre);
    }
    
    
}
