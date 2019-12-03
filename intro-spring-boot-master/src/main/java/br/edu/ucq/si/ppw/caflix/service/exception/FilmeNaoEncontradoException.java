package br.edu.ucq.si.ppw.caflix.service.exception;

public class FilmeNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
	}

	public FilmeNaoEncontradoException(String msg) {
		super(msg);
	}

}
