package org.serratec.backend.projeto07.repositories;



import org.serratec.backend.projeto07.entities.Livraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrariaRepository extends JpaRepository <Livraria, Integer>{


}
