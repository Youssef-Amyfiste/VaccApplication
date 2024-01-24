package com.example.vaccapplication.service.impl;
import com.example.vaccapplication.dao.CitoyenDao;
import com.example.vaccapplication.model.Citoyen;
import com.example.vaccapplication.service.facade.CitoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CitoyenServiceImpl implements CitoyenService {
    @Autowired
    CitoyenDao citoyenDao;
    @Override
    public int save(Citoyen citoyen) {
        this.citoyenDao.save(citoyen);
        return 1;
    }
    @Override
    public Optional<Citoyen> findById(Long id) {
        return this.citoyenDao.findById(id);
    }
    @Override
    public List<Citoyen> findAll() {
        return this.citoyenDao.findAll();
    }
    @Override
    @Transactional
    public void deleteById(Long id) {
        this.citoyenDao.deleteById(id);
    }
    @Override
    public List<Citoyen> findByCentreVaccinationId(Long id) {
        return this.citoyenDao.findByCentreVaccinationId(id);
    }
}
