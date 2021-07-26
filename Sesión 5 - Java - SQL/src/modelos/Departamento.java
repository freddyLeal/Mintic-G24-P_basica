package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.db.DB;

public class Departamento {
    private DB db;
    
    private Integer id;
    private String nombre;
    private Integer codigo;
    

    public Departamento() {
        db = new DB();
    }
    
    
    public Departamento getDepartamentoById(Integer id){
        Departamento dep = null;
        
        try(Connection conn = db.createConnection()){
            String query = "SELECT dep.id, dep.nombre, dep.codigo "
                    + "     FROM departamento dep WHERE dep.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un resultado.");
                
                this.id = result.getInt(1);
                this.nombre = result.getString(2);
                this.codigo = result.getInt(3);
                
                dep = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            System.err.println("No se puedo obtener la información del objeto id=" + id + " en la tabla departamento.");
        }
        
        return dep;
    }
    
    
    
    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    
                
    
            
    
}
