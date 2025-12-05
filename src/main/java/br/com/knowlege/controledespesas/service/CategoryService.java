package br.com.knowlege.controledespesas.service;

import java.util.List;

import br.com.knowlege.controledespesas.model.Category;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);

    Category update(Long id, Category category);
}
