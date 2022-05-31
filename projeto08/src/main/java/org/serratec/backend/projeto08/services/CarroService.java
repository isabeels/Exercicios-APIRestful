package org.serratec.backend.projeto08.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto08.dto.CarroDTO;
import org.serratec.backend.projeto08.entities.CarroEntity;
import org.serratec.backend.projeto08.exceptions.CarroException;
import org.serratec.backend.projeto08.repositories.CarroRepository;
import org.serratec.backend.projeto08.repositories.ClienteRepository;
import org.serratec.backend.projeto08.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	public CarroDTO entityToDTO(CarroEntity carro, CarroDTO carroDTO) {

		
		carroDTO.setAnoCarro(carro.getAnoCarro());
		carroDTO.setMarcaCarro(carro.getMarcaCarro());
		carroDTO.setModeloCarro(carro.getModeloCarro());

		return carroDTO;
	}

	public CarroEntity dtoToEntity(CarroEntity carro, CarroDTO carroDTO) {

		
		carro.setAnoCarro(carroDTO.getAnoCarro());
		carro.setMarcaCarro(carroDTO.getMarcaCarro());
		carro.setModeloCarro(carroDTO.getModeloCarro());
		
		if(carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
	
		}

		return carro;

	}

	public String salvar(CarroDTO carroDTO) {
		CarroEntity carro = new CarroEntity();
		dtoToEntity(carro, carroDTO);
		carroRepository.save(carro);
		return "O carro id: " + carro.getIdCarro() + " foi criado com sucesso!";
	}

	public CarroDTO buscarPorId(Integer idCarro) throws CarroException{
		Optional<CarroEntity> carro = carroRepository.findById(idCarro);
		CarroEntity carroNoBanco = new CarroEntity();
		CarroDTO carroDTO = new CarroDTO();
		if (carro.isPresent()) {
			carroNoBanco = carro.get();
			entityToDTO(carroNoBanco, carroDTO);
			return carroDTO;
		}
		throw new CarroException("O id informado não foi encontrado!");
	}

	public String deletar(Integer idCarro) throws CarroException {
		Optional<CarroEntity> carro = carroRepository.findById(idCarro);
		if (carro.isPresent()) {
		carroRepository.deleteById(idCarro);
		return "O carro id: " + carro.get() + " foi deletado com sucesso!";
		}
		throw new CarroException("O id informado não foi encontrado!");
	}

	public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException {
		Optional<CarroEntity> carro = carroRepository.findById(idCarro);
		CarroEntity carroNoBanco = new CarroEntity();
		if (carro.isPresent()) {
			carroNoBanco = carro.get();

			
			if (carroDTO.getAnoCarro() != null) {
				carroNoBanco.setAnoCarro(carroDTO.getAnoCarro());
			}
			if (carroDTO.getMarcaCarro() != null) {
			carroNoBanco.setMarcaCarro(carroDTO.getMarcaCarro());
			}
			if (carroDTO.getModeloCarro() != null) {
				carroNoBanco.setModeloCarro(carroDTO.getModeloCarro());
			}
			

			carroRepository.save(carroNoBanco);
			return "O carro com o id " + carroNoBanco.getIdCarro() + " foi atualizado!";
		}
		throw new CarroException("O carro não foi atualizado.");
	}

	public List<CarroDTO> buscarTodos() {
		List<CarroEntity> listaCarroEntity = carroRepository.findAll();
		List<CarroDTO> listaCarroDTO = new ArrayList<>();

		for (CarroEntity carro : listaCarroEntity) {
			CarroDTO carroDTO = new CarroDTO();
			entityToDTO(carro, carroDTO);
			listaCarroDTO.add(carroDTO);
		}

		return listaCarroDTO;
	}

	public void salvarListaCarro(List<CarroDTO> listaCarroDTO) {

		for (CarroDTO carroDTO : listaCarroDTO) {
			CarroEntity carro = new CarroEntity();
			dtoToEntity(carro, carroDTO);
			carroRepository.save(carro);
		}
	}

	
}
