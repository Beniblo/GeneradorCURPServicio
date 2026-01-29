package org.calculadoracurpservice.model;

/**
 *
 * @author beniblo
 */
public class Ciudadano {
    //Creacion de las variables de atributo de la persona
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char genero;
    private String fechaDeNacimiento;
    private String entidad;
    private String curpGenerada;

    public Ciudadano() {
    }

    public Ciudadano(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, char genero, String fechaDeNacimiento, String entidad, String curpGenerada) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.entidad = entidad;
        this.curpGenerada = curpGenerada;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCurpGenerada() {
        return curpGenerada;
    }

    public void setCurpGenerada(String curpGenerada) {
        this.curpGenerada = curpGenerada;
    }
    
    
}
