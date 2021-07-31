package models;

import java.util.Date;
import utils.db.Models;


public class Casos extends Models{
    
    private Integer id;
    private Date fechaReporteWeb;
    private Date fechaNotificacion;
    private Integer edad;
    private String sexo;
    private String tipoContagio;
    private String ubicacion;
    private String estado;
    private String paisImportado;
    private String recuerpado;
    private Date fechaInicioSintomas;
    private Date fechaDiagnostico;
    private Date fechaRecuperacion;
    private Date fechaMuerte;
    
    private Municipio municipio;

    public Casos() {
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
     * @return the fechaReporteWeb
     */
    public Date getFechaReporteWeb() {
        return fechaReporteWeb;
    }

    /**
     * @param fechaReporteWeb the fechaReporteWeb to set
     */
    public void setFechaReporteWeb(Date fechaReporteWeb) {
        this.fechaReporteWeb = fechaReporteWeb;
    }

    /**
     * @return the fechaNotificacion
     */
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    /**
     * @param fechaNotificacion the fechaNotificacion to set
     */
    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tipoContagio
     */
    public String getTipoContagio() {
        return tipoContagio;
    }

    /**
     * @param tipoContagio the tipoContagio to set
     */
    public void setTipoContagio(String tipoContagio) {
        this.tipoContagio = tipoContagio;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the paisImportado
     */
    public String getPaisImportado() {
        return paisImportado;
    }

    /**
     * @param paisImportado the paisImportado to set
     */
    public void setPaisImportado(String paisImportado) {
        this.paisImportado = paisImportado;
    }

    /**
     * @return the recuerpado
     */
    public String getRecuerpado() {
        return recuerpado;
    }

    /**
     * @param recuerpado the recuerpado to set
     */
    public void setRecuerpado(String recuerpado) {
        this.recuerpado = recuerpado;
    }

    /**
     * @return the fechaInicioSintomas
     */
    public Date getFechaInicioSintomas() {
        return fechaInicioSintomas;
    }

    /**
     * @param fechaInicioSintomas the fechaInicioSintomas to set
     */
    public void setFechaInicioSintomas(Date fechaInicioSintomas) {
        this.fechaInicioSintomas = fechaInicioSintomas;
    }

    /**
     * @return the fechaDiagnostico
     */
    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    /**
     * @param fechaDiagnostico the fechaDiagnostico to set
     */
    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    /**
     * @return the fechaRecuperacion
     */
    public Date getFechaRecuperacion() {
        return fechaRecuperacion;
    }

    /**
     * @param fechaRecuperacion the fechaRecuperacion to set
     */
    public void setFechaRecuperacion(Date fechaRecuperacion) {
        this.fechaRecuperacion = fechaRecuperacion;
    }

    /**
     * @return the fechaMuerte
     */
    public Date getFechaMuerte() {
        return fechaMuerte;
    }

    /**
     * @param fechaMuerte the fechaMuerte to set
     */
    public void setFechaMuerte(Date fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    /**
     * @return the municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public Object find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
