package br.com.arcelino.bookstore.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.bookstore.dto.CategoriaResponse;
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
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }

}
