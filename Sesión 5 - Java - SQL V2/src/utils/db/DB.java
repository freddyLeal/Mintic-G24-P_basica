package utils.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/covid";

    public DB() {
        try{
            Class.forName( driver );
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection conectar(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(Exception e){
            System.err.println("No se puede conectar a la base de datos: " + this.url);
        }
        return conn;
    }
     
    
    
    
}
