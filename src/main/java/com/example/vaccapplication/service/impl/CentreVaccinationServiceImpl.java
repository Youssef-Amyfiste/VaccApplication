package com.example.vaccapplication.service.impl;

import com.example.vaccapplication.dao.CentreVaccinationDao;
import com.example.vaccapplication.model.CentreVaccination;
import com.example.vaccapplication.service.facade.CentreVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CentreVaccinationServiceImpl implements CentreVaccinationService {
    @Autowired
    private CentreVaccinationDao centreVaccinationDao;
    @Override
    public int save(CentreVaccination centreVaccination) {
        this.centreVaccinationDao.save(centreVaccination);
        return 1;
    }
    @Override
    public Optional<CentreVaccination> findById(Long id) {
        return this.centreVaccinationDao.findById(id);
    }
    @Override
    public List<CentreVaccination> findAll() {
        return this.centreVaccinationDao.findAll();
    }
    @Override
    @Transactional
    public void deleteById(Long id) {
        this.centreVaccinationDao.deleteById(id);
    }
}
