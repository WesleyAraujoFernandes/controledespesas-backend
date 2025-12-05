package br.com.knowlege.controledespesas.mapper;

import org.springframework.stereotype.Component;

import br.com.knowlege.controledespesas.dto.CategoryDTO;
import br.com.knowlege.controledespesas.model.Category;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category entity) {
        if (entity == null)
            return null;
        return CategoryDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }

    public Category toEntity(CategoryDTO dto) {
        if (dto == null)
            return null;
        return Category.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .build();
    }
}
