/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.controlador;

import informatica.f4.BasicApplication;
import informatica.f4.servicio.IButacaService;
import org.springframework.beans.factory.annotation.Autowired;
import informatica.f4.modelo.Butaca;
import informatica.f4.modelo.balcon;
import informatica.f4.modelo.platea;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ButacaController {
    public static Logger LOG = LoggerFactory.getLogger(BasicApplication.class);
    
    
    private List<Butaca> butacanovendida = new LinkedList<>();

    @Autowired
    private IButacaService butaca;      
   
   

    @GetMapping(path = {"/butacas"})
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("butucas");
        view.addObject("balconFormulario", new balcon());
        view.addObject("plateaFormulario", new platea());
        view.addObject("balcon", butaca.listarbalcon());
        view.addObject("platea", butaca.listarplatea());
        
        return view;
    }

    @PostMapping("/butacas")
    public ModelAndView capturar(balcon bb, platea bp, ModelAndView model) {
        
        model.addObject("balconFormulario", new balcon());
        model.addObject("plateaFormulario", new platea());
        
        LOG.info("balcon " + bb.esbalcon().toString());
        LOG.info("platea " + bp.esplatea().toString());
        
        if (!bb.vacia() && bb.esbalcon()) {
            butaca.salvar(bb);            
        } else if (!bp.vacia() && bp.esplatea()) {
            butaca.salvar(bp);
        }
        model.addObject("balcon", butaca.listarbalcon());
        model.addObject("platea", butaca.listarplatea());
        model.setViewName("butucas");
        return model;
    }

    @GetMapping("/butacas_vendidas")
    public ModelAndView vendida() {
        ModelAndView lista = new ModelAndView("list_butaca_vendida");
        
        
        lista.addObject("venta", butaca.ventatotal()); 
        lista.addObject("ventafumadores", butaca.ventafumadores()); 
        lista.addObject("butaca", butaca.listarvendidas());
        return lista;
    }
    
    
    @GetMapping("/butacas_no_vendidas")
    public ModelAndView novendida() {
        ModelAndView lista = new ModelAndView("list_butaca_no_vendida");

        lista.addObject("butaca", butaca.listarnovendidas());
        return lista;
    }
    
    @GetMapping("/vender/{id}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {            
        Butaca elemento_a_vender = null;        
        elemento_a_vender = butaca.buscarPorId(id);
        if(!(elemento_a_vender == null)){
            if(elemento_a_vender.que_soy().equals("balcon")){
                view.setViewName("butucas_balcon");
                view.addObject("balconFormulario", elemento_a_vender);
                
            }else if(elemento_a_vender.que_soy().equals("platea")){
                view.setViewName("butucas_platea");
                view.addObject("plateaFormulario", elemento_a_vender);
            }
        } else{
            view.setViewName("error_no_existe");
        }      
        
        return view;
    }
    
    @GetMapping("/eliminar/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("butucas");
        butaca.eliminarPorId(id);
        view.addObject("balconFormulario", new balcon());
        view.addObject("plateaFormulario", new platea());
        view.addObject("balcon", butaca.listarbalcon());
        view.addObject("platea", butaca.listarplatea());

        return view;
    }

    
    
}
