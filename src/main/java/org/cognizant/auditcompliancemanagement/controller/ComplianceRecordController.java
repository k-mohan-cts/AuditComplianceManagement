package org.cognizant.auditcompliancemanagement.controller;

import jakarta.validation.Valid;
import org.cognizant.auditcompliancemanagement.dto.request.ComplianceRecordRequestDTO;
import org.cognizant.auditcompliancemanagement.dto.response.ComplianceRecordResponseDTO;
import org.cognizant.auditcompliancemanagement.service.ComplianceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance-records")
public class ComplianceRecordController {

    @Autowired
    private ComplianceRecordService service;

    @PostMapping("/createComplianceRecord")
    public ResponseEntity<ComplianceRecordResponseDTO> create(@Valid @RequestBody ComplianceRecordRequestDTO request) {
        return ResponseEntity.ok(service.createRecord(request));
    }

    @GetMapping("/getAllComplianceRecord")
    public ResponseEntity<List<ComplianceRecordResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    @PutMapping("/updateComplianceRecord/{id}")
    public ResponseEntity<ComplianceRecordResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody ComplianceRecordRequestDTO request) {
        return ResponseEntity.ok(service.updateRecord(id, request));
    }
}