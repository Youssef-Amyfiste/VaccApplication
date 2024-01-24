package com.example.vaccapplication.controller;
import com.example.vaccapplication.model.CentreVaccination;
import com.example.vaccapplication.model.Citoyen;
import com.example.vaccapplication.service.facade.CentreVaccinationService;
import com.example.vaccapplication.service.facade.CitoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/api/centreVaccination")
public class CentreVaccinationController {
    @Autowired
    CentreVaccinationService centreVaccinationService;
    @Autowired
    CitoyenService citoyenService;
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/centreVaccination")
    public String findAllCenters(Model model){
        model.addAttribute("centreVaccination", new CentreVaccination());
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "centreVaccination";
    }
    @GetMapping("/findCitoyensDeCentre")
    public String findCitoyensDeCentre(@ModelAttribute("centreVaccination") CentreVaccination centreVaccination, Model model){
        //model.addAttribute("centreVaccination", new CentreVaccination());
        List<Citoyen> citoyenList = this.citoyenService.findByCentreVaccinationId(centreVaccination.getId());
        model.addAttribute("citoyens",citoyenList);
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "centreVaccination";
    }
    @GetMapping("/addVaccCenter")
    public String addVaccCenter(Model model){
        model.addAttribute("centreVaccination", new CentreVaccination());
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "addVaccCenter";
    }
    @GetMapping("/addCitoyen")
    public String addCitoyen(Model model){
        model.addAttribute("citoyen", new Citoyen());
        List<Citoyen> citoyenList = this.citoyenService.findAll();
        model.addAttribute("citoyens",citoyenList);
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "addCitoyen";
    }
    @PostMapping("/saveCitoyen")
    public String saveCitoyen(@ModelAttribute("citoyen") Citoyen citoyen) {
        Optional<CentreVaccination> centreVaccinationOptional=this.centreVaccinationService.findById(citoyen.getCentreVaccination().getId());
        CentreVaccination centreVaccination = centreVaccinationOptional.get();
        citoyen.setCentreVaccination(centreVaccination);
        this.citoyenService.save(citoyen);
        return "redirect:/api/centreVaccination/addCitoyen";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("centreVaccination") CentreVaccination centreVaccination) {
        this.centreVaccinationService.save(centreVaccination);
        return "redirect:/api/centreVaccination/addVaccCenter";
    }
    @GetMapping("/editVaccCenter/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<CentreVaccination> centreVaccination = centreVaccinationService.findById(id);
        model.addAttribute("centreVaccination", centreVaccination);
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "editVaccCenter";
    }
    @GetMapping("/editCitoyen/{id}")
    public String editCitoyen(@PathVariable Long id, Model model) {
        Optional<Citoyen> citoyen = citoyenService.findById(id);
        model.addAttribute("citoyen", citoyen);
        List<Citoyen> citoyenList = this.citoyenService.findAll();
        model.addAttribute("citoyens", citoyenList);
        List<CentreVaccination> centreVaccinationList = this.centreVaccinationService.findAll();
        model.addAttribute("centreVaccinations",centreVaccinationList);
        return "editCitoyen";
    }
    @GetMapping("/deleteVaccCenter/{id}")
    public String delete(@PathVariable Long id){
        this.centreVaccinationService.deleteById(id);
        return "redirect:/api/centreVaccination/addVaccCenter";

    }
    @GetMapping("/deleteCitoyen/{id}")
    public String deleteCitoyen(@PathVariable Long id){
        this.citoyenService.deleteById(id);
        return "redirect:/api/centreVaccination/addCitoyen";

    }

}
