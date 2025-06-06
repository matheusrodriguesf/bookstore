package br.com.arcelino.bookstore.mapper;

import org.mapstruct.Mapper;

import br.com.arcelino.bookstore.dto.CategoriaResponse;
import br.com.arcelino.bookstore.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponse toResponse(Categoria categoria);

}
