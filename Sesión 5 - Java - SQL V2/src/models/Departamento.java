package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.db.DB;
import utils.db.Models;


public class Departamento extends Models{
    private DB db = new DB();
    
    private Integer id;
    private String nombre;
    private Integer codigo;

    
    public Departamento() {
    }
    
    
    
    public Object findByCode(Integer code) {
        Departamento dep = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT dep.id, dep.nombre, dep.codigo FROM departamento dep WHERE dep.codigo = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, code);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el codigo="+code);
                            
                this.id = result.getInt("id");
                this.nombre = result.getString("nombre");
                this.codigo = result.getInt("codigo");
                dep = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el codigo="+code+" en la tabla departamento");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento codigo=" + code + " de la tabla Departamento");
        }
        
        return dep;
    }
    
    
    @Override
    public Object find(Integer id) {
        Departamento dep = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT dep.id, dep.nombre, dep.codigo FROM departamento dep WHERE dep.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el id="+id);
                            
                this.id = result.getInt("id");
                this.nombre = result.getString("nombre");
                this.codigo = result.getInt("codigo");
                dep = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla departamento");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla Departamento");
        }
        
        return dep;
    }

    
    @Override
    public Integer save() {
        Integer id = null;
        String query;
        try(Connection conn = super.conectar()){
            
            if( this.getId() == null){
                query = "INSERT INTO departamento (nombre, codigo) "
                    + "  VALUES (?, ?);";
            } else {
                query = "UPDATE departamento set nombre=?, codigo=?"
                    + "  WHERE id = ? ";
            }
            
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, this.getNombre());
            statement.setInt(2, this.getCodigo());
            
            if( this.getId() != null)
                statement.setInt(3, this.getId());
            
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla departamento.");
        }
        
        return id;
    }
    

    @Override
    public void delete() {
        try(Connection conn = super.conectar()){
            String query = "DELETE FROM departamento WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.getId());
            statement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puede eliminar el registro id= " + this.getId() + " de la tabla departamento");
        }
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
