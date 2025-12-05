package br.com.knowlege.controledespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knowlege.controledespesas.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
