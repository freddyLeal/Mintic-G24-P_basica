package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.db.DB;
import utils.db.Models;


public class Municipio extends Models{
    private Integer id;
    private String nombre;
    private Integer codigo;
    private Departamento departamento;

    
    public Municipio() {
    }   
    
    @Override
    public Object find(Integer id) {
        Municipio municipio = null;
        
        try(Connection conn = super.conectar()){
            String query = "SELECT m.id, m.nombre, m.codigo, m.departamento_id "
                    + "     FROM municipio m "
                    + "     LEFT JOIN departamento dep on dep.id = m.departamento_id"
                    + "     WHERE m.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el id="+id);
                            
                this.setId((Integer) result.getInt("id"));
                this.setNombre(result.getString("nombre"));
                this.setCodigo((Integer) result.getInt("codigo"));
                this.setDepartamento((Departamento) new Departamento().find(result.getInt("departamento_id") ));
                municipio = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla municipio");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla municipio");
        }
        
        return municipio;
    }

    @Override
    public Integer save(){
        Integer id = null;
        String query;
        try(Connection conn = super.conectar()){
            
            if( this.getId() == null){
                query = "INSERT INTO municipio (departamento_id, nombre, codigo) "
                    + "  VALUES (?, ?, ?);";
            } else {
                query = "UPDATE municipio set departamento_id=?, nombre=?, codigo=?"
                    + "  WHERE id = ? ";
            }
            
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(this.getDepartamento() == null)
                throw new Exception("El departamento es obligatorio para crear un municipio.");
            
            statement.setInt(1, this.getDepartamento().getId() );
            statement.setString(2, this.getNombre());
            statement.setInt(3, this.getCodigo());
            
            if( this.getId() != null)
                statement.setInt(4, this.getId());
            
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla municio.");
        }
        
        return id;
    }

    @Override
    public void delete() {
        try(Connection conn = super.conectar()){
            String query = "DELETE FROM municipio WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.getId());
            statement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puede eliminar el registro id= " + this.getId() + " de la tabla municipio");
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

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    
    

    
    
    
    
    
    
}
