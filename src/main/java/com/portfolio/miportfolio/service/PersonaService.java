package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.IPersonaService;
import com.portfolio.miportfolio.model.Persona;
import com.portfolio.miportfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona pers) {
        personaRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona pers = personaRepository.findById(id).orElse(null);
        return pers;
    }
    
       @Override
    public Persona modificarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

}
