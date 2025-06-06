package br.com.arcelino.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcelino.bookstore.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
