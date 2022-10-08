package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.Hardskill;
import java.util.List;

public interface IHardskillService {

    public List<Hardskill> getHardskill();

    public void saveHardskill(Hardskill hardskill);

    public void deleteHardskill(Long id);

    public Hardskill findHardskill(Long id);

    public Hardskill modificarHardskill(Hardskill softskill);
}