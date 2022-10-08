package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {

    public List<Educacion> getEdu();

    public void saveEdu(Educacion edu);

    public void deleteEdu(Long id);

    public Educacion findEdu(Long id);

    public Educacion modificarEdu(Educacion edu);

}
