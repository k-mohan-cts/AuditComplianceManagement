package org.cognizant.auditcompliancemanagement.dao;

import org.cognizant.auditcompliancemanagement.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {
    // We find by the User object to respect the @ManyToOne relation
//    List<Audit> findByOfficer(User officer);
}