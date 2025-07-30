package com.salon.controller;

import com.salon.dto.CategoryDTO;
import com.salon.dto.SalonDTO;
import com.salon.dto.ServiceDTO;
import com.salon.modal.ServiceOffering;
import com.salon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping()
    public ResponseEntity<ServiceOffering> createService(
           @RequestBody ServiceDTO serviceDTO
    ){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceofferings = serviceOfferingService
                .createService(salonDTO,serviceDTO,categoryDTO);

        return ResponseEntity.ok(serviceofferings);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
           @PathVariable Long id,
           @RequestBody ServiceOffering serviceOffering
    ) throws Exception {

        ServiceOffering serviceofferings = serviceOfferingService
                .updateService(id,serviceOffering);

        return ResponseEntity.ok(serviceofferings);
    }
}
