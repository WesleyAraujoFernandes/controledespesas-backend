package br.com.knowlege.controledespesas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.knowlege.controledespesas.model.Expense;
import br.com.knowlege.controledespesas.repository.ExpenseRepository;
import br.com.knowlege.controledespesas.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense save(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public List<Expense> findAll() {
        return repository.findAll();
    }

    @Override
    public Expense findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Expense update(Long id, Expense expense) {
        Expense existingExpense = findById(id);
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setDate(expense.getDate());
        existingExpense.setCategory(expense.getCategory());
        return repository.save(existingExpense);
    }

}
