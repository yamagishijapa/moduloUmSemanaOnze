package br.com.fullstack.moduloumsemanaonze.repository;

import br.com.fullstack.moduloumsemanaonze.model.Caderno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadernoRepository extends JpaRepository<Caderno, Long> {

}
