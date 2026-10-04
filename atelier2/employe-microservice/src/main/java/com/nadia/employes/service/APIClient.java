package com.nadia.employes.service;

import com.nadia.employes.dto.EntrepriseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "ENTREPRISE")
public interface APIClient {

    @GetMapping("/api/entreprises/{entreprise-code}")
    EntrepriseDto getEntByCode(@PathVariable("entreprise-code") String entrepriseCode);
}