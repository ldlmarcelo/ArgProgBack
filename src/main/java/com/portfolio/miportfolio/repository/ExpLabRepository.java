package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.model.ExpLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpLabRepository extends JpaRepository<ExpLab, Long> {

   

}
