package br.com.arcelino.bookstore.dto;

public record LivroResponse(String isbn, String titulo, String autor, String editora, Integer anoPublicacao, String categoria) {

}