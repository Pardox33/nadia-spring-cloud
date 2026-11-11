package com.nadia.employes.service;

import com.nadia.employes.dto.APIResponseDto;
import com.nadia.employes.dto.CreateEmployeDto;
import com.nadia.employes.dto.EmployeDto;
import com.nadia.employes.dto.EmployeMessageDto;
import com.nadia.employes.dto.EntrepriseDto;
import com.nadia.employes.entities.Employe;
import com.nadia.employes.exceptions.ResourceNotFoundException;
import com.nadia.employes.repos.EmployeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeServiceImpl.class);

    private EmployeRepository employeRepository;
    private APIClient apiClient;
    private StreamBridge streamBridge;

    @Override
    public APIResponseDto getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).get();

        EntrepriseDto entrepriseDto = apiClient.getEntByCode(employe.getCodeEnt());

        String nomEnt;
        if (entrepriseDto == null)
            nomEnt = "NOT AVAILABLE";
        else
            nomEnt = entrepriseDto.getNomEnt();

        EmployeDto employeDto = new EmployeDto(
                employe.getId(),
                employe.getPrenom(),
                employe.getNom(),
                employe.getCodeEnt(),
                nomEnt
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeDto(employeDto);
        apiResponseDto.setEntrepriseDto(entrepriseDto);
        return apiResponseDto;
    }

    @Override
    public void createEmploye(CreateEmployeDto dto) {
        Employe savedEmploye = employeRepository.save(Employe.builder()
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .codeEnt(dto.getCodeEnt())
                .email(dto.getEmail())
                .mobileNumber(dto.getMobileNumber())
                .build());
        sendCommunication(savedEmploye);
    }

    private void sendCommunication(Employe employe) {
        var employeMsgDto = new EmployeMessageDto(
                employe.getId(), employe.getEmail(), employe.getMobileNumber());
        log.info("Sending Communication request for the details: {}", employeMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", employeMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

    @Override
    public boolean updateCommunicationStatus(Long employeId) {
        boolean isUpdated = false;
        if (employeId != null) {
            Employe employe = employeRepository.findById(employeId).orElseThrow(
                    () -> new ResourceNotFoundException("Employe", "EmployeId", employeId.toString()));
            employe.setCommunicationDone(true);
            employeRepository.save(employe);
            isUpdated = true;
        }
        return isUpdated;
    }
}