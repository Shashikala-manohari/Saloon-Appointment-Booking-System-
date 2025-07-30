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
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long categoryId
    ){
        Set<ServiceOffering> serviceofferings = serviceOfferingService
                .getAllServiceBySalonId(salonId,categoryId);
        return ResponseEntity.ok(serviceofferings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(
            @PathVariable Long id
    ) throws Exception {
        ServiceOffering serviceoffering = serviceOfferingService
                .getServiceById(id);
        return ResponseEntity.ok(serviceoffering);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
            @PathVariable Set<Long> ids
    ){
        Set<ServiceOffering> serviceofferings = serviceOfferingService
                .getServicesByIds(ids);
        return ResponseEntity.ok(serviceofferings);
    }



}
