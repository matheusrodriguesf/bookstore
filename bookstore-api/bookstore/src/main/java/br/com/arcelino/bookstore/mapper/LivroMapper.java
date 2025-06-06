package br.com.arcelino.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import br.com.arcelino.bookstore.dto.LivroForm;
import br.com.arcelino.bookstore.dto.LivroResponse;
import br.com.arcelino.bookstore.entity.Categoria;
import br.com.arcelino.bookstore.entity.Livro;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    @Mapping(target = "categoria", source = "categoria")
    Livro toEntity(LivroForm form, Categoria categoria);

    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "categoriaToString")
    LivroResponse toResponse(Livro livro);

    void updateEntity(LivroForm livroForm, @MappingTarget Livro livro);

    @Named("categoriaToString")
    static String categoriaToString(Categoria categoria) {
        return categoria != null ? categoria.getNome() : null;
    }


    
}