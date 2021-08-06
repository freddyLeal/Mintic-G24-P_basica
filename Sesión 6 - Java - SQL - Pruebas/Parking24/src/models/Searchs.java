package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.db.Perseverance;


public class Searchs extends Perseverance{

    public void startDbTest(){
        try(Connection conn = createDBTesting()){
            // no hacer nada
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Object get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Parking> getParkingList(Boolean isFree){
        List<Parking> parkingList = new ArrayList();
        String query = "";
        
        try(Connection conn = super.createConnection()){
            
            if( isFree != null)
                query = "SELECT p.id, p.code, p.is_free, p.car_number, p.arrived "
                        + "     FROM parking p where p.is_free = ?";
            else
                query = "SELECT p.id, p.code, p.is_free, p.car_number, p.arrived "
                        + "     FROM parking p";
            
            PreparedStatement statement = conn.prepareStatement(query);
            
            if( isFree != null)
                statement.setBoolean(1, isFree);
            
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                parkingList.add( Parking.rowMapper( result ) );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return parkingList;
    }

    public List<ParkingLog> getParkingLogListByParking(Integer parkingId) throws Exception{
        List<ParkingLog> parkingLogList = new ArrayList();
        try(Connection conn = super.createConnection()){
            String query = "SELECT id, code, car_number, arrived, departure, minutes, parking_i "
                + "     FROM parking_log  WHERE parking_i = ? order by id desc";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, parkingId);
            
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                parkingLogList.add( ParkingLog.rowMapper( result ) );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return parkingLogList;
    }

   
    
}
