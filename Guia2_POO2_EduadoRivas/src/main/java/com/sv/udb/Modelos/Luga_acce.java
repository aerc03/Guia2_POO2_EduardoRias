/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Modelos;

import java.sql.Blob;

/**
 *
 * @author aerc
 */
public class Luga_acce {
    private int codi_luga_acce;
    private String nomb_luga_acce;
    private String fech_alta;
    private String fech_baja;
    private Blob esta;

    public Blob getEsta() {
        return esta;
    }

    public void setEsta(Blob esta) {
        this.esta = esta;
    }

    public Luga_acce(int aInt, Object object, Object object0, Object object1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFech_baja() {
        return fech_baja;
    }

    public void setFech_baja(String fech_baja) {
        this.fech_baja = fech_baja;
    }

    public String getFech_alta() {
        return fech_alta;
    }

    public void setFech_alta(String fech_alta) {
        this.fech_alta = fech_alta;
    }
    

    public String getNomb_luga_acce() {
        return nomb_luga_acce;
    }

    public void setNomb_luga_acce(String nomb_luga_acce) {
        this.nomb_luga_acce = nomb_luga_acce;
    }

    public int getCodi_luga_acce() {
        return codi_luga_acce;
    }

    public void setCodi_luga_acce(int codi_luga_acce) {
        this.codi_luga_acce = codi_luga_acce;
    }

    public Luga_acce() {
    }

    public Luga_acce(int codi_luga_acce, String nomb_luga_acce, String fech_alta, String fech_baja, Blob esta) {
        this.codi_luga_acce = codi_luga_acce;
        this.nomb_luga_acce = nomb_luga_acce;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }
    
    
}
