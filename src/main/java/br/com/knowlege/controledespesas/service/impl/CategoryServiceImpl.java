package br.com.knowlege.controledespesas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.knowlege.controledespesas.model.Category;
import br.com.knowlege.controledespesas.repository.CategoryRepository;
import br.com.knowlege.controledespesas.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    @Override
    public Category update(Long id, Category category) {
        Category existingCategory = findById(id);
        if (existingCategory != null) {
            existingCategory.setDescription(category.getDescription());
            return repository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found");
        }
    }
}
