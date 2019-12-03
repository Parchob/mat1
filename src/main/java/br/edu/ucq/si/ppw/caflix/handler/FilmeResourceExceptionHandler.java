package br.edu.ucq.si.ppw.caflix.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.ucq.si.ppw.caflix.entity.Resposta;
import br.edu.ucq.si.ppw.caflix.service.exception.FilmeNaoEncontradoException;

@RestControllerAdvice
public class FilmeResourceExceptionHandler {

	@ExceptionHandler(FilmeNaoEncontradoException.class)
	public ResponseEntity<Resposta> handleFilmeNaoEncontradoException(FilmeNaoEncontradoException e) {
	//	Resposta resposta = Resposta.builder().status(404).mensagem("Nenhum recurso foi encontrado")
				//.causa(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null/* resposta */);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Resposta> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		//Resposta resposta = Resposta.builder().status(404).mensagem("Nenhum recurso foi encontrado")
			//	.causa(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null/* resposta */);
	}

}
