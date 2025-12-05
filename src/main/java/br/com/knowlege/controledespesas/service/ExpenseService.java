package br.com.knowlege.controledespesas.service;

import java.util.List;

import br.com.knowlege.controledespesas.model.Expense;

public interface ExpenseService {
    Expense save(Expense expense);

    List<Expense> findAll();

    Expense findById(Long id);

    void deleteById(Long id);

    Expense update(Long id, Expense expense);
}
