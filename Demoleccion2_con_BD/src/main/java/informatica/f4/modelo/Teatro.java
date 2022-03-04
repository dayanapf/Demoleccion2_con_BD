/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Dayi
 */
@ Entity
public class Teatro implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String nombre;
    protected int cant_butacas;
    
    public Teatro() {
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teatro(String nombre, int cant_butacas) {
        this.nombre = nombre;
        this.cant_butacas = cant_butacas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant_butacas() {
        return cant_butacas;
    }

    public void setCant_butacas(int cant_butacas) {
        this.cant_butacas = cant_butacas;
    }
    
    
    
}
