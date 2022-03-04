/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.modelo;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Dayi
 */
@Entity
public class platea extends Butaca implements Serializable {
    
    private Boolean protocolo;

    public platea(Boolean protocolo, String id_nombre, Boolean vendida) {
        super(id_nombre, vendida);
        this.protocolo = protocolo;
    }

    public platea() {
       
    }

    public Boolean getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Boolean protocolo) {
        this.protocolo = protocolo;
    }

    /**
     *
     * @return
     */
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

    

    /**
     *
     * @return
     */
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
        if(protocolo){
            return 30;
        }else{
            return 20;
        }
    }
    
    public Boolean esplatea(){
        return protocolo != null;    
}

    @Override
    public String que_soy() {
        return "platea";
    }
    
}
