package com.portfolio.miportfolio.iService;

import com.portfolio.miportfolio.model.Softskill;
import java.util.List;

public interface ISoftskillService {

    public List<Softskill> getSoftskill();

    public void saveSoftskill(Softskill softskill);

    public void deleteSoftskill(Long id);

    public Softskill findSoftskill(Long id);

    public Softskill modificarSoftskill(Softskill softskill);
}
