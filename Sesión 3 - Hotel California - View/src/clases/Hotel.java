
package clases;

import java.util.ArrayList;
import java.util.Scanner;


public class Hotel {
   
    private static Holder holder = new Holder();    
    
    
    public static Holder getHolder(){
        return holder;
    }
    
    public static void setHolder(Holder inputHolder){
        holder = inputHolder;
    }
    
    
    
    
    
    public static ArrayList<String> getAvailableRooms(int roomType){
        ArrayList<String> data = new ArrayList();
        int j, count=0;
        String habitaciones = "";
        switch (roomType) {
            case 1:
                for(j=0;j<holder.luxury_double_room.length;j++){
                    if(holder.luxury_double_room[j]==null){
                        data.add( (j+1) + ". Doble de Lujo" );
                    } else {
                        data.add( (j+1) + ". Ocupado" );
                    }
                    count++;
                }
                break;
            case 2:
                for(j=0;j < holder.single_double_room.length;j++) {
                    if(holder.single_double_room[j]==null){
                        data.add( (j+11) + " Doble" );
                    } else {
                        data.add( (j+11) + " Ocupado" );
                    }
                    count++;
                }
                break;
            case 3:
                for(j=0;j<holder.luxury_simple_room.length;j++) {
                    if(holder.luxury_simple_room[j]==null){
                        data.add( (j+21) + " Simple De lujo" );
                    } else {
                        data.add( (j+21) + " Ocupado" );
                    }
                    count++;
                }
                break;
            case 4:
                for(j=0;j<holder.single_simple_room.length;j++) {
                    if(holder.single_simple_room[j]==null){
                        data.add( (j+41) + " Sencilla" );
                    } else {
                        data.add( (j+41) + " Ocupado" );
                    }
                    count++;
                        
                }
                break;
            default:
                System.out.println("Escriba una opción valida");
                break;
        }
        if( habitaciones.length() > 1){
            habitaciones = habitaciones.substring(0, habitaciones.length()-1);
        }
        return data;
    }
    
    public static void bookRoomFromView(Room room, int roomType, int realNumberRoom){
        switch( roomType ){
            case 1:
                holder.luxury_double_room[ realNumberRoom ] = (DoubleRoom) room;
                break;
            case 2:
                holder.single_double_room[ realNumberRoom ] = (DoubleRoom) room;
                break;
            case 3:
                holder.luxury_simple_room[ realNumberRoom ] = room;
                break;
            case 4:
                holder.single_simple_room[ realNumberRoom ] = room;
                break;
        }
    }
    
    public static void bookRoom(int roomType, int roomNumber){
        Scanner sc = new Scanner(System.in);
        
        switch( roomType ){
            case 1: 
                if( holder.luxury_double_room[roomNumber] == null ){
                    requestRoomData(roomType, roomNumber);
                } else {
                    System.out.println("No esta disponible");
                }
                break;
            case 2: 
                if( holder.single_double_room[roomNumber] == null ){
                    requestRoomData(roomType, roomNumber);
                } else {
                    System.out.println("No esta disponible");
                }
                break;
            case 3: 
                if( holder.luxury_simple_room[roomNumber] == null ){
                    requestRoomData(roomType, roomNumber);
                } else {
                    System.out.println("No esta disponible");
                }
                break;
            case 4: 
                if( holder.single_simple_room[roomNumber] == null ){
                    requestRoomData(roomType, roomNumber);
                } else {
                    System.out.println("No esta disponible");
                }
                break;            
        }
    }
    
    
    
