package com.nadia.employes.service;

import com.nadia.employes.dto.APIResponseDto;
import com.nadia.employes.dto.CreateEmployeDto;

public interface EmployeService {
    APIResponseDto getEmployeById(Long id);
    void createEmploye(CreateEmployeDto createEmployeDto);
    boolean updateCommunicationStatus(Long employeId);
}