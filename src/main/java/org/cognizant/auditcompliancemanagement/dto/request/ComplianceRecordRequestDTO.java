    package org.cognizant.auditcompliancemanagement.dto.request;

    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.cognizant.auditcompliancemanagement.Enum.ComplainceType;
    import org.cognizant.auditcompliancemanagement.Enum.ComplianceResult;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class ComplianceRecordRequestDTO {
        @NotNull(message = "Entity ID is required")
        private Integer entityId;

        @NotNull(message = "Compliance Type is required")
        private ComplainceType type;

        private Integer officerId; // The ID of the Compliance Officer
        private ComplianceResult result; // Compliant, NonCompliant, or PendingReview
        private String notes;
    }