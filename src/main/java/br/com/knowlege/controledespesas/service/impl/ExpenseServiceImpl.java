package br.com.knowlege.controledespesas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.knowlege.controledespesas.dto.ExpenseDTO;
import br.com.knowlege.controledespesas.mapper.ExpenseMapper;
import br.com.knowlege.controledespesas.model.Category;
import br.com.knowlege.controledespesas.model.Expense;
import br.com.knowlege.controledespesas.repository.CategoryRepository;
import br.com.knowlege.controledespesas.repository.ExpenseRepository;
import br.com.knowlege.controledespesas.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(
            ExpenseRepository expenseRepository,
            CategoryRepository categoryRepository,
            ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public ExpenseDTO save(ExpenseDTO dto) {

        List<Category> categories = dto.getCategories()
                .stream()
                .map(c -> categoryRepository.findById(c.getId())
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada: " + c.getId())))
                .toList();

        Expense entity = expenseMapper.toEntity(dto, categories);

        return expenseMapper.toDTO(expenseRepository.save(entity));
    }

    @Override
    public List<ExpenseDTO> findAll() {
        return expenseRepository.findAll()
                .stream()
                .map(expenseMapper::toDTO)
                .toList();
    }

    @Override
    public ExpenseDTO findById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        return expenseMapper.toDTO(expense);
    }

    @Override
    public void deleteById(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    @Override
    public ExpenseDTO update(ExpenseDTO dto) {

        // garante que existe
        this.findById(dto.getId());

        return save(dto);
    }

}
