package com.example.vaccapplication.service.facade;
import com.example.vaccapplication.model.Citoyen;
import java.util.List;
import java.util.Optional;
public interface CitoyenService {
    int save(Citoyen citoyen);
    Optional<Citoyen> findById(Long id);
    List<Citoyen> findAll();
    void deleteById(Long id);
    List<Citoyen> findByCentreVaccinationId(Long id);
}
