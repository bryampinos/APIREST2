package com.crud.spring.controllers;

import com.crud.spring.persistence.entities.IncidenteEntity;
import com.crud.spring.services.IIncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/incidente")
public class IncidenteController {
    @Autowired
    IIncidenteService incidenteService;
    @PostMapping("/create")
    public ResponseEntity<IncidenteEntity> createIncidente(@RequestBody IncidenteEntity incidente){
        IncidenteEntity createdIncidente = incidenteService.createIncidente(incidente);
        return new ResponseEntity<>(createdIncidente, HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<IncidenteEntity>> getAllIncidentes(){
        List<IncidenteEntity> incidentes = incidenteService.getAllIncidentes();
        return  new ResponseEntity<>(incidentes, HttpStatus.OK);

    }
    @GetMapping("get/{incidenteId}")
    public ResponseEntity<IncidenteEntity> getIncidenteById(@PathVariable Long incidenteId){
        Optional<IncidenteEntity> incidente = incidenteService.getIncidenteById(incidenteId);
        return  incidente.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{incidenteId}")
    public ResponseEntity<IncidenteEntity> updateIncidente(@PathVariable Long incidenteId, @RequestBody IncidenteEntity newIncidente){
        IncidenteEntity updateIncidente = incidenteService.updateIncidente(incidenteId, newIncidente);
        if (updateIncidente != null ){
            return new ResponseEntity<>(updateIncidente, HttpStatus.OK);

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{incidenteId}")
    public ResponseEntity<HashMap<String, String>> deleteIncidente(@PathVariable Long incidenteId){
        HashMap<String, String> response = incidenteService.deleteIncidente(incidenteId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
