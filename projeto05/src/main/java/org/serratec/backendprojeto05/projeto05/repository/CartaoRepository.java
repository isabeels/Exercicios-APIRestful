package org.serratec.backendprojeto05.projeto05.repository;

import org.serratec.backendprojeto05.projeto05.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
