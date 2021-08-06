package controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Parking;
import models.ParkingLog;
import models.Searchs;


public class ParkingController {

    public List<Parking> getParkingListFree() {
        List<Parking> parkingList = new ArrayList();
        parkingList = new Searchs().getParkingList(true);
        return parkingList; 
    }

    public List<Parking> getParkingListNotFree() {
        List<Parking> parkingList = new ArrayList();
        parkingList = new Searchs().getParkingList(false);
        return parkingList;
    }

    public List<Parking> getAllParkingList() {
        List<Parking> parkingList = new ArrayList();
        parkingList = new Searchs().getParkingList(null);
        return parkingList;
    }

    public void setArrivedToParking(int id, String placa) throws Exception {
        Parking par = (Parking) new Parking().get(id);
        par.setIsFree(false);
        par.setCarNumber(placa);

        Timestamp time = new Timestamp( new Date().getTime() );
        par.setArrived( time );
        par.save();
    }

    public void setDepartureToParking(int id) throws Exception {
        Parking par = (Parking) new Parking().get(id);
        
        ParkingLog log = new ParkingLog();
        log.setCode( par.getCode() );
        log.setCarNumber( par.getCarNumber() );
        log.setArrived( par.getArrived() );
        log.setDeparture( new Timestamp(new Date().getTime()) );
        log.setMinutes( calculateMinutes( par.getArrived(), log.getDeparture() ) );
        log.setParkingId( par.getId() );
        log.save();
        
        par.setIsFree(true);
        par.setCarNumber(null);
        par.setArrived( null );
        par.save();
    }
    
    
    public ParkingLog getParkingLogByParkingId(Integer id) throws Exception{
        return (ParkingLog) new ParkingLog().getLastParkingId(id);
    }

    public List<ParkingLog> getParkingLogList(Integer parkingId) throws Exception {
        List<ParkingLog> parkingLogList = new Searchs().getParkingLogListByParking(parkingId);
        return parkingLogList;
    }

    private Integer calculateMinutes(Timestamp arrived, Timestamp departure) {
        long llegada = arrived.getTime();
        long salida = departure.getTime();
        long totalTime = salida - llegada;
        totalTime = totalTime / 1000;
        return new Long(totalTime).intValue();
    }
    
}
