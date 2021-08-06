package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import utils.db.Perseverance;


public class ParkingLog extends Perseverance{
    
    private Integer id;
    private String code;
    private String carNumber;
    private Timestamp arrived;
    private Timestamp departure;
    private Integer minutes;
    private Integer parkingId;

    public ParkingLog() {
    }

    public ParkingLog(Integer id, String code, String carNumber, Timestamp arrived, Timestamp departure, Integer minutes, Integer parkingId) {
        this.id = id;
        this.code = code;
        this.carNumber = carNumber;
        this.arrived = arrived;
        this.departure = departure;
        this.minutes = minutes;
        this.parkingId = parkingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Timestamp getArrived() {
        return arrived;
    }

    public void setArrived(Timestamp arrived) {
        this.arrived = arrived;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }
    
    
    public Object getLastParkingId(Integer parkingId) throws Exception {
        ParkingLog log = null;
        System.out.println( parkingId );
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, code, car_number, arrived, departure, minutes, parking_i "
                    + "     FROM parking_log  WHERE parking_i = ? order by id desc limit 1 ";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, parkingId);
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                log = ParkingLog.rowMapper( result );
            }
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto parking_i=" + id + " en la tabla parking.");
        }
        
        return log;
    }
    
    
    @Override
    public Object get(Integer id) throws Exception {
        ParkingLog log = null;
        
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, code, car_number, arrived, departure, minutes, parking_i "
                    + "     FROM parking_log  WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                log = ParkingLog.rowMapper( result );
            }
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto id=" + id + " en la tabla departamento.");
        }
        
        return log;
    }

    @Override
    public Integer save() throws Exception {
        String query;
        
        try(Connection conn = createConnection()){
            if( this.id == null )
                query = "INSERT INTO parking_log (code, car_number, arrived, departure, minutes, parking_i) VALUES (?, ?, ?, ?, ?, ?)";
            else
                query = "UPDATE parking_log SET code=?, car_number=?, arrived=?, departure=?, minutes=?, parking_i=?  WHERE id=? ";
           
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.code);
            statement.setString(2, this.carNumber);
            statement.setTimestamp(3, this.arrived);
            statement.setTimestamp(4, this.departure);
            statement.setInt(5, this.minutes);
            statement.setInt(6, this.parkingId);
            
            if( this.id != null ){
                statement.setInt(7, this.id);
            }
            
            int rows = statement.executeUpdate();
            
            if( rows > 0 ){
                ResultSet generateKeys = statement.getGeneratedKeys();
                if( generateKeys.next() )
                    this.id = generateKeys.getInt(1);
            }
                    
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error al crear/editar el registro en la tabla parking_log");
        }
        
        return this.id;
    }

    @Override
    public Integer delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public static ParkingLog rowMapper(ResultSet result) throws SQLException{
        return new ParkingLog(
                result.getInt("id"), 
                result.getString("code"),
                result.getString("car_number"),
                result.getTimestamp("arrived"),
                result.getTimestamp("departure"),
                result.getInt("minutes"),
                result.getInt("parking_i") );
    }
    
}
