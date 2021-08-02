package models;

import java.sql.Timestamp;
import utils.db.Perseverance;


public class Parking extends Perseverance{
    
    private Integer id;
    private String code;
    private Boolean isFree;
    private String carNumber;
    private Timestamp arrived;

    public Parking() {
    }

    public Parking(Integer id, String code, Boolean isFree, String carNumber, Timestamp arrived) {
        this.id = id;
        this.code = code;
        this.isFree = isFree;
        this.carNumber = carNumber;
        this.arrived = arrived;
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

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
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
    
    
    
}
