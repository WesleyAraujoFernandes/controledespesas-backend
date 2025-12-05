package br.com.knowlege.controledespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knowlege.controledespesas.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
