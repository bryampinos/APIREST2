package com.crud.spring.persistence.repos;

import com.crud.spring.persistence.entities.IncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepository extends JpaRepository<IncidenteEntity, Long> {
}
