package com.nadia.employes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private Long id;
    private String prenom;
    private String nom;
}