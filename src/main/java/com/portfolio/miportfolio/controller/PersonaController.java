package com.portfolio.miportfolio.controller;

import com.portfolio.miportfolio.iService.IPersonaService;
import com.portfolio.miportfolio.model.Persona;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("persona/editar/{id}")

    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("profesion") String nuevoProfesion,
            @RequestParam("acerca_de") String nuevoAcerca_de,
            @RequestParam("direccion") String nuevoDireccion,
            @RequestParam("linkedin") String nuevoLinkedin,
            @RequestParam("github") String nuevoGithub,
            @RequestParam("foto") String nuevoFoto) {
        Persona pers = interPersona.findPersona(id);

        pers.setNombre(nuevoNombre);
        pers.setApellido(nuevoApellido);
        pers.setProfesion(nuevoProfesion);
        pers.setAcerca_de(nuevoAcerca_de);
        pers.setDireccion(nuevoDireccion);
        pers.setFoto(nuevoFoto);
        pers.setLinkedin(nuevoLinkedin);
        pers.setGithub(nuevoGithub);
        interPersona.savePersona(pers);
        return pers;
    }

    @GetMapping("persona/traer/perfil")
    public Persona traerPersona() {
        return interPersona.findPersona((long) 6);
    }

}
