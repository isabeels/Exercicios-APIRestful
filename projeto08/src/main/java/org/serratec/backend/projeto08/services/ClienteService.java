package org.serratec.backend.projeto08.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto08.dto.ClienteDTO;
import org.serratec.backend.projeto08.entities.ClienteEntity;
import org.serratec.backend.projeto08.exceptions.ClienteException;
import org.serratec.backend.projeto08.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteDTO entityToDTO(ClienteEntity cliente, ClienteDTO clienteDTO) {

		clienteDTO.setNomeCliente(cliente.getNomeCliente());
		clienteDTO.setCpfCliente(cliente.getCpfCliente());
		clienteDTO.setEmailCliente(cliente.getEmailCliente());
		clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
		
		
		

		return clienteDTO;
	}

	public ClienteEntity dtoToEntity(ClienteEntity cliente, ClienteDTO clienteDTO) {

		cliente.setNomeCliente(clienteDTO.getNomeCliente());
		cliente.setCpfCliente(clienteDTO.getCpfCliente());
		cliente.setEmailCliente(clienteDTO.getEmailCliente());
		cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
		
	

		return cliente;

	}

	public String salvar(ClienteDTO clienteDTO) {
		ClienteEntity cliente = new ClienteEntity();
		dtoToEntity(cliente, clienteDTO);
		clienteRepository.save(cliente);
		return "O cliente id: " + cliente.getIdCliente() + " foi criado com sucesso!";
	}

	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<ClienteEntity> cliente = clienteRepository.findById(idCliente);
		ClienteEntity clienteNoBanco = new ClienteEntity();
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			entityToDTO(clienteNoBanco, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("O id informado não foi encontrado!");
	}

	public String deletar(Integer idCliente) throws ClienteException {
		Optional<ClienteEntity> cliente = clienteRepository.findById(idCliente);
		if (cliente.isPresent()) {
		clienteRepository.deleteById(idCliente);
		return "O cliente id: " + cliente.get() + " foi deletado com sucesso!";
		}
		throw new ClienteException("O id informado não foi encontrado!");
	}

	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<ClienteEntity> cliente = clienteRepository.findById(idCliente);
		ClienteEntity clienteNoBanco = new ClienteEntity();
		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();

			if (clienteDTO.getCpfCliente() != null) {
				clienteNoBanco.setCpfCliente(clienteDTO.getCpfCliente());
			}
			if (clienteDTO.getEmailCliente() != null) {
				clienteNoBanco.setEmailCliente(clienteDTO.getEmailCliente());
			}
			if (clienteDTO.getNomeCliente() != null) {
				clienteNoBanco.setNomeCliente(clienteDTO.getNomeCliente());
			}
			if (clienteDTO.getTelefoneCliente() != null) {
				clienteNoBanco.setTelefoneCliente(clienteDTO.getTelefoneCliente());
			}
			

			clienteRepository.save(clienteNoBanco);
			return "O cliente com o id " + clienteNoBanco.getIdCliente() + " foi atualizado!";
		}
		throw new ClienteException("O cliente não foi atualizado.");
	}

	public List<ClienteDTO> buscarTodos() {
		List<ClienteEntity> listaClienteEntity = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();

		for (ClienteEntity cliente : listaClienteEntity) {
			ClienteDTO clienteDTO = new ClienteDTO();
			entityToDTO(cliente, clienteDTO);
			listaClienteDTO.add(clienteDTO);
		}

		return listaClienteDTO;
	}

	public void salvarListaCliente(List<ClienteDTO> listaClienteDTO) {

		for (ClienteDTO clienteDTO : listaClienteDTO) {
			ClienteEntity cliente = new ClienteEntity();
			dtoToEntity(cliente, clienteDTO);
			clienteRepository.save(cliente);
		}
	}

}
