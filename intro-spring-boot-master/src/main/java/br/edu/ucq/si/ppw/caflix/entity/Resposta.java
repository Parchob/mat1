package br.edu.ucq.si.ppw.caflix.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resposta {

	private int status;
	private String mensagem;
	private String causa;
}
