package com.example.vaccapplication.dao;
import com.example.vaccapplication.model.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitoyenDao extends JpaRepository<Citoyen,Long> {
    List<Citoyen> findAll();
    void deleteById(Long id);
    List<Citoyen> findByCentreVaccinationId(Long id);
}
