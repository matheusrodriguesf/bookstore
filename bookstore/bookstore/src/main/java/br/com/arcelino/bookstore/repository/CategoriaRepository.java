package br.com.arcelino.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcelino.bookstore.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
