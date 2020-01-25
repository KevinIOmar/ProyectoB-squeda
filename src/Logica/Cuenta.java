/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Salome
 */
public class Cuenta {
    private String LNombre;
    private String LClave;
    
    public Cuenta(){}
    public Cuenta(String nombre,String clave){
        this.LClave=clave;
        this.LNombre=nombre;
    }
    public String getClave(){return this.LClave;}
    public void setClave(String clave){this.LClave=clave;}
    
    public String getNombre(){return this.LNombre;}
    public void setNombre(String nombre){this.LNombre=nombre;}

    
}
