package utils.db;

import java.sql.DriverManager;
import java.sql.Connection;

public class DB {
    
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/covid";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public DB(){
        try{
            Class.forName( driver );
        }catch(Exception e){
            System.err.println("No se puede conectar a la base de datos.");
        }
    }
    
    
    public Connection createConnection(){
        Connection conn = null;
        try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
        } catch( Exception e){
            System.err.println("Error al obtener el conector");
        }
        return conn;
    }
    
    
}
