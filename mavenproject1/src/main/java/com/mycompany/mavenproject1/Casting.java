/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author leonardo
 */
public class Casting {

    private String altura;
    private String curp;
    private String fecha;
    private String imagen;
    private String nombre;
    private String pApellido;
    private String peso;
    private String sApellido;

    public Casting() {

        this.altura = "";
        this.curp = "";
        this.fecha = "";
        this.imagen = "";
        this.nombre = "";
        this.pApellido = "";
        this.peso = "";
        this.sApellido = "";
    }

    public Casting(String altura, String curp, String fecha, String imagen, String nombre, String pApellido, String peso, String sApellido) {
        this.altura = altura;
        this.curp = curp;
        this.fecha = fecha;
        this.imagen = imagen;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.peso = peso;
        this.sApellido = sApellido;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getAltura() {
        return altura;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getPApellido() {
        return pApellido;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

    public void setSApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getSApellido() {
        return sApellido;
    }

}
