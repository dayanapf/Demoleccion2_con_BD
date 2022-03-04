/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatica.f4.servicio;

import informatica.f4.modelo.Butaca;
import informatica.f4.modelo.balcon;
import informatica.f4.modelo.platea;
import java.util.List;

/**
 *
 * @author maira
 */
public interface IButacaService {
    public Butaca salvar(Butaca butaca);
    public List<Butaca> listar();
    public List<platea> listarplatea();
    public List<balcon> listarbalcon();
    public List<Butaca> listarvendidas();
    public List<Butaca> listarnovendidas();
    public Double ventatotal();
    public Double ventafumadores();
    public Butaca buscarPorId(Long id);
    public void eliminarPorId(Long id);
}
    

 