package hotelcalifornia25;

import hotel.Holder;
import hotel.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import memory.Write;




public class HotelCalifornia25 {

    public static void main(String[] args) {
        boolean runSowtware = true;
        boolean firstTime = true;
        Scanner in = new Scanner( System.in );
        int option;
        int roomType;
        int roomNumber;
        
        
        File f = new File("backup");
        if( f.exists() ){
            try {
                FileInputStream fis = new FileInputStream( f );
                ObjectInputStream ois = new ObjectInputStream( fis );
                Hotel.holder = (Holder) ois.readObject();
            } catch (Exception e) {
                System.out.println("No se pudo cargar el archivo.");
            }
            
        }
        
        
        while( runSowtware ){
            
            if( firstTime ){
                firstTime = false;
            } else {
                System.out.println("");
                System.out.print("Presione Enter para continuar");
                new Scanner(System.in).nextLine();
                System.out.println("");
            }
            
            System.out.println("Menú");
            System.out.println("1. Ver habitaciones disponibles");
            System.out.println("2. Asignar habitación");
            System.out.println("3. Liberar habitación");
            System.out.println("4. Ordenar Comida");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            option = in.nextInt();
            
            switch( option ){
                case 1:
                    System.out.println("\nTipo de habitación:\n1. Doble de lujo\n2. Doble sencilla\n3. De lujo\n4. Sencilla");
                    System.out.print("Opción: ");
                    roomType = in.nextInt();
                    Hotel.getAvailableRooms( roomType );
                    break;
                case 2:
                    System.out.println("\nTipo de habitación:\n1. Doble de lujo\n2. Doble sencilla\n3. De lujo\n4. Sencilla");
                    System.out.print("Opción: ");
                    roomType = in.nextInt();
                    Hotel.bookingRoom( roomType );
                    break;
                case 3:
                    System.out.print("Número de habitación: ");
                    roomNumber = in.nextInt();
                    roomType = 0;
                    if( roomNumber > 60 ){
                        System.out.println("La habitación no existe");
                    } else if( roomNumber > 40 ){
                        roomType = 4;
                    } else if( roomNumber > 21 ){
                        roomType = 3;
                    } else if( roomNumber > 11 ){
                        roomType = 2;
                    } else if( roomNumber >= 1 ){
                        roomType = 1;
                    } else {
                        System.out.println("La habitación no existe");
                    }
                    if( roomType != 0)
                        Hotel.deallocateRoom(roomNumber, roomType);
                    break;
                case 4:
                    System.out.print("Número de habitación: ");
                    roomNumber = in.nextInt();
                    roomType = 0;
                    if( roomNumber > 60 ){
                        System.out.println("La habitación no existe");
                    } else if( roomNumber > 40 ){
                        roomType = 4;
                    } else if( roomNumber > 21 ){
                        roomType = 3;
                    } else if( roomNumber > 11 ){
                        roomType = 2;
                    } else if( roomNumber >= 1 ){
                        roomType = 1;
                    } else {
                        System.out.println("La habitación no existe");
                    }
                    if( roomType != 0)
                        Hotel.orderFood(roomNumber, roomType);
                    break;
                case 5:
                    runSowtware = false;
            }
        }
            
        Write write = new Write( Hotel.holder );
        Thread t = new Thread( write );
        t.start();
    }
    
}
