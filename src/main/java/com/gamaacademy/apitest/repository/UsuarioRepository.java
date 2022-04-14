package com.gamaacademy.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamaacademy.apitest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{ 
 
}
