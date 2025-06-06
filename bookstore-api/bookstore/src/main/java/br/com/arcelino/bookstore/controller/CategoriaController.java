package br.com.arcelino.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.bookstore.dto.CategoriaForm;
import br.com.arcelino.bookstore.dto.CategoriaResponse;
import br.com.arcelino.bookstore.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaResponse> findByNome(@RequestParam String nome) {
        var categoriaResponse = categoriaService.findByNome(nome);
        return ResponseEntity.ok(categoriaResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaResponse> findById(@PathVariable("id") Long id) {
        var categoriaResponse = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaResponse);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(@RequestBody CategoriaForm categoriaForm) {
        var categoriaResponse = categoriaService.save(categoriaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaResponse> edit(@PathVariable Long id, @RequestBody CategoriaForm categoriaForm) {
        var categoriaResponse = categoriaService.edit(id, categoriaForm);
        return ResponseEntity.ok(categoriaResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
