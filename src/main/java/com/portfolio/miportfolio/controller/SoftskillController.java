package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.Security.Controller.Mensaje;
import com.portfolio.miportfolio.iService.ISoftskillService;
import com.portfolio.miportfolio.model.Softskill;
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
@CrossOrigin(origins = "https://argprogfront1.web.app")
public class SoftskillController {

    @Autowired
    private ISoftskillService iSoftkillService;

    @GetMapping("/softskill/traer")
    public List<Softskill> getSoftskill() {
        return iSoftkillService.getSoftskill();
    }

    @PostMapping("/softskill/crear")
    public ResponseEntity createSoftskill(@RequestBody Softskill softskill) {
        if (StringUtils.isBlank(softskill.getHabilidad())) {
            return new ResponseEntity(new Mensaje("incluir habilidad"), HttpStatus.BAD_REQUEST);

        }

        //voy a validar que el porcentaje sea solo nro en el front
        iSoftkillService.saveSoftskill(softskill);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @DeleteMapping("/softskill/borrar/{id}")
    public ResponseEntity deleteSoftskill(@PathVariable Long id) {

        iSoftkillService.deleteSoftskill(id);
        return new ResponseEntity(new Mensaje("Softskill borrado"), HttpStatus.OK);
    }

    @PutMapping("/softskill/modificar")
    public ResponseEntity<Softskill> modificarSoftskill(@RequestBody Softskill softskill) {
        Softskill softskillModificada = iSoftkillService.modificarSoftskill(softskill);
        return new ResponseEntity<>(softskillModificada, HttpStatus.OK);
    }

    @GetMapping("/softskill/buscar/{id}")
    public ResponseEntity<Softskill> buscarSoftskill(@PathVariable("id") Long id) {
        Softskill softskillBuscada = iSoftkillService.findSoftskill(id);
        return new ResponseEntity<>(softskillBuscada, HttpStatus.OK);
    }
}
