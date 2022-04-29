package com.company;

public class Asignacion {
    private String NOMBRE;
    private String FECHA;
    private String HORA;
    private String MOTIVO;
    private String NOMUSUARIO;

    public Asignacion(String nombre, String fecha, String hora, String motivo, String nomusuario){

        this.NOMBRE = nombre;
        this.FECHA = fecha;
        this.HORA = hora;
        this.MOTIVO = motivo;
        this.NOMUSUARIO = nomusuario;

    }

    public String getNOMBRE(){
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getFECHA(){
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getHORA(){
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public String getMOTIVO() {
        return MOTIVO;
    }

    public void setMOTIVO(String MOTIVO) {
        this.MOTIVO = MOTIVO;
    }

    public String getNOMUSUARIO() {
        return NOMUSUARIO;
    }

    public void setNOMUSUARIO(String nomusuario) {
        this.NOMUSUARIO = NOMUSUARIO;
    }
}
