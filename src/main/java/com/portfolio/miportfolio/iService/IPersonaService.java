package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersona();

    public void savePersona(Persona persona);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);
    
    public Persona modificarPersona(Persona persona);
}
