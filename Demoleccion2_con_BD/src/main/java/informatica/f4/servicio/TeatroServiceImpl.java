/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.servicio;

import informatica.f4.modelo.Teatro;
import informatica.f4.repositorio.ITeatroRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maira
 */
@Service
public class TeatroServiceImpl implements ITeatroService {

    @Autowired
    private ITeatroRepo teatrorepo;

    @Override
    public Teatro salvar(Teatro teatro) {
       return teatrorepo.save(teatro);    }


    @Override
    public List<Teatro> listar() {
        return teatrorepo.findAll();
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

    

