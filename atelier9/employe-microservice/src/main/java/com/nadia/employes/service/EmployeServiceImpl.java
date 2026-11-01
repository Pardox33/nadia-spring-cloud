package com.nadia.employes.service;

import com.nadia.employes.dto.APIResponseDto;
import com.nadia.employes.dto.EmployeDto;
import com.nadia.employes.dto.EntrepriseDto;
import com.nadia.employes.entities.Employe;
import com.nadia.employes.repos.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).get();

        EntrepriseDto entrepriseDto = apiClient.getEntByCode(employe.getCodeEnt());

        EmployeDto employeDto = new EmployeDto(
                employe.getId(),
                employe.getPrenom(),
                employe.getNom(),
                employe.getCodeEnt(),
                entrepriseDto.getNomEnt()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeDto(employeDto);
        apiResponseDto.setEntrepriseDto(entrepriseDto);

        return apiResponseDto;
    }
}