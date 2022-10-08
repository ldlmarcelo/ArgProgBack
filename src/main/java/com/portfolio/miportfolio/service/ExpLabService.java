package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.IExpLabService;
import com.portfolio.miportfolio.model.ExpLab;
import com.portfolio.miportfolio.repository.ExpLabRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpLabService implements IExpLabService {

    @Autowired
    private ExpLabRepository expLabRepository;

    @Override
    public List<ExpLab> getExpLab() {
        List<ExpLab> listaExpLab = expLabRepository.findAll();
        return listaExpLab;
    }

    @Override
    public void saveExpLab(ExpLab expe) {
        expLabRepository.save(expe);
    }

    @Override
    public void deleteExpLab(Long id) {
        expLabRepository.deleteById(id);
    }

    @Override
    public ExpLab findExpLab(Long id) {
        ExpLab pers = expLabRepository.findById(id).orElse(null);
        return pers;
    }

    @Override
    public ExpLab modificarExperiencia(ExpLab experiencia) {
        return expLabRepository.save(experiencia);
    }
    
    




  

}
