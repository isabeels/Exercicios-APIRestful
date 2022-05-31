package org.serratec.backend.projeto08.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.projeto08.dto.RelatorioDTO;
import org.serratec.backend.projeto08.dto.ServicoDTO;
import org.serratec.backend.projeto08.entities.ServicoEntity;
import org.serratec.backend.projeto08.exceptions.EmailException;
import org.serratec.backend.projeto08.exceptions.ServicoException;
import org.serratec.backend.projeto08.repositories.CarroRepository;
import org.serratec.backend.projeto08.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;

	public ServicoDTO entityToDTO(ServicoEntity servico, ServicoDTO servicoDTO) {

	
		servicoDTO.setDataServico(servico.getDataServico());
		servicoDTO.setTipoServico(servico.getTipoServico());
		servicoDTO.setValorServico(servico.getValorServico());
		
		return servicoDTO;
	}

	public ServicoEntity dtoToEntity(ServicoEntity servico, ServicoDTO servicoDTO) {

		
		servico.setDataServico(servicoDTO.getDataServico());
		servico.setTipoServico(servicoDTO.getTipoServico());
		servico.setValorServico(servicoDTO.getValorServico());
		
		if(servicoDTO.getIdCarro() != null) {
			servico.setCarro(carroRepository.findById(servicoDTO.getIdCarro()).get());	
		}
		
		return servico;

	}

	public String salvar(ServicoDTO servicoDTO) throws MessagingException, EmailException  {
		ServicoEntity servico = new ServicoEntity();
		dtoToEntity(servico, servicoDTO);
		servicoRepository.save(servico);
		emailService.emailTeste(servicoDTO);
		return "O serviço id: " + servico.getIdServico() + " foi criado com sucesso!!";
	}

	public ServicoDTO buscarPorId(Integer idServico) throws ServicoException {
		Optional<ServicoEntity> servico = servicoRepository.findById(idServico);
		ServicoEntity servicoNoBanco = new ServicoEntity();
		ServicoDTO servicoDTO = new ServicoDTO();
		if (servico.isPresent()) {
			servicoNoBanco = servico.get();
			entityToDTO(servicoNoBanco, servicoDTO);
			return servicoDTO;
		}
		throw new ServicoException("O id informado não foi encontrado!");
	}

	public String deletar(Integer idServico) throws ServicoException {
		Optional<ServicoEntity> servico = servicoRepository.findById(idServico);
		if (servico.isPresent()) {
		servicoRepository.deleteById(idServico);
		return "O serviço id: " + servico.get() + " foi deletado com sucesso!";
		}
		throw new ServicoException("O id informado não foi encontrado!");
	}

	public String atualizar(Integer idServico, ServicoDTO servicoDTO) throws ServicoException  {
		Optional<ServicoEntity> servico = servicoRepository.findById(idServico);
		ServicoEntity servicoNoBanco = new ServicoEntity();
		if (servico.isPresent()) {
			servicoNoBanco = servico.get();

			if (servicoDTO.getDataServico() != null) {
		servicoNoBanco.setDataServico(servicoDTO.getDataServico());
			}
			if (servicoDTO.getTipoServico() != null) {
			servicoNoBanco.setTipoServico(servicoDTO.getTipoServico());
			}
			if (servicoDTO.getValorServico() != null) {
		servicoNoBanco.setValorServico(servicoDTO.getValorServico());
			}

			servicoRepository.save(servicoNoBanco);
			return "O serviço com o id " + servicoNoBanco.getIdServico() + " foi atualizado!";
		}
		throw new ServicoException("O serviço não foi atualizado.");
	}

	public List<ServicoDTO> buscarTodos() {
		List<ServicoEntity> listaServicoEntity = servicoRepository.findAll();
		List<ServicoDTO> listaServicoDTO = new ArrayList<>();

		for (ServicoEntity servico : listaServicoEntity) {
			ServicoDTO servicoDTO = new ServicoDTO();
			entityToDTO(servico, servicoDTO);
			listaServicoDTO.add(servicoDTO);
		}

		return listaServicoDTO;
	}

	public void salvarListaServico(List<ServicoDTO> listaServicoDTO) {

		for (ServicoDTO servicoDTO : listaServicoDTO) {
			ServicoEntity servico = new ServicoEntity();
			dtoToEntity(servico, servicoDTO);
			servicoRepository.save(servico);
		}
	}
	
	public List<RelatorioDTO> relatorio(){
		return servicoRepository.relatorio();
	}

}
