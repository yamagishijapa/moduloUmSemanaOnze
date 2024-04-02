package br.com.fullstack.moduloumsemanaonze.repository;

import br.com.fullstack.moduloumsemanaonze.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
