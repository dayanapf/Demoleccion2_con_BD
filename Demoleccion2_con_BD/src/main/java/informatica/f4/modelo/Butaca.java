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
 * @author maira
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Butaca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String id_nombre;
    protected Boolean vendida;    

    public Butaca(String id, Boolean vendida) {
        this.id_nombre = id_nombre;
        this.vendida = vendida;
    }
    public Butaca() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_nombre() {
        return id_nombre;
    }

    public void setId_nombre(String id_nombre) {
        this.id_nombre = id_nombre;
    }

    public Boolean getVendida() {
        return vendida;
    }

    public void setVendida(Boolean vendida) {
        this.vendida = vendida;
    }
    
    public abstract double costo();
    
    public Boolean vacia() {
        return id_nombre.isEmpty();         
    }
    public abstract String que_soy();
    

}
