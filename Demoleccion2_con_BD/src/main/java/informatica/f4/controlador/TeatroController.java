/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.controlador;

import informatica.f4.modelo.Teatro;
import informatica.f4.servicio.ITeatroService;
import java.util.LinkedList;
import java.util.List;
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
public class TeatroController {
    @Autowired
    private ITeatroService teatro;

    @GetMapping(path = {"/teatro"})
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("teatro");
        view.addObject("teatroFormulario", new Teatro());
        view.addObject("teatro", teatro.listar());
        return view;
    }

    @PostMapping("/teatro")
    public ModelAndView capturar(Teatro t, ModelAndView model) {
        model.addObject("teatroFormulario", new Teatro());
        teatro.salvar(t);
        model.addObject("teatro", teatro.listar());
        model.setViewName("teatro");
        return model;
    }

}