    private static void requestRoomData(int roomType, int realNumberRoom){
        Scanner sc = new Scanner(System.in);
        String name, contact, gender;
        double price;
        int nights;
        String name2=null, contact2=null, gender2=null;
        DoubleRoom doubleRoom = null;
        Room room = null;
        
        System.out.print("Ingrese el precio por noche: ");
        price = sc.nextDouble();
        System.out.print("Ingrese el número de noches: ");
        nights = sc.nextInt();
        
        System.out.print("Ingrese el nombre completo: ");
        name = sc.next();
        System.out.print("Ingrese el contacto: ");
        contact = sc.next();
        System.out.print("Ingrese el genero: ");
        gender = sc.next();
        
        // si es habitación doble
        if( roomType == 1 || roomType == 2 ){
            System.out.println("\nDatos segunda persona:");
            System.out.print("Ingrese el nombre completo: ");
            name2 = sc.next();
            System.out.print("Ingrese el contacto: ");
            contact2 = sc.next();
            System.out.print("Ingrese el genero: ");
            gender2 = sc.next();
        }
        
        switch( roomType ){
            case 1:
                doubleRoom = new DoubleRoom(name, contact, gender, price, nights, name2, contact2, gender2);
                holder.luxury_double_room[ realNumberRoom ] = doubleRoom;
                break;
            case 2:
                doubleRoom = new DoubleRoom(name, contact, gender, price, nights, name2, contact2, gender2);
                holder.single_double_room[ realNumberRoom ] = doubleRoom;
                break;
            case 3:
                room = new Room(name, contact, gender, price, nights);
                holder.luxury_simple_room[ realNumberRoom ] = room;
                break;
            case 4:
                room = new Room(name, contact, gender, price, nights);
                holder.single_simple_room[ realNumberRoom ] = room;
                break;
            default:
                System.out.println("Opción no valida");
        }
        
        
        
    }
    
    
        
    public static void deallocateRoom(int realRoomNumber, int roomType){
        
        switch(roomType){
            case 1:
                if( holder.luxury_double_room[realRoomNumber] == null ){
                    System.out.println("La habitación esta vacía.");
                } else {
                    if( generateInvoice(realRoomNumber, roomType) ) {
                        holder.luxury_double_room[realRoomNumber] = null;
                        System.out.println("Habitación facturada y vacía.");
                    } else {
                        System.out.println("No se logro generar la factura.");
                    }
                }
                break;
            // TODO: Programar los otros casos
        }
        
    }
    
    
    private static boolean generateInvoice(int realRoomNumber, int roomType){
        DoubleRoom room = holder.luxury_double_room[realRoomNumber];
        
        System.out.println("************\nFactura\n************\n");
        double total = room.getPrice() * room.getNights();
        double totalFood = 0;
        
        for( Food food : room.getFoodList()){
            double foodPrice = food.getQuantity() * food.getPrice();
            System.out.println( food.getType() + ": $" + foodPrice);
            totalFood += foodPrice;
        }
        
        System.out.println("Total Habitación: " + total);
        System.out.println("Total Comida: " + totalFood);
        System.out.println("Total: " + (total + totalFood) );
        
        System.out.println("************\nFin Factura\n************\n");
        
        return true;
    }
    
    
    
    public static void featuresRoom(int roomType){
        switch (roomType) {
            case 1:System.out.println("Número de camas : 2\nAC : Si\nDesayuno : Si");
                break;
            case 2:System.out.println("Número de camas : 2\nAC : No\nDesayuno : No");
                break;
            case 3:System.out.println("Número de camas : 1\nAC : Si\nDesayuno : Si");
                break;
            case 4:System.out.println("Número de camas : 1\nAC : No\nDesayuno : No");
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }
    
    public static void roomService(int roomNumber, int roomType){
        Scanner sc = new Scanner(System.in);
        String type;
        int quantity;
        double price;
        char wish;
        try {
            System.out.println("\n==========\n   Menu:");
            do {
                System.out.print("Eliga del menú: ");
                type = sc.next();
                System.out.print("Cantidad: ");
                quantity = sc.nextInt();
                System.out.print("Precio: ");
                price = sc.nextDouble();

                switch(roomType){
                    case 1: 
                        holder.luxury_double_room[roomNumber].addFood(new Food(type, quantity, price) );
                        break;
                    case 2: 
                        holder.single_double_room[roomNumber].addFood( new Food(type, quantity, price) );
                        break;
                    case 3: 
                        holder.luxury_simple_room[roomNumber].addFood( new Food(type, quantity, price) );
                        break;
                    case 4: 
                        holder.single_simple_room[roomNumber].addFood( new Food(type, quantity, price) );
                        break;                                                 
                }
                System.out.println("¿Quieres seguir ordenando? (s/n)");
                wish=sc.next().charAt(0); 
            } while( wish=='s' || wish=='s');  
        } catch(NullPointerException e) {
            System.out.println("\nHabitación no ocupada.");
        } 
    }
    
    
}
