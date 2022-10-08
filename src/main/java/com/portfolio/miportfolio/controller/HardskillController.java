
package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.Security.Controller.Mensaje;
import com.portfolio.miportfolio.iService.IHardskillService;
import com.portfolio.miportfolio.model.Hardskill;
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
public class HardskillController {
    @Autowired
    private IHardskillService iHardskillService;

    @GetMapping("/hardskill/traer")
    public List<Hardskill> getHardskill() {
        return iHardskillService.getHardskill();
    }

    @PostMapping("/hardskill/crear")
    public ResponseEntity createHardskill(@RequestBody Hardskill hardskill) {
        if (StringUtils.isBlank(hardskill.getIcon())) {
            return new ResponseEntity(new Mensaje("incluir ícono"), HttpStatus.BAD_REQUEST);

        }

        //voy a validar que el porcentaje sea solo nro en el front
        iHardskillService.saveHardskill(hardskill);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @DeleteMapping("/hardskill/borrar/{id}")
    public ResponseEntity deleteHardskill(@PathVariable Long id) {

        iHardskillService.deleteHardskill(id);
        return new ResponseEntity(new Mensaje("Hardskill borrado"), HttpStatus.OK);
    }

    @PutMapping("/hardskill/modificar")
    public ResponseEntity<Hardskill> modificarHardskill(@RequestBody Hardskill hardskill) {
        Hardskill hardskillModificada = iHardskillService.modificarHardskill(hardskill);
        return new ResponseEntity<>(hardskillModificada, HttpStatus.OK);
    }

    @GetMapping("/hardskill/buscar/{id}")
    public ResponseEntity<Hardskill> buscarHardskill(@PathVariable("id") Long id) {
        Hardskill hardskillBuscada = iHardskillService.findHardskill(id);
        return new ResponseEntity<>(hardskillBuscada, HttpStatus.OK);
    }
}
