package br.com.knowlege.controledespesas.service;

import java.util.List;

import br.com.knowlege.controledespesas.dto.ExpenseDTO;

public interface ExpenseService {
    ExpenseDTO save(ExpenseDTO expenseDTO);

    List<ExpenseDTO> findAll();

    ExpenseDTO findById(Long id);

    void deleteById(Long id);

    ExpenseDTO update(ExpenseDTO expenseDTO);
}
