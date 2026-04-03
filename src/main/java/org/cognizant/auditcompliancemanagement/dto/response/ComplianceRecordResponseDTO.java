package org.cognizant.auditcompliancemanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cognizant.auditcompliancemanagement.Enum.ComplainceType;
import org.cognizant.auditcompliancemanagement.Enum.ComplianceResult;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceRecordResponseDTO {
    private Integer complianceId;
    private Integer entityId;
    private ComplainceType type;
    private ComplianceResult result;
    private LocalDateTime date;
    private Integer officerId;
    private String notes;
}