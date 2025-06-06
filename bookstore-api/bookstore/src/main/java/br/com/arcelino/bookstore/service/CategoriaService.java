package br.com.arcelino.bookstore.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.bookstore.dto.CategoriaForm;
import br.com.arcelino.bookstore.dto.CategoriaResponse;
import br.com.arcelino.bookstore.entity.Categoria;
import br.com.arcelino.bookstore.exception.NotFoundException;
import br.com.arcelino.bookstore.mapper.CategoriaMapper;
import br.com.arcelino.bookstore.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponse findByNome(String nome) {
        return categoriaMapper.toResponse(categoriaRepository.findByNome(nome));
    }

    public CategoriaResponse findById(Long id) {
        return categoriaMapper.toResponse(getCategoriaOrThrow(id));
    }

    public CategoriaResponse save(CategoriaForm categoriaForm) {
        var categoria = categoriaMapper.toEntity(categoriaForm);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toResponse(categoria);
    }

    public CategoriaResponse edit(Long id, CategoriaForm categoriaForm) {
        var categoria = getCategoriaOrThrow(id);
        categoriaMapper.updateEntity(categoriaForm, categoria);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toResponse(categoria);
    }

    public void delete(Long id) {
        var categoria = getCategoriaOrThrow(id);
        categoriaRepository.delete(categoria);
    }

    private Categoria getCategoriaOrThrow(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }
}
