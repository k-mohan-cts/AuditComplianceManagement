package org.cognizant.auditcompliancemanagement.service;

import org.cognizant.auditcompliancemanagement.Enum.ComplianceResult;
import org.cognizant.auditcompliancemanagement.client.UserService;
import org.cognizant.auditcompliancemanagement.dao.ComplianceRecordRepository;
import org.cognizant.auditcompliancemanagement.dto.request.ComplianceRecordRequestDTO;
import org.cognizant.auditcompliancemanagement.dto.request.UserRequestDTO;
import org.cognizant.auditcompliancemanagement.dto.response.ComplianceRecordResponseDTO;
import org.cognizant.auditcompliancemanagement.entity.ComplianceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplianceRecordService {

    @Autowired
    private ComplianceRecordRepository repository;

    @Autowired
    private UserService userService; // The Feign Client

    public ComplianceRecordResponseDTO createRecord(ComplianceRecordRequestDTO request) {
        // 1. Fetch and Validate Officer via Feign
        if (request.getOfficerId() != null) {
            UserRequestDTO officer = userService.FetchUserById(request.getOfficerId());
            if (officer == null) {
                throw new RuntimeException("Compliance Officer not found with ID: " + request.getOfficerId());
            }
        }

        // 2. Logic: Default to PENDINGREVIEW
        ComplianceResult finalResult = (request.getResult() == null)
                ? ComplianceResult.PENDINGREVIEW : request.getResult();

        // 3. Build Entity (Mapping DTO -> Entity)
        ComplianceRecord record = ComplianceRecord.builder()
                .entityId(request.getEntityId())
                .type(request.getType())
                .result(finalResult)
                .date(LocalDateTime.now())
                .officerId(request.getOfficerId()) // Store ID, not the whole object
                .notes(request.getNotes())
                .build();

        return mapToResponse(repository.save(record));
    }

    public List<ComplianceRecordResponseDTO> getAllRecords() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ComplianceRecordResponseDTO updateRecord(Integer id, ComplianceRecordRequestDTO request) {
        ComplianceRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compliance Record not found"));

        // 4. Update Officer (Verify via Feign if ID is provided)
        if (request.getOfficerId() != null) {
            UserRequestDTO officer = userService.FetchUserById(request.getOfficerId());
            if (officer == null) {
                throw new RuntimeException("Officer not found with ID: " + request.getOfficerId());
            }
            record.setOfficerId(request.getOfficerId());
        }

        if (request.getResult() != null) {
            record.setResult(request.getResult());
        }

        record.setNotes(request.getNotes());

        return mapToResponse(repository.save(record));
    }

    // Helper method for DTO conversion
    private ComplianceRecordResponseDTO mapToResponse(ComplianceRecord record) {
        return ComplianceRecordResponseDTO.builder()
                .complianceId(record.getComplianceId())
                .entityId(record.getEntityId())
                .type(record.getType())
                .result(record.getResult())
                .date(record.getDate())
                .officerId(record.getOfficerId()) // Returning the ID stored in DB
                .notes(record.getNotes())
                .build();
    }
}