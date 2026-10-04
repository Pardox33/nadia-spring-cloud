package com.nadia.employes.service;

import com.nadia.employes.dto.EmployeDto;
import com.nadia.employes.entities.Employe;
import com.nadia.employes.repos.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;

    @Override
    public EmployeDto getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).get();
        return new EmployeDto(
                employe.getId(),
                employe.getPrenom(),
                employe.getNom()
        );
    }
}