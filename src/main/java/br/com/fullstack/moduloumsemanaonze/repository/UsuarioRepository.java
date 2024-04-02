package br.com.fullstack.moduloumsemanaonze.repository;

import br.com.fullstack.moduloumsemanaonze.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
