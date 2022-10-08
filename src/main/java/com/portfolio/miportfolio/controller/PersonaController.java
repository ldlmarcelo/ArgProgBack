package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.iService.IPersonaService;
import com.portfolio.miportfolio.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://argprogfront1.web.app/")
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @GetMapping("/persona/traer")
    public List<Persona> getPersonas() {
        return interPersona.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona pers) {
        interPersona.savePersona(pers);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {

        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/persona/modificar")
    public ResponseEntity<Persona> modificarPersona(@RequestBody Persona persona) {
        Persona personaModificada = interPersona.modificarPersona(persona);
        return new ResponseEntity<>(personaModificada, HttpStatus.OK);
    }

    @GetMapping("persona/traer/perfil")
    public Persona traerPersona() {
        return interPersona.findPersona((long) 6);
    }

}
