package com.example.vaccapplication.dao;
import com.example.vaccapplication.model.CentreVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CentreVaccinationDao extends JpaRepository<CentreVaccination,Long> {
    List<CentreVaccination> findAll();
}
