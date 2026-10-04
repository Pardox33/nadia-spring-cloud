package com.nadia.entreprise.service;

import com.nadia.entreprise.dto.EntrepriseDto;
import com.nadia.entreprise.entities.Entreprise;
import com.nadia.entreprise.repos.EntrepriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto getEntrepriseByCode(String code) {
        Entreprise ent = entrepriseRepository.findByCodeEnt(code);
        return new EntrepriseDto(
                ent.getId(),
                ent.getNomEnt(),
                ent.getCodeEnt()
        );
    }
}