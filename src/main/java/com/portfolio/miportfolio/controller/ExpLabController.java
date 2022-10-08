package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.iService.IExpLabService;
import com.portfolio.miportfolio.model.ExpLab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExpLabController {

    @Autowired
    private IExpLabService interExpLab;

    @GetMapping("/ExperienciaLaboral/traer")
    public List<ExpLab> getExpLab() {
        return interExpLab.getExpLab();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ExperienciaLaboral/crear")
    public String createExpLab(@RequestBody ExpLab expe) {
        interExpLab.saveExpLab(expe);
        return "La experiencia laboral fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/ExperienciaLaboral/borrar/{id}")
    public String deleteExpLab(@PathVariable Long id) {

        interExpLab.deleteExpLab(id);
        return "La experiencia laboarl fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("ExperienciaLaboral/editar/{id}")

    public ExpLab editExpLab(@PathVariable Long id,
            @RequestParam("empresa") String nuevoEmpresa,
            @RequestParam("fecha") String nuevoFecha,
            @RequestParam("puesto") String nuevoPuesto,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("logo") String nuevoLogo)
             {
        ExpLab expe = interExpLab.findExpLab(id);

        expe.setEmpresa(nuevoEmpresa);
        expe.setFecha(nuevoFecha);
        expe.setPuesto(nuevoPuesto);
        expe.setDescripcion(nuevoDescripcion);
        expe.setLogo(nuevoLogo);
        
        interExpLab.saveExpLab(expe);
        return expe;
    }
    
    
    /*
    @GetMapping("ExperienciaLaboral/traer/ecperiencia")
    public ExpLab traerExpLab() {
        return interExpLab.findExpLab((long) 6);
    }*/

}
