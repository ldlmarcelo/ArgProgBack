package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.ISoftskillService;
import com.portfolio.miportfolio.model.Softskill;
import com.portfolio.miportfolio.repository.SoftskillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftskillService implements ISoftskillService {

    @Autowired
    private SoftskillRepository softSkillRepo;

    @Override
    public List<Softskill> getSoftskill() {
        List<Softskill> listaSoftskill = softSkillRepo.findAll();
        return listaSoftskill;
    }

    @Override
    public void saveSoftskill(Softskill softskill) {
        softSkillRepo.save(softskill);
    }

    @Override
    public void deleteSoftskill(Long id) {
        softSkillRepo.deleteById(id);
    }

    @Override
    public Softskill findSoftskill(Long id) {
        Softskill softskill = softSkillRepo.findById(id).orElse(null);
        return softskill;
    }

    @Override
    public Softskill modificarSoftskill(Softskill softskill) {
        return softSkillRepo.save(softskill);
    }

}
