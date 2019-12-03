package br.edu.ucq.si.ppw.caflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Table(name = "filme")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@JsonProperty("id")
	private Long id;

	@NonNull
	@ToString.Include
	@JsonProperty("nome")
	@Column(name = "nome")
	private String nome;

	@JsonProperty("ano")
	@Column(name = "ano")
	private Integer ano;

	@JsonProperty("sinopse")
	@Column(name = "sinopse", length = 2500)
	private String sinopse;

	@JsonProperty("url_capa")
	@Column(name = "url_capa")
	private String urlCapa;

}
