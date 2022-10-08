package com.portfolio.miportfolio.service;

import com.portfolio.miportfolio.iService.IHardskillService;
import com.portfolio.miportfolio.model.Hardskill;
import com.portfolio.miportfolio.repository.HardskillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardskillService implements IHardskillService {

    @Autowired
    private HardskillRepository hardSkillRepo;

    @Override
    public List<Hardskill> getHardskill() {
        List<Hardskill> listaHardskill = hardSkillRepo.findAll();
        return listaHardskill;
    }

    @Override
    public void saveHardskill(Hardskill hardskill) {
        hardSkillRepo.save(hardskill);
    }

    @Override
    public void deleteHardskill(Long id) {
        hardSkillRepo.deleteById(id);
    }

    @Override
    public Hardskill findHardskill(Long id) {
        Hardskill softskill = hardSkillRepo.findById(id).orElse(null);
        return softskill;
    }

    @Override
    public Hardskill modificarHardskill(Hardskill hardskill) {
        return hardSkillRepo.save(hardskill);
    }

}