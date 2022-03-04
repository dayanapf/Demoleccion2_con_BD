/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tecnologiaf4
 */

/**
 * La anotación @Controller indica al compilador 
 * que la clase es un controlador de Spring
 */
@Controller
public class HomeController {
   
    @GetMapping(path = {"/","", "/home"})
    public ModelAndView Home() {
        ModelAndView index = new ModelAndView("index");
        return index;
    }
}
