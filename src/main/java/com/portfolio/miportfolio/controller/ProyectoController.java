package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.Security.Controller.Mensaje;
import com.portfolio.miportfolio.iService.IProyectoService;
import com.portfolio.miportfolio.model.Proyecto;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @GetMapping("/proyecto/traer")
    public List<Proyecto> getProyecto() {
        return iProyectoService.getProyecto();
    }

    @PostMapping("/proyecto/crear")
    public ResponseEntity createProyecto(@RequestBody Proyecto proyecto) {
        if (StringUtils.isBlank(proyecto.getTitulo())) {
            return new ResponseEntity(new Mensaje("incluir titulo"), HttpStatus.BAD_REQUEST);

        }
        if (StringUtils.isBlank(proyecto.getSubtitulo())) {
            return new ResponseEntity(new Mensaje("incluir subtitulo"), HttpStatus.BAD_REQUEST);

        }

        if (StringUtils.isBlank(proyecto.getDetalle())) {
            return new ResponseEntity(new Mensaje("incluir detalle"), HttpStatus.BAD_REQUEST);

        }

        if (StringUtils.isBlank(proyecto.getLink())) {
            return new ResponseEntity(new Mensaje("incluir link del proyecto"), HttpStatus.BAD_REQUEST);

        }
        iProyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @DeleteMapping("/proyecto/borrar/{id}")
    public ResponseEntity deleteProyecto(@PathVariable Long id) {

        iProyectoService.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto borrado"), HttpStatus.OK);
    }

    @PutMapping("/proyecto/modificar")
    public ResponseEntity<Proyecto> modificarProyecto(@RequestBody Proyecto proyecto) {
        Proyecto proyectoModificada = iProyectoService.modificarProyecto(proyecto);
        return new ResponseEntity<>(proyectoModificada, HttpStatus.OK);
    }

    @GetMapping("/proyecto/buscar/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable("id") Long id) {
        Proyecto proyectoBuscado = iProyectoService.findProyecto(id);
        return new ResponseEntity<>(proyectoBuscado, HttpStatus.OK);
    }
}
