package org.serratec.backend.projeto08.repositories;

import java.util.List;

import org.serratec.backend.projeto08.dto.RelatorioDTO;
import org.serratec.backend.projeto08.entities.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {

	@Query (value="select\r\n"
			+ "c2.CLIENTE_TX_NOME as nomeCliente,\r\n"
			+ "c.CARRO_TX_MODELO as modeloCarro,\r\n"
			+ "s.SERVICO_TX_TIPO as tipoServico,\r\n"
			+ "s.SERVICO_NU_VALOR as valorServico\r\n"
			+ "from servico s join carro c on(s.CARRO_ID =c.carro_cd_id)\r\n"
			+ "join cliente c2 on(c2.cliente_cd_id=c.CLIENTE_ID)\r\n"
			+ "order by s.SERVICO_CD_ID \r\n"
			+ "desc\r\n"
			+ "limit 5", nativeQuery=true)
	List<RelatorioDTO> relatorio();
	
}
