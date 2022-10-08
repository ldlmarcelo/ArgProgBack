package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {

    public List<Proyecto> getProyecto();

    public void saveProyecto(Proyecto proyecto);

    public void deleteProyecto(Long id);

    public Proyecto findProyecto(Long id);

    public Proyecto modificarProyecto(Proyecto proyecto);
}
