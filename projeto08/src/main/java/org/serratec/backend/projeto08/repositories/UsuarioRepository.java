package org.serratec.backend.projeto08.repositories;

import org.serratec.backend.projeto08.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

	
}
