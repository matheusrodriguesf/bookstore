package br.com.arcelino.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.arcelino.bookstore.dto.CategoriaForm;
import br.com.arcelino.bookstore.dto.CategoriaResponse;
import br.com.arcelino.bookstore.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponse toResponse(Categoria categoria);

    Categoria toEntity(CategoriaForm categoriaForm);

    void updateEntity(CategoriaForm categoriaForm, @MappingTarget Categoria categoria);

}
