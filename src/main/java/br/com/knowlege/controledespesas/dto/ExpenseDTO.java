package br.com.knowlege.controledespesas.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private List<CategoryDTO> categories;
}