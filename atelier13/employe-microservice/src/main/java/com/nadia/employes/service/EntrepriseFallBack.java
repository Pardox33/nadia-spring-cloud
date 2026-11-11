package com.nadia.employes.service;

import com.nadia.employes.dto.EntrepriseDto;
import org.springframework.stereotype.Component;

@Component
public class EntrepriseFallBack implements APIClient {

    @Override
    public EntrepriseDto getEntByCode(String entrepriseCode) {
        return null;
    }
}
