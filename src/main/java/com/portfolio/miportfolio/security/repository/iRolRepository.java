
package com.portfolio.miportfolio.Security.Repository;

import com.portfolio.miportfolio.Security.Entity.Rol;
import com.portfolio.miportfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
