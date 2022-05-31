package org.serratec.backendprojeto05.projeto05.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backendprojeto05.projeto05.DTO.ClienteDTO;
import org.serratec.backendprojeto05.projeto05.exceptions.ClienteException;
import org.serratec.backendprojeto05.projeto05.model.Cliente;
import org.serratec.backendprojeto05.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public void salvar(ClienteDTO clienteDTO) throws ClienteException {
		
		Cliente cliente = new Cliente();
		Cliente clienteSalvar = new Cliente();
		clienteSalvar =  transformarClienteDTOEmClienteModel(clienteDTO, cliente);
		
		clienteRepository.save(clienteSalvar);
	}
	
	
	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) throws ClienteException {
		
		//nao setamos o id pois o mesmo é automatico na classe clienteDTO.setIdCliente(cliente.getIdCliente());
		if(clienteDTO.getCpf() == null) {
			throw new ClienteException("CPF nao informado");
		}
		if(clienteDTO.getEmail() == null) {
			throw new ClienteException("Email nao informado");
		}
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());

		return cliente;
	}
	
	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {
		
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
				
		return clienteDTO;
		
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		
		//cliente vazio
		Cliente clienteNoBanco= new Cliente();
		//clienteDTO vazio
		ClienteDTO clienteDTO = new ClienteDTO();
		
		if(cliente.isPresent()) {
			//cliente vazio recebe cliente do banco
			clienteNoBanco = cliente.get();
			clienteDTO = transformarClienteModelEmClienteDTO(clienteDTO,clienteNoBanco);
			
			return clienteDTO;
		}
		throw new ClienteException("Cliente nao encontrado");	
	}
	
	public void atualizar(Integer idCliente, ClienteDTO clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getDataNascimento() != null) {
				clienteNoBanco.setDataNascimento(clienteDTO.getDataNascimento());
			}
			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}
			if (clienteDTO.getNome() != null) {
				clienteNoBanco.setNome(clienteDTO.getNome());
			}
			if (clienteDTO.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}
			clienteRepository.save(clienteNoBanco);
		}
	}
	
	public void delete(Integer idCliente) {
		 clienteRepository.deleteById(idCliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	public void salvarTodos(List<Cliente> listaCliente) {
		clienteRepository.saveAll(listaCliente);
	}

}