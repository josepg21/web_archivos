package com.archivo.backend.repositories;

import com.archivo.backend.entities.NuevoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<NuevoUsuario, Integer> {
    Optional<NuevoUsuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}