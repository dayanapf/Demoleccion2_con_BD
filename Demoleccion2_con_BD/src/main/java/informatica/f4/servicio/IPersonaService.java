/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.servicio;

import informatica.f4.modelo.*;
import java.util.List;

/**
 *
 * @author maira
 */
public interface IPersonaService {
    public Persona salvar(Persona persona);
    public List<Persona> listar();
}
    

 