package org.serratec.backend.projeto06.repository;

import org.serratec.backend.projeto06.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Integer> {
	
}
