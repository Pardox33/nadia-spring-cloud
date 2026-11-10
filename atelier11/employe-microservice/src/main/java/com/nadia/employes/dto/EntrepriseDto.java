package com.nadia.employes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDto {
    private Long id;
    private String nomEnt;
    private String codeEnt;
}