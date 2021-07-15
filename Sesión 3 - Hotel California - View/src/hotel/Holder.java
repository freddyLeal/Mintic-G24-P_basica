package hotel;

import java.io.Serializable;


public class Holder implements Serializable {
    
    public DoubleRoom luxury_double_room[] = new DoubleRoom[10];
    public DoubleRoom single_double_room[] = new DoubleRoom[10];
    public Room luxury_simple_room[] = new Room[20];
    public Room single_simple_room[] = new Room[20];
    
}
