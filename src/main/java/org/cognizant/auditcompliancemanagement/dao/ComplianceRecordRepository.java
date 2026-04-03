package org.cognizant.auditcompliancemanagement.dao;

import org.cognizant.auditcompliancemanagement.Enum.ComplianceResult;
import org.cognizant.auditcompliancemanagement.entity.ComplianceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ComplianceRecordRepository extends JpaRepository<ComplianceRecord, Integer> {
//    List<ComplianceRecord> findByOfficer(User officer);
    List<ComplianceRecord> findByResult(ComplianceResult result);
    List<ComplianceRecord> findByEntityId(Integer entityId);
}