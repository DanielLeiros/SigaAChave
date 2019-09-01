package br.com.sigaachave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigaachave.domain.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
