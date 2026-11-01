package com.nadia.entreprise.restControllers;

import com.nadia.entreprise.config.AuthorProperties;
import com.nadia.entreprise.dto.EntrepriseDto;
import com.nadia.entreprise.service.EntrepriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/entreprises")
@RequiredArgsConstructor
public class EntrepriseController {

    private final EntrepriseService entrepriseService;
    private final AuthorProperties authorProperties;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{code}")
    public ResponseEntity<EntrepriseDto> getEntByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(
                entrepriseService.getEntrepriseByCode(code), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorProperties.getName() + " " + authorProperties.getEmail());
    }
}