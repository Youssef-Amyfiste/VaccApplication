package com.example.vaccapplication;

import com.example.vaccapplication.dao.CentreVaccinationDao;
import com.example.vaccapplication.model.CentreVaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccApplication implements CommandLineRunner {
    @Autowired
    CentreVaccinationDao centreVaccinationDao;

    public static void main(String[] args) {
        SpringApplication.run(VaccApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.centreVaccinationDao.save( new CentreVaccination("Casa Vac center","Oulfa Casablanca 20202"));
    }
}
