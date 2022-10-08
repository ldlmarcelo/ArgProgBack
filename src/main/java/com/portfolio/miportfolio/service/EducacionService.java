package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.IEducacionService;
import com.portfolio.miportfolio.model.Educacion;
import com.portfolio.miportfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository eduRepo;

    @Override
    public List<Educacion> getEdu() {
        List<Educacion> listaEdu = eduRepo.findAll();
        return listaEdu;
    }

    @Override
    public void saveEdu(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void deleteEdu(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion findEdu(Long id) {
        Educacion edu = eduRepo.findById(id).orElse(null);
        return edu;
    }

    @Override
    public Educacion modificarEdu(Educacion edu) {
        return eduRepo.save(edu);
    }

}
