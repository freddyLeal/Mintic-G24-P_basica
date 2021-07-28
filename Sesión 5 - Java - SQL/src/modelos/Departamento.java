package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.db.DB;
import utils.db.Perseverance;

public class Departamento extends Perseverance{
    private Integer id;
    private String nombre;
    private Integer codigo;
    

    public Departamento() {
    }
    
    
    @Override
    public Departamento get(Integer id){
        Departamento dep = null;
        
        try( Connection conn =  createConnection() ){
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
    
    
    @Override
    public Integer save(){
        String query;
        
        try(Connection conn = createConnection()){
            if( this.id == null )
                query = "INSERT INTO departamento (nombre, codigo) VALUES (?, ?)";
            else
                query = "UPDATE departamento SET nombre=?, codigo=? WHERE id=? ";
           
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.nombre);
            statement.setInt(2, this.codigo);
            
            if( this.id != null ){
                statement.setInt(3, this.id);
            }
            
            int rows = statement.executeUpdate();
            
            if( rows > 0 ){
                ResultSet generateKeys = statement.getGeneratedKeys();
                if( generateKeys.next() )
                    this.id = generateKeys.getInt(1);
            }
                    
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Error al crear/editar el registro en la tabla departamento");
        }
        
        return this.id;
    }
    
    
    
    @Override
    public Integer delete(){
        Integer id = null;
        
        try(Connection conn = createConnection() ){
            String query = "DELETE FROM departamento WHERE id=? ";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, this.id);
            int rows = statement.executeUpdate();
            
            if( rows > 0 ){
                ResultSet generateKeys = statement.getGeneratedKeys();
                if( generateKeys.next() )
                    this.id = generateKeys.getInt(1);
            }
                    
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Error al editar el registro en la tabla departamento");
        }
        
        return id;
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
