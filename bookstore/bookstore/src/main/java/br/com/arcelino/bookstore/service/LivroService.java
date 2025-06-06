package br.com.arcelino.bookstore.service;

import org.springframework.stereotype.Service;

import br.com.arcelino.bookstore.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
    
}
