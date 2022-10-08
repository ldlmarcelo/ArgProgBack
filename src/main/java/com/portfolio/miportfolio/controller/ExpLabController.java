package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.Security.Controller.Mensaje;
import com.portfolio.miportfolio.iService.IExpLabService;
import com.portfolio.miportfolio.model.ExpLab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ExpLabController {

    @Autowired
    private IExpLabService interExpLab;

    @GetMapping("/ExperienciaLaboral/traer")
    public List<ExpLab> getExpLab() {
        return interExpLab.getExpLab();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ExperienciaLaboral/crear")
    public ResponseEntity createExpLab(@RequestBody ExpLab expe) {

        if (StringUtils.isBlank(expe.getEmpresa())) {
            return new ResponseEntity(new Mensaje("incluir Empresa"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(expe.getPuesto())) {
            return new ResponseEntity(new Mensaje("incluir puesto"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(expe.getFecha())) {
            return new ResponseEntity(new Mensaje("incluir periodo"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(expe.getDescripcion())) {
            return new ResponseEntity(new Mensaje("la descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        interExpLab.saveExpLab(expe);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    
    @DeleteMapping("/ExperienciaLaboral/borrar/{id}")
    public ResponseEntity deleteExpLab(@PathVariable("id") Long id) {

        interExpLab.deleteExpLab(id);
        return new ResponseEntity(new Mensaje("Experiencia barroda"), HttpStatus.OK);
    }
    

   

    @PutMapping("/ExperienciaLaboral/modificar")
    public ResponseEntity<ExpLab> modificarExperiencia(@RequestBody ExpLab experiencia) {
        ExpLab experienciaModificada = interExpLab.modificarExperiencia(experiencia);
        return new ResponseEntity<>(experienciaModificada, HttpStatus.OK);
    }

    @GetMapping("/ExperienciaLaboral/buscar/{id}")
    public ResponseEntity<ExpLab> buscarExperiencia(@PathVariable("id") Long id) {
        ExpLab experienciaBuscada = interExpLab.findExpLab(id);
        return new ResponseEntity<>(experienciaBuscada, HttpStatus.OK);
    }
}
