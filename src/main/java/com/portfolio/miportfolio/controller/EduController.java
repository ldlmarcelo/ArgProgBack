package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.Security.Controller.Mensaje;
import com.portfolio.miportfolio.iService.IEducacionService;
import com.portfolio.miportfolio.model.Educacion;
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
@CrossOrigin(origins = "https://argprogfront1.web.app/")
public class EduController {

    @Autowired
    private IEducacionService interEdu;

    @GetMapping("/Educacion/traer")
    public List<Educacion> getEducacion() {
        return interEdu.getEdu();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/Educacion/crear")
    public ResponseEntity createEdu(@RequestBody Educacion edu) {

        if (StringUtils.isBlank(edu.getInstitucion())) {
            return new ResponseEntity(new Mensaje("incluir Institucion"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(edu.getFecha())) {
            return new ResponseEntity(new Mensaje("incluir fecha"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(edu.getTitulo())) {
            return new ResponseEntity(new Mensaje("incluir titulo"), HttpStatus.BAD_REQUEST);
        }

        interEdu.saveEdu(edu);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @DeleteMapping("/Educacion/borrar/{id}")
    public ResponseEntity deleteEdu(@PathVariable Long id) {

        interEdu.deleteEdu(id);
        return new ResponseEntity(new Mensaje("Educación borrada"), HttpStatus.OK);
    }

    @PutMapping("/Educacion/modificar")
    public ResponseEntity<Educacion> modificarEducacion(@RequestBody Educacion edu) {
        Educacion educacionModificada = interEdu.modificarEdu(edu);
        return new ResponseEntity<>(educacionModificada, HttpStatus.OK);
    }

    @GetMapping("/Educacion/buscar/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable("id") Long id) {
        Educacion educacionBuscada = interEdu.findEdu(id);
        return new ResponseEntity<>(educacionBuscada, HttpStatus.OK);
    }

}
