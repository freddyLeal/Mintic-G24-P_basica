package hotelcalifornia24;

import clases.Holder;
import clases.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import memory.Write;
import view.View;



public class HotelCalifornia24 {
    
    public static void main(String[] args) {
        
        View view = new View();
        view.show();
        
//        int option, roomType;
//        boolean firstTime = true;
//        boolean runSowfware = true;
//        Scanner sc = new Scanner(System.in);
//        
//        File f = new File("backup");
//        if( f.exists() ){
//            try {
//                FileInputStream fis = new FileInputStream(f);
//                ObjectInputStream ois = new ObjectInputStream( fis );
//                Hotel.setHolder( (Holder) ois.readObject() );
//            } catch (Exception ex) {
//                System.out.println("Error al leer el archivo");
//            }
//        }
//        
//        
//        while(runSowfware){
//            if( firstTime ){
//                firstTime = false;
//            } else {
//                System.out.println();
//                System.out.println("Presione enter para continuar");
//                new Scanner(System.in).nextLine();
//            }
//      
//            System.out.println("Opciones:\n1.Mostrar detalles de las habitaciones\n2.Mostrar disponibilidad de habitaciones \n3.Reservar\n4.Ordenar comida\n5.Liberar habitación\n6.Salir\n");
//            System.out.print("Opción: ");
//            option = sc.nextInt();
//            switch(option){
//                case 1: 
//                    System.out.println("\nSeleccione una habitación :\n1.Doble lujosa \n2.Doble sencilla \n3.Lujosa \n4.Sencilla\n");
//                    System.out.print("Opción: ");
//                    roomType = sc.nextInt();
//                    Hotel.featuresRoom(roomType);
//                    break;
//                case 2:
//                    System.out.println("\nSeleccione una habitación :\n1.Doble lujosa \n2.Doble sencilla \n3.Lujosa \n4.Sencilla\n");
//                    System.out.print("Opción: "); 
//                    roomType = sc.nextInt();
//                    Hotel.getAvailableRooms(roomType);
//                    break;
//                case 3:
//                    System.out.println("\nSeleccione una habitación :\n1.Doble lujosa \n2.Doble sencilla \n3.Lujosa \n4.Sencilla\n");
//                    System.out.print("Opción: ");
//                    roomType = sc.nextInt();
//                    Hotel.bookRoom(roomType);                     
//                    break;
//                case 4:
//                    System.out.print("Número de habitación: ");
//                    roomType = sc.nextInt();
//                    if(roomType>60)
//                        System.out.println("La habitación no existe");
//                    else if(roomType>40)
//                        Hotel.roomService(roomType-41, 4);
//                    else if(roomType>30)
//                        Hotel.roomService(roomType-31, 3);
//                    else if(roomType>10)
//                        Hotel.roomService(roomType-11, 2);
//                    else if(roomType>0)
//                        Hotel.roomService(roomType-1, 1);
//                    else
//                        System.out.println("La habitación no existe");
//                        break;
//                case 5:                 
//                    System.out.print("Número de habitación: ");
//                    roomType = sc.nextInt();
//                    if(roomType>60)
//                        System.out.println("La habitación no existe");
//                    else if(roomType>40)
//                        Hotel.deallocateRoom(roomType-41,4);
//                    else if(roomType>30)
//                        Hotel.deallocateRoom(roomType-31,3);
//                    else if(roomType>10)
//                        Hotel.deallocateRoom(roomType-11,2);
//                    else if(roomType>0)
//                        Hotel.deallocateRoom(roomType-1,1);
//                    else
//                        System.out.println("La habitación no existe");
//                    break;
//                case 6:
//                    runSowfware = false;
//                    break;
//            }
//        }          
//        
//        Write write = new Write( Hotel.getHolder() );
//        Thread t = new Thread( write );
//        t.start();
    }
    
    
}
