package br.com.springboot.curso_jdev.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.springboot.curso_jdev.model.Apolices;

@Repository
public interface ApolicesRepository extends JpaRepository<Apolices, Long> {
	
	@Query (value = "select u from Apolices u where upper(trim(u.numero_apolice)) like %?1%")       
	List<Apolices> buscarPorApolicesList (String numero_apolice); 

}
