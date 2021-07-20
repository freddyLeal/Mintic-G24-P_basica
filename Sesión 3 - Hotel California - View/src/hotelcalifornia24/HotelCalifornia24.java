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
        
        File f = new File("backup");
        if( f.exists() ){
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream( fis );
                Hotel.setHolder( (Holder) ois.readObject() );
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo");
            }
        }
        
        View view = new View();
        view.show();

    }
    
    
}
