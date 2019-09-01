package br.com.sigaachave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sigaachave.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
	@Query(value = "SELECT * FROM RESERVA WHERE usuario_id = ?1",nativeQuery = true)
	List<Reserva> byUserId(Long id);
}
