package org.cognizant.auditcompliancemanagement.service;

import org.cognizant.auditcompliancemanagement.Enum.AuditStatus;
import org.cognizant.auditcompliancemanagement.dao.AuditRepository;
import org.cognizant.auditcompliancemanagement.dto.request.AuditRequestDTO;
import org.cognizant.auditcompliancemanagement.dto.response.AuditResponseDTO;
import org.cognizant.auditcompliancemanagement.entity.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

//   // @Autowired
//   // private UserRepository userRepository;
//
//    public AuditResponseDTO createAudit(AuditRequestDTO request) {
//        // Business Logic 1: Verify the Officer exists in the User table
//        User officer = null;//userRepository.findById(request.getOfficerId())
//                //.orElseThrow(() -> new RuntimeException("Compliance Officer not found with ID: " + request.getOfficerId()));
//
//        // Business Logic 2: Default Status and Timestamps
//        AuditStatus finalStatus = (request.getStatus() == null) ? AuditStatus.SCHEDULED : request.getStatus();
//        LocalDateTime now = LocalDateTime.now();
//
//        Audit audit = Audit.builder()
//                .officer(officer)
//                .scope(request.getScope())
//                .findings(request.getFindings())
//                .status(finalStatus)
//                .date(now)
//                .updatedAt(now)
//                .build();
//
//        return mapToResponse(auditRepository.save(audit));
//    }
//
//    public List<AuditResponseDTO> getAllAudits() {
//        return auditRepository.findAll().stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    public AuditResponseDTO updateAudit(Integer id, AuditRequestDTO request) {
//        Audit existingAudit = auditRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Audit Record not found"));
//
//        // Business Logic 3: Selective Update & Timestamp refresh
//        existingAudit.setScope(request.getScope());
//        existingAudit.setFindings(request.getFindings());
//        existingAudit.setUpdatedAt(LocalDateTime.now());
//
//        if (request.getStatus() != null) {
//            existingAudit.setStatus(request.getStatus());
//        }
//
//        return mapToResponse(auditRepository.save(existingAudit));
//    }
//
//    public void deleteAudit(Integer id) {
//        auditRepository.deleteById(id);
//    }
//
//    // Helper method for DTO conversion
//    private AuditResponseDTO mapToResponse(Audit audit) {
//        return AuditResponseDTO.builder()
//                .auditId(audit.getAuditId())
//                .officerId(audit.getOfficer().getUserId())
//                .scope(audit.getScope())
//                .findings(audit.getFindings())
//                .status(audit.getStatus())
//                .date(audit.getDate())
//                .updatedAt(audit.getUpdatedAt())
//                .build();
//    }
}