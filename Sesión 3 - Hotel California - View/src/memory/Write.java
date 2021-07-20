package memory;

import clases.Holder;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Write implements Runnable {

    Holder holder;
    
    public Write(Holder holder){
        this.holder = holder;
    }
    
    @Override
    public void run() {
        try{
            System.out.println("Guardando en memoria");
            FileOutputStream out = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream( out );
            oos.writeObject( this.holder );
        }catch(Exception e){
            System.out.println("No se pudo guardar el archivo: " + e);
        }
    }
    
}
