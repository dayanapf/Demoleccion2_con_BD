/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.servicio;

import informatica.f4.BasicApplication;
import informatica.f4.modelo.Butaca;
import informatica.f4.modelo.balcon;
import informatica.f4.modelo.platea;
import informatica.f4.repositorio.IButacaRepo;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maira
 */
@Service
public class ButacaServiceImpl implements IButacaService {
    public static Logger LOG = LoggerFactory.getLogger(BasicApplication.class);
    @Autowired
    private IButacaRepo butacarepo;

    @Override
    public Butaca salvar(Butaca butaca) {
       return butacarepo.save(butaca);    
    }


    @Override
    public List<Butaca> listar() {
        return butacarepo.findAll();        
    }

    @Override
    public List<platea> listarplatea() {
        List<platea> platea = new LinkedList<>();
        List<Butaca> butaca = new LinkedList<>();
        butaca = butacarepo.findAll();
        for (int i = 0; i < butaca.size(); i++) {
            Butaca get = butaca.get(i);
            if(get.que_soy().equals("platea")){
            platea.add((platea) get);
            }            
        }
        return platea;
    }

    @Override
    public List<balcon> listarbalcon() {
        List<Butaca> butaca = new LinkedList<>();
        List<balcon> balcon = new LinkedList<>();
        butaca = butacarepo.findAll();
        for (int i = 0; i < butaca.size(); i++) {
            Butaca get = butaca.get(i);
            if(get.que_soy().equals("balcon")){
            balcon.add((balcon) get);
            }            
        }
        return balcon;
        
    }

    @Override
    public List<Butaca> listarvendidas() {
        List<Butaca> butaca = butacarepo.findAll();
        List<Butaca> vendida = new LinkedList<>();
        for (int i = 0; i < butaca.size(); i++) {
            Butaca get = butaca.get(i);
            if(get.getVendida()!= null && get.getVendida()){               
                vendida.add(get);
            }            
        }
        return vendida;
    }

    @Override
    public List<Butaca> listarnovendidas() {
        List<Butaca> butaca = butacarepo.findAll();
        List<Butaca> novendida = new LinkedList<>();
        for (int i = 0; i < butaca.size(); i++) {
            Butaca get = butaca.get(i);
            if(get.getVendida()!= null && !get.getVendida()){
                novendida.add(get);
            }            
        }
        return novendida;
    }

    @Override
    public Double ventatotal() {
      List<Butaca> vendida = listarvendidas();
      Double total = 0.0;
      for (int i = 0; i < vendida.size(); i++) {
            total += vendida.get(i).costo();            
      }
      return total;
    }

    @Override
    public Double ventafumadores() {
      List<Butaca> vendida = listarvendidas();
      Double total = 0.0;
      for (int i = 0; i < vendida.size(); i++) {
            if(vendida.get(i).que_soy().equals("balcon")){
                    total += vendida.get(i).costo();
                }
      }
      return total;
    }
    
    @Override
    public Butaca buscarPorId(Long id) {
        return butacarepo.findById(id).get();
    }
    
    @Override
    public void eliminarPorId(Long id) {
        butacarepo.deleteById(id);
    }



   

    }
    
    /*

    @Override
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Pelicula> findByDuracionLessThan(int duracion) {
        return repo.findByDuracionLessThan(duracion);
    }
 */

    

