package br.com.arcelino.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.bookstore.dto.CategoriaResponse;
import br.com.arcelino.bookstore.service.CategoriaService;
import lombok.RequiredArgsConstructor;

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
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        var categoriaResponse = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaResponse);
    }

}
