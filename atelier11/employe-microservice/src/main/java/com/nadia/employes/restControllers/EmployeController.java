package com.nadia.employes.restControllers;

import com.nadia.employes.config.AuthorProperties;
import com.nadia.employes.dto.APIResponseDto;
import com.nadia.employes.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}