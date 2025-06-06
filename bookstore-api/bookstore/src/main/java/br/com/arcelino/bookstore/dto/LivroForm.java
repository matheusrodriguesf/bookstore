package br.com.arcelino.bookstore.dto;

public record LivroForm(String titulo, String autor, String isbn, String editora, Integer anoPublicacao,
        String sinopse, Long categoria) {

}
