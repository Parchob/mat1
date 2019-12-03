package br.edu.ucq.si.ppw.caflix.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ucq.si.ppw.caflix.entity.Filme;
import br.edu.ucq.si.ppw.caflix.service.FilmeService;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*")
public class FilmeResource {

	@Autowired
	private FilmeService filmes;

	@GetMapping
	public List<Filme> filmes() {
		return filmes.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Filme filmePorId(@PathVariable Long id) {
		return filmes.findById(id);
	}

	@PostMapping
	public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
		return ResponseEntity.ok(filmes.save(filme));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		filmes.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Filme> editar(@PathVariable Long id, @RequestBody Filme filme) {
		Filme atualizado = filmes.update(id, filme);
		return ResponseEntity.ok(atualizado);
	}
}