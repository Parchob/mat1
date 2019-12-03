package br.edu.ucq.si.ppw.caflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ucq.si.ppw.caflix.entity.Filme;
import br.edu.ucq.si.ppw.caflix.repository.FilmeRepository;
import br.edu.ucq.si.ppw.caflix.service.exception.FilmeNaoEncontradoException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmes;

	public List<Filme> findAll() {
		return filmes.findAll();
	}

	public Filme save(Filme filme) {
		return filmes.save(filme);
	}

	public void deleteById(Long id) {
		try {
			filmes.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new FilmeNaoEncontradoException();
		}
	}

	public Filme findById(Long id) {
		return filmes.findById(id).orElse(null);
	}

	public Filme update(Long id, Filme filme) {
		filme.setId(id);
		return filmes.save(filme);
	}

}
