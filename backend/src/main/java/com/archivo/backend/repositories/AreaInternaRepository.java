package com.archivo.backend.repositories;

import com.archivo.backend.entities.AreaInterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaInternaRepository extends JpaRepository<AreaInterna, Integer> {
}