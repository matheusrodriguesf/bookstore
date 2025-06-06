package br.com.arcelino.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arcelino.bookstore.dto.LivroFilter;
import br.com.arcelino.bookstore.dto.LivroResponse;
import br.com.arcelino.bookstore.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    @Query("""
            SELECT new br.com.arcelino.bookstore.dto.LivroResponse(
                livro.isbn as isbn,
                livro.titulo as titulo,
                livro.autor as autor,
                livro.editora as editora,
                livro.anoPublicacao as anoPublicacao,
                categoria.nome as categoria
            )
            FROM Livro livro
            JOIN livro.categoria categoria
            WHERE (:#{#filtro.titulo} IS NULL OR livro.titulo LIKE %:#{#filtro.titulo}%)
            AND (:#{#filtro.autor} IS NULL OR livro.autor LIKE %:#{#filtro.autor}%)
            AND (:#{#filtro.isbn} IS NULL OR livro.isbn = :#{#filtro.isbn})
            AND (:#{#filtro.editora} IS NULL OR livro.editora LIKE %:#{#filtro.editora}%)
            """)
    Page<LivroResponse> findLivro(LivroFilter filtro, Pageable pageable);

}
