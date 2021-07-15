package hotel;

import java.util.Scanner;


public class Hotel {
    
    public static Holder holder = new Holder();
    
    
    public static void getAvailableRooms(int roomType){
        String emptyRooms = "";
        int countEmptyRooms = 0;
        switch(roomType){
            case 1:
                for(int j = 0; j < holder.luxury_double_room.length; j++){
                    if( holder.luxury_double_room[j] == null ){
                        emptyRooms += (j+1) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 2:
                for(int j = 0; j < holder.single_double_room.length; j++){
                    if( holder.single_double_room[j] == null ){
                        emptyRooms += (j+11) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 3:
                for(int j = 0; j < holder.luxury_simple_room.length; j++){
                    if( holder.luxury_simple_room[j] == null ){
                        emptyRooms += (j+21) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 4:
                for(int j = 0; j < holder.single_simple_room.length; j++){
                    if( holder.single_simple_room[j] == null ){
                        emptyRooms += (j+41) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            default:
                System.out.println("Opción no valida");
        }
        
        if( emptyRooms.length() > 1){
            emptyRooms = emptyRooms.substring(0, emptyRooms.length()-2);
        }
        System.out.println("Las habitaciones vacias son: " + emptyRooms);
        System.out.println("Número de habitaciones vacias: " + countEmptyRooms);
    }
    
    
    public static void bookingRoom(int roomType){
        System.out.println("");
        getAvailableRooms( roomType );
        Scanner in = new Scanner( System.in );
        int roomNumber;
        System.out.print("\nSeleccione el número de la habitación: ");
        roomNumber = in.nextInt();
        switch( roomType ){
            case 1:
                roomNumber = roomNumber -1;
                if( holder.luxury_double_room[ roomNumber ] == null )
                    crearRoom(roomType, roomNumber);
                else
                    System.out.println("Habitación no disponible");
                break;
            case 2:
                roomNumber = roomNumber - 11;
                if( holder.single_double_room[ roomNumber ] == null )
                    crearRoom(roomType, roomNumber);
                else
                    System.out.println("Habitación no disponible");
                break;
            case 3:
                roomNumber = roomNumber - 21;
                if( holder.luxury_simple_room[ roomNumber ] == null )
                    crearRoom(roomType, roomNumber);
                else
                    System.out.println("Habitación no disponible");
                break;
            case 4:
                roomNumber = roomNumber - 41;
                if( holder.single_simple_room[ roomNumber ] == null )
                    crearRoom(roomType, roomNumber);
                else
                    System.out.println("Habitación no disponible");
                break;
            case 5:
                System.out.println("No es una opción valida");
        }
    }
    
    
    private static void crearRoom(int roomType, int realRoomNumber){
        String name, contact, gender;
        String name2=null, contact2=null, gender2=null;
        double price;
        int nights;
        Scanner in = new Scanner(System.in);
        DoubleRoom doubleRoom;
        Room room;
        
        System.out.print("Nombre de la persona 1: ");
        name = in.next();
        System.out.print("Contacto de la persona 1: ");
        contact = in.next();
        System.out.print("Genero de la persona 1: ");
        gender = in.next();
        
        if( roomType==1 || roomType==2){
            System.out.print("Nombre de la persona 2: ");
            name2 = in.next();
            System.out.print("Contacto de la persona 2: ");
            contact2 = in.next();
            System.out.print("Genero de la persona 2: ");
            gender2 = in.next();
        }
        
        System.out.print("Precio por noche: ");
        price = in.nextDouble();
        System.out.print("Número de noches: ");
        nights = in.nextInt();
        
        switch( roomType ){
            case 1:
                doubleRoom = new DoubleRoom(name2, contact2, gender2, name, contact, gender, price, nights);
                holder.luxury_double_room[realRoomNumber] = doubleRoom;
                break;
            case 2:
                doubleRoom = new DoubleRoom(name2, contact2, gender2, name, contact, gender, price, nights);
                holder.single_double_room[realRoomNumber] = doubleRoom;
                break;
            case 3:
                room = new Room(name, contact, gender, price, nights);
                holder.luxury_simple_room[realRoomNumber] = room;
                break;
            case 4:
                room = new Room(name, contact, gender, price, nights);
                holder.single_simple_room[realRoomNumber] = room;
                break;
        }
    }
    
    
    
    public static void deallocateRoom(int realRoomNumber, int roomType){
        Room room = null;
        
        switch(roomType){
            case 1:
                realRoomNumber = realRoomNumber - 1;
                room = holder.luxury_double_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    generateInvoice(realRoomNumber, roomType);
                    holder.luxury_double_room[realRoomNumber] = null;
                }
                break;
            case 2:
                realRoomNumber = realRoomNumber - 11;
                room = holder.single_double_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    generateInvoice(realRoomNumber, roomType);
                    holder.luxury_double_room[realRoomNumber] = null;
                }
                break;
            case 3:
                realRoomNumber = realRoomNumber - 21;
                room = holder.luxury_simple_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    generateInvoice(realRoomNumber, roomType);
                    holder.luxury_double_room[realRoomNumber] = null;
                }
                break;
            case 4:
                realRoomNumber = realRoomNumber - 41;
                room = holder.single_simple_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    generateInvoice(realRoomNumber, roomType);
                    holder.luxury_double_room[realRoomNumber] = null;
                }
                break;
            default:
                System.out.println("No coincide con ningún tipo de habitación.");
        }
    }
    
    
    
    private static void generateInvoice(int realRoomNumber, int roomType){
        Room room = null;
        
        switch( roomType ){
            case 1:
                room = holder.luxury_double_room[realRoomNumber];
                break;
            case 2:
                room = holder.single_double_room[realRoomNumber];
                break;
            case 3:
                room = holder.luxury_simple_room[realRoomNumber];
                break;
            case 4:
                room = holder.single_simple_room[realRoomNumber];
                break;
        }
        
        System.out.println("");
        System.out.println("*********Factura*********");
        System.out.println("");
        System.out.println("Comida: ");
        double totalFood = 0;
        for( Food food : room.getFoodList() ){
            double price = food.getPrice() * food.getQuantity();
            System.out.println(food.getType() + ": " + price );
            totalFood += price;
        }
        double totalNights = room.getPrice() * room.getNigths();
        System.out.println("");
        System.out.println("Total Noches: " + totalNights);
        System.out.println("Total Comida: " + totalFood);
        System.out.println("Total: " + (totalNights + totalFood) );
        
        System.out.println("*************************");
        System.out.println("");
    }
    
    
    
    public static void orderFood(int realRoomNumber, int roomType){
        Room room = null;
        Food food = null;
        String type;
        int quantity;
        double price;
        boolean empty = true;
        Scanner in = new Scanner( System.in );
        
        switch(roomType){
            case 1:
                realRoomNumber = realRoomNumber - 1;
                room = holder.luxury_double_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    empty = false;
                }
                break;
            case 2:
                realRoomNumber = realRoomNumber - 11;
                room = holder.single_double_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    empty = false;
                }
                break;
            case 3:
                realRoomNumber = realRoomNumber - 21;
                room = holder.luxury_simple_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    empty = false;
                }
                break;
            case 4:
                realRoomNumber = realRoomNumber - 41;
                room = holder.single_simple_room[realRoomNumber];
                if( room == null){
                    System.out.println("La habitación no esta ocupada");
                } else {
                    empty = false;
                }
                break;
            default:
                System.out.println("No coincide con ningún tipo de habitación.");
        }
        
        if( !empty ){
            String continuar;
            do {
                System.out.println("Elija el menú: ");
                System.out.print("Tipo: ");
                type = in.next();
                System.out.print("Cantidad: ");
                quantity = in.nextInt();
                System.out.print("Precio: ");
                price = in.nextDouble();

                food = new Food(type, price, quantity);
                room.addFood( food );
                
                System.out.print("Ordenar algo mas (S/N): ");
                continuar = in.next();
            } while( continuar.toLowerCase().equals("s") );
        }
        
        
    }
    
    
    
}
