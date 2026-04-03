package org.cognizant.auditcompliancemanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.cognizant.auditcompliancemanagement.Enum.AuditStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "Audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuditID")
    private Integer auditId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "OfficerID", nullable = false)
//    private User officer;

    //private long officerId;

    @Column(name = "Scope", nullable = false, length = 500)
    private String scope;

    @Column(name = "Findings", columnDefinition = "TEXT")
    private String findings;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private AuditStatus status;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
}