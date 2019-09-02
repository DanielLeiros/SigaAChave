package br.com.sigaachave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigaachave.domain.Reserva;
import br.com.sigaachave.domain.Usuario;
import br.com.sigaachave.repository.ReservaRepository;
import br.com.sigaachave.repository.UsuarioRepository;

@RestController
@RequestMapping("/sigaachave")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> all() {
		return new ResponseEntity<List<Usuario>>(usuarioRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> get(@PathVariable("id") Long id) {
		
		if(usuarioRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usuarioRepository.getOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/{id}/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> remove(@PathVariable("id") Long id) {
		
		if(usuarioRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		usuarioRepository.deleteById(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/adicionar/{nome}+{senha}+{papel}", method = RequestMethod.POST)
	public ResponseEntity<Usuario> add(Usuario usuario){
		
		usuarioRepository.save(usuario);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/usuarios/{id}/atualizar/{nome}+{senha}+{papel}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@PathVariable("id") Long id, Usuario usuario){
		
		if(usuarioRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		usuarioRepository.save(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/{id}/reservas", method = RequestMethod.GET)
	public ResponseEntity<List<Reserva>> getByUser(@PathVariable("id") Long id){
		
		return new ResponseEntity<List<Reserva>>(reservaRepository.byUserId(id), HttpStatus.OK);
	}
}
