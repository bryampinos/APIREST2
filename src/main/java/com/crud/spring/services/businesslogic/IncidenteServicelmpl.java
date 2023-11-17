package com.crud.spring.services.businesslogic;

import com.crud.spring.persistence.entities.IncidenteEntity;
import com.crud.spring.persistence.repos.IncidenteRepository;
import com.crud.spring.services.IIncidenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenteServicelmpl implements IIncidenteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    IncidenteRepository incidenteRepository;

    @Override
    public IncidenteEntity createIncidente(IncidenteEntity incidente) {
        return incidenteRepository.save(incidente);
    }

    @Override
    public List<IncidenteEntity> getAllIncidentes() {
        return incidenteRepository.findAll();
    }

    @Override
    public Optional<IncidenteEntity> getIncidenteById(Long incidenteId) {
        return incidenteRepository.findById(incidenteId);
    }

    @Override
    public IncidenteEntity updateIncidente(Long incidenteId, IncidenteEntity newIncidente) {
        IncidenteEntity existinIncidente = incidenteRepository.findById(incidenteId).orElse(null);
        if (existinIncidente != null) {
            existinIncidente.setNombre(newIncidente.getNombre());
            existinIncidente.setApellido(newIncidente.getApellido());
            existinIncidente.setRol(newIncidente.getRol());
            existinIncidente.setDescripcion(newIncidente.getDescripcion());
            existinIncidente.setEvidencia(newIncidente.getEvidencia());
            existinIncidente.setFechaCreacion(newIncidente.getFechaCreacion());
            existinIncidente.setEstado(newIncidente.getEstado());
            return incidenteRepository.save(existinIncidente);
        }
        throw new RuntimeException("incidenten no encontrado");
    }
    @Override
    public HashMap<String, String> deleteIncidente(Long incidenteId){
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "User deleted succesfully!");
        incidenteRepository.deleteById(incidenteId);
        return response;
    }

}
