package com.nadia.employes.restControllers;

import com.nadia.employes.config.AuthorProperties;
import com.nadia.employes.dto.APIResponseDto;
import com.nadia.employes.dto.CreateEmployeDto;
import com.nadia.employes.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeController {

    private EmployeService employeService;
    private AuthorProperties authorProperties;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeService.getEmployeById(id), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorProperties.getName() + " " + authorProperties.getEmail());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmploye(@RequestBody CreateEmployeDto createEmployeDto) {
        employeService.createEmploye(createEmployeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Employe created successfully");
    }
}