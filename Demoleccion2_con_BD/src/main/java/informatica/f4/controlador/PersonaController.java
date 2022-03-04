/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.controlador;

import informatica.f4.modelo.Persona;
import informatica.f4.servicio.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tecnologiaf4
 */
/**
 * La anotación @Controller indica al compilador que la clase es un controlador
 * de Spring
 */
@Controller
public class PersonaController {
    @Autowired
    private IPersonaService personas;    
    

    @GetMapping(path = {"/personas"})
    public ModelAndView persona() {
        ModelAndView view = new ModelAndView("formulario");
        view.addObject("personaFormulario", new Persona());

        return view;
    }

    @PostMapping(path = {"/personas"})
    public ModelAndView capturar(Persona p, ModelAndView model) {
        model.addObject("personaFormulario", new Persona());
        personas.salvar(p);
        model.addObject("personas", personas.listar());
        model.setViewName("formulario");
        return model;
    }

}
