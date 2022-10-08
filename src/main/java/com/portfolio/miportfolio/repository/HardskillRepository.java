package com.portfolio.miportfolio.repository;

import com.portfolio.miportfolio.model.Hardskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardskillRepository extends JpaRepository<Hardskill, Long> {

}
