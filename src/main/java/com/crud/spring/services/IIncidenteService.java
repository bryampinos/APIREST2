package com.crud.spring.services;


import com.crud.spring.persistence.entities.IncidenteEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IIncidenteService {
    public IncidenteEntity createIncidente(IncidenteEntity user);
    public List<IncidenteEntity> getAllIncidentes();
    public Optional<IncidenteEntity> getIncidenteById(Long incidenteId);
    public IncidenteEntity updateIncidente(Long incidenteId, IncidenteEntity newIncidente);
    public HashMap<String, String> deleteIncidente(Long incidenteId);
}
