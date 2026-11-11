package com.nadia.employes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeDto {
    private String prenom;
    private String nom;
    private String codeEnt;
    private String email;
    private String mobileNumber;
}