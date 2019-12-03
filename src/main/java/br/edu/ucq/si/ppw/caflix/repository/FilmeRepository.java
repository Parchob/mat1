package br.edu.ucq.si.ppw.caflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ucq.si.ppw.caflix.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
