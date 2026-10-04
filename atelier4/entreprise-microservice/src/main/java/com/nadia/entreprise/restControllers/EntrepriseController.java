package com.nadia.entreprise.restControllers;

import com.nadia.entreprise.dto.EntrepriseDto;
import com.nadia.entreprise.service.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entreprises")
@AllArgsConstructor
public class EntrepriseController {

    private EntrepriseService entrepriseService;

    @GetMapping("{code}")
    public ResponseEntity<EntrepriseDto> getEntByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(
                entrepriseService.getEntrepriseByCode(code), HttpStatus.OK);
    }
}