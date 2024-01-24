package com.example.vaccapplication.service.facade;
import com.example.vaccapplication.model.CentreVaccination;
import java.util.List;
import java.util.Optional;
public interface CentreVaccinationService {
    int save(CentreVaccination centreVaccination);
    Optional<CentreVaccination> findById(Long id);
    List<CentreVaccination> findAll();
    void deleteById(Long id);
}
