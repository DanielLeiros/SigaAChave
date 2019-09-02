package br.com.sigaachave.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigaachave.domain.Reserva;
import br.com.sigaachave.domain.Usuario;
import br.com.sigaachave.enums.StatusReserva;
import br.com.sigaachave.repository.ReservaRepository;
import br.com.sigaachave.repository.UsuarioRepository;

@RestController
@RequestMapping("/sigaachave")
public class ReservaRestController {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/reservas", method = RequestMethod.GET)
	public ResponseEntity<List<Reserva>> all() {
		return new ResponseEntity<List<Reserva>>(reservaRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservas/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reserva> get(@PathVariable("id") Long id) {
		
		if(reservaRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Reserva>(reservaRepository.getOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservas/{id}/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<Reserva> remove(@PathVariable("id") Long id) {
		
		if(reservaRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		reservaRepository.deleteById(id);
		return new ResponseEntity<Reserva>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservas/adicionar/{sala}+{data}", method = RequestMethod.POST)
	public ResponseEntity<Reserva> add(Reserva reserva){
		
		reserva.setStatus(StatusReserva.PENDENTE);
		reservaRepository.save(reserva);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/reservas/{id}/atualizar/{sala}+{data}+{status}", method = RequestMethod.PUT)
	public ResponseEntity<Reserva> update(@PathVariable("id") Long id, Reserva reserva){
		
		if(reservaRepository.existsById(id) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		reservaRepository.save(reserva);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservas/{id}/usuario/{usuarioId}", method = RequestMethod.PUT)
	public ResponseEntity<Reserva> asign(@PathVariable("id") Long id, @PathVariable("usuarioId") Long usuarioId){
		
		if(reservaRepository.existsById(id) == false || usuarioRepository.existsById(usuarioId) == false) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Optional<Reserva> reserva = reservaRepository.findById(id);
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		reserva.get().setUsuario(usuario.get());
		
		reservaRepository.save(reserva.get());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
