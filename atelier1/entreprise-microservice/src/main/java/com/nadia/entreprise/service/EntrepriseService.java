package com.nadia.entreprise.service;

import com.nadia.entreprise.dto.EntrepriseDto;

public interface EntrepriseService {
    EntrepriseDto getEntrepriseByCode(String code);
}