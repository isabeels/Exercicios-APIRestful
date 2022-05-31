package org.serratec.backend.projeto08.repositories;

import org.serratec.backend.projeto08.entities.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository <CarroEntity, Integer>{

}
