package br.com.knowlege.controledespesas.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.knowlege.controledespesas.dto.ExpenseDTO;
import br.com.knowlege.controledespesas.model.Category;
import br.com.knowlege.controledespesas.model.Expense;

@Component
public class ExpenseMapper {

    private final CategoryMapper categoryMapper;

    public ExpenseMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public ExpenseDTO toDTO(Expense expense) {
        return ExpenseDTO.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .categories(
                        expense.getCategories()
                                .stream()
                                .map(categoryMapper::toDTO)
                                .toList())
                .build();
    }

    public Expense toEntity(ExpenseDTO dto, List<Category> categoriesFromDB) {
        return Expense.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .categories(categoriesFromDB)
                .build();
    }
}
