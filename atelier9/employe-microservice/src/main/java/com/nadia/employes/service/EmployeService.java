package com.nadia.employes.service;

import com.nadia.employes.dto.APIResponseDto;

public interface EmployeService {
    APIResponseDto getEmployeById(Long id);
}