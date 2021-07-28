package covid24;

import modelos.Departamento;
import modelos.Municipio;



public class Covid24 {

    public static void main(String[] args) {
        
//        Departamento dep = new Departamento().getDepartamentoById(8);
//        System.out.println( dep.getNombre() );
//        
//        Departamento dep2 = new Departamento().getDepartamentoById(22);
//        System.out.println( dep2.getNombre() );
        
//        Municipio mun1 = new Municipio().getMunicipioById( 5 );
//        System.out.println( mun1.getNombre() );
//        System.out.println( mun1.getDepartamento().getNombre() );
        
        Departamento dep = new Departamento().get(45);
        dep.setNombre("aaaaaa");
        dep.setCodigo(1);
        
        int idNewDep = dep.save();
        System.out.println( "Id nuevo departamento: " + idNewDep );
        
                
    }
    
}
