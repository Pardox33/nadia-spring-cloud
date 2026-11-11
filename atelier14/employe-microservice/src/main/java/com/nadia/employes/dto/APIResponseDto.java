package com.nadia.employes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeDto employeDto;
    private EntrepriseDto entrepriseDto;
}