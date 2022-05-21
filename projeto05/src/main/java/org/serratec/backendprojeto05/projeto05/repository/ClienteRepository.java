package org.serratec.backendprojeto05.projeto05.repository;

import org.serratec.backendprojeto05.projeto05.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
