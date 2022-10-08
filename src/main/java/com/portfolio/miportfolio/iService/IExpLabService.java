package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.ExpLab;
import java.util.List;

public interface IExpLabService {

    public List<ExpLab> getExpLab();

    public void saveExpLab(ExpLab expe);

    public void deleteExpLab(Long id);

    public ExpLab findExpLab(Long id);

    public ExpLab modificarExperiencia(ExpLab experiencia);

}
