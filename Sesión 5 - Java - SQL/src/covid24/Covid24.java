package covid24;

import modelos.Departamento;



public class Covid24 {

    public static void main(String[] args) {
        
        Departamento dep = new Departamento().getDepartamentoById(8);
        System.out.println( dep.getNombre() );
        
        Departamento dep2 = new Departamento().getDepartamentoById(22);
        System.out.println( dep2.getNombre() );
        
    }
    
}
