/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.modelo;

import informatica.f4.BasicApplication;
import java.io.Serializable;
import javax.persistence.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dayi
 */
@Entity
public class balcon extends Butaca implements Serializable {
    public static Logger LOG = LoggerFactory.getLogger(BasicApplication.class);
    
    private Boolean fumadores;

    public balcon(Boolean fumadores, String id_nombre, Boolean vendida) {
        super(id_nombre, vendida);
        this.fumadores = fumadores;
    }

    public balcon() {
       
    }

    public Boolean getFumadores() {
        return fumadores;
    }

    public void setFumadores(Boolean fumadores) {
        this.fumadores = fumadores;
    }

    @Override
    public String getId_nombre() {
        return id_nombre;
    }

    /**
     *
     * @param id_nombre
     */
    @Override
    public void setId_nombre(String id_nombre) {
        this.id_nombre = id_nombre;
    }

   

    @Override
    public Boolean getVendida() {
        return vendida;
    }

    @Override
    public void setVendida(Boolean vendida) {
        this.vendida = vendida;
    }
    
    
    @Override
    public double costo() {
        Double num_balcon = Double.parseDouble(id_nombre.substring(1, 2));
        Double costo = num_balcon * 0.5;
        if (fumadores) {
            costo += 5;
        } 
        return costo;
    }
    
    public Boolean esbalcon(){
        return fumadores != null;    
}

    @Override
    public String que_soy() {
        return "balcon";
    }
    
}
