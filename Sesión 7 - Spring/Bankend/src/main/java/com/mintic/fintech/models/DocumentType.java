package com.mintic.fintech.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documento_type")
public class DocumentType {
    
    @Id
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;

    public DocumentType() {
    }

    public DocumentType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
