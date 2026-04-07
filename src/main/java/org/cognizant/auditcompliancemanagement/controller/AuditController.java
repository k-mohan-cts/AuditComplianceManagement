package org.cognizant.auditcompliancemanagement.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.cognizant.auditcompliancemanagement.dto.request.AuditRequestDTO;
import org.cognizant.auditcompliancemanagement.dto.response.AuditResponseDTO;
import org.cognizant.auditcompliancemanagement.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/officer-status/{id}")
    public ResponseEntity<String> getStatusById(@PathVariable int id) {
        return ResponseEntity.ok(auditService.getOfficerStatus(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AuditResponseDTO> create(@Valid @RequestBody AuditRequestDTO request) {
        log.info("REST request to create Audit for Officer: {}", request.getOfficerId());
        return ResponseEntity.ok(auditService.createAudit(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuditResponseDTO>> getAll() {
        return ResponseEntity.ok(auditService.getAllAudits());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuditResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody AuditRequestDTO request) {
        return ResponseEntity.ok(auditService.updateAudit(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        auditService.deleteAudit(id);
        return ResponseEntity.ok("Audit deleted successfully");
    }
}