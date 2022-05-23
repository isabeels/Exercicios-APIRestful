package org.serratec.backend.projeto06.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.entities.ContaBancaria;
import org.serratec.backend.projeto06.exceptions.ContaBancariaException;
import org.serratec.backend.projeto06.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {

	@Autowired
	ContaBancariaRepository contaBancariaRepository;


	public void adicionar(ContaBancaria conta) {
		contaBancariaRepository.save(conta);
	}
	 
	public void adicionarListaContas(List<ContaBancaria> listaContas) {
		contaBancariaRepository.saveAll(listaContas);
	}

	public void atualizar(Integer idConta, ContaBancaria conta) {
		ContaBancaria contaCliente = findById(idConta);

		if (conta.getTitular() != null) {
			contaCliente.setTitular(conta.getTitular());

		}

		if (conta.getNumeroConta() != null) {
			contaCliente.setNumeroConta(conta.getNumeroConta());
		}

		contaBancariaRepository.save(contaCliente);
	}
	
	
	public void deletar(Integer idConta) {
		contaBancariaRepository.deleteById(idConta);
	}

	public List<ContaBancaria> findAll(){
		return contaBancariaRepository.findAll();
	}
	
	
	public ContaBancaria findById(Integer idConta) {
		Optional<ContaBancaria> conta = contaBancariaRepository.findById(idConta);
		
		ContaBancaria contaCliente = new ContaBancaria();
		
		if (conta.isPresent()) {
			contaCliente = conta.get();
		}
		return contaCliente;
	}
		
	public void operacao (
			Integer idConta,
			String operacao,
			Double valorParam) throws ContaBancariaException {
			ContaBancaria contaCliente = findById(idConta);
			 
	
		if (operacao.equalsIgnoreCase("credito")) {
			contaCliente.setSaldo(valorParam + contaCliente.getSaldo());
		}
		if (operacao.equalsIgnoreCase("debito")){
			if (contaCliente.getSaldo() < valorParam) {
				throw new ContaBancariaException();
			} else {
				contaCliente.setSaldo(contaCliente.getSaldo() - valorParam);
			}
		}
		contaBancariaRepository.save(contaCliente);
	}
}
