package br.com.arcelino.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.bookstore.dto.LivroFilter;
import br.com.arcelino.bookstore.dto.LivroForm;
import br.com.arcelino.bookstore.dto.LivroResponse;
import br.com.arcelino.bookstore.service.LivroService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<Page<LivroResponse>> findLivro(LivroFilter filtro, Pageable pageable) {
        Page<LivroResponse> livros = livroService.findLivro(filtro, pageable);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> findById(@PathVariable("id") Long id) {
        var livroResponse = livroService.findById(id);
        return ResponseEntity.ok(livroResponse);
    }

    @PostMapping
    public ResponseEntity<LivroResponse>create(@RequestBody LivroForm livroForm) {
        var livroResponse = livroService.create(livroForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> update(@PathVariable("id") Long id, @RequestBody LivroForm livroForm) {
        var livroResponse = livroService.update(id, livroForm);
        return ResponseEntity.ok(livroResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
    
}
