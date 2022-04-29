package com.company;

public class Equipo {
    private String NOMBRE;
    private String ID;
    private String NUMERO;
    private String FECHA;
    private String MODELO;

    public Equipo(String nombre, String id, String numero, String fecha, String modelo){

        this.NOMBRE = nombre;
        this.ID = id;
        this.NUMERO = numero;
        this.FECHA = fecha;
        this.MODELO = modelo;

    }

    public String getNOMBRE(){
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNUMERO(){
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) { this.FECHA = FECHA; }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

}
