package controllador;

import modelos.Departamento;


public class ParametrizationController {
    
    
    public void createDepartamento(String nombre, Integer Code) throws Exception{
        Departamento dep = new Departamento();
        dep.setNombre(nombre);
        dep.setCodigo(Code);
        
        if(nombre.length() > 100){
            throw new Exception("El nombre debe tener menos de 100 caracteres.");
        }
        
        try{
            dep.save();
        }catch(Exception e){
            throw new Exception("No se puede crear el departamento!!!");
        }
    }
    
    
    
}
