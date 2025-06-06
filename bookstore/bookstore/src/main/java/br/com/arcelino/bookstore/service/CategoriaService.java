package br.com.arcelino.bookstore.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.bookstore.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
}
