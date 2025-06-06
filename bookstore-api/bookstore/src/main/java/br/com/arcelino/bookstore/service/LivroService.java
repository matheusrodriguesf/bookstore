package br.com.arcelino.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.arcelino.bookstore.dto.LivroFilter;
import br.com.arcelino.bookstore.dto.LivroForm;
import br.com.arcelino.bookstore.dto.LivroResponse;
import br.com.arcelino.bookstore.entity.Categoria;
import br.com.arcelino.bookstore.mapper.LivroMapper;
import br.com.arcelino.bookstore.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public Page<LivroResponse> findLivro(LivroFilter filtro, Pageable pageable) {
        return livroRepository.findLivro(filtro, pageable);
    }

    public LivroResponse findById(Long id) {
        var livro = livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + id));
        return livroMapper.toResponse(livro);
    }

    public LivroResponse create(LivroForm livroForm) {
        var livro = livroMapper.toEntity(livroForm, Categoria.builder()
                .id(livroForm.categoria())
                .build());

        livro = livroRepository.save(livro);
        return livroMapper.toResponse(livro);

    }

    public LivroResponse update(Long id, LivroForm livroForm) {
        var livro = livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + id));

        livroMapper.updateEntity(livroForm, livro);
        livro = livroRepository.save(livro);
        return livroMapper.toResponse(livro);
    }

    public void delete(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Livro não encontrado com o ID: " + id);
        }
        livroRepository.deleteById(id);
    }
    
    
}
