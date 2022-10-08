package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.IProyectoService;
import com.portfolio.miportfolio.model.Proyecto;
import com.portfolio.miportfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepo;

    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> listaSoftskill = proyectoRepo.findAll();
        return listaSoftskill;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
         
    }

    @Override
    public void deleteProyecto(Long id) {
    proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
    Proyecto proyecto = proyectoRepo.findById(id).orElse(null);
    return proyecto;
    }

    @Override
    public Proyecto modificarProyecto(Proyecto proyecto) {
    return proyectoRepo.save(proyecto);
    }

}
