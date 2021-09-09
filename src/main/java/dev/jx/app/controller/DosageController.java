package dev.jx.app.controller;

import java.util.*;
import java.util.stream.Collectors;

import dev.jx.app.entity.MedicalRecord;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.app.entity.Dosage;
import dev.jx.app.entity.DosageId;
import dev.jx.app.service.DosageService;
import dev.jx.app.service.MedicalRecordService;
import dev.jx.app.service.VaccineService;

@Controller
public class DosageController {

    @Autowired
    @Qualifier("dosageServiceImpl")
    private DosageService dosageService;

    @Autowired
    @Qualifier("medicalRecordServiceImpl")
    private MedicalRecordService medicalRecordService;

    @Autowired
    @Qualifier("vaccineServiceImpl")
    private VaccineService vaccineService;

    private static final Set<Dosage> dosagesCart = new TreeSet<>();

    @RequestMapping(value = "/dosages", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("dosages", this.dosageService.findAll());
        dosagesCart.clear();

        return "/dosages/index";
    }

    @RequestMapping(value = "/dosages/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable Integer id, Model model, Map<String, Object> map) {
        MedicalRecord medicalRecord = this.medicalRecordService.findById(id);
        model.addAttribute("medicalRecord", medicalRecord);
        map.put("dosages", new TreeSet<>(medicalRecord.getDosages()));

        return "/dosages/details";
    }

    @RequestMapping(value = "/dosages/{id}/register", method = RequestMethod.GET)
    public String getRegister(@PathVariable Integer id, Model model, Map<String, Object> map) {
        MedicalRecord medicalRecord = this.medicalRecordService.findById(id);
        Dosage dosage = new Dosage();
        dosage.setMedicalRecord(medicalRecord);
        model.addAttribute("dosage", dosage);
        map.put("medicalRecord", medicalRecord);
        map.put(
                "vaccines",
                dosagesCart.size() == 0
                        ? this.vaccineService.findAllNotIncludedInMedicalRecordId(medicalRecord.getId())
                        : this.vaccineService.findAllNotIncludedInMedicalRecordIdAndIdNotIn(
                        medicalRecord.getId(),
                        dosagesCart.stream().map((Dosage o) -> o.getVaccine().getId()).collect(Collectors.toList())
                )
        );
        map.put("mrDosages", new TreeSet<>(medicalRecord.getDosages()));
        map.put("dosagesCart", new TreeSet<>(dosagesCart));

        return "/dosages/register";
    }

    @RequestMapping(value = "/dosages/{id}/register", method = RequestMethod.POST)
    public String postRegister(@PathVariable Integer id) {
        this.dosageService.insertAll(dosagesCart);
        dosagesCart.clear();

        return "redirect:/dosages/" + id;
    }

    @RequestMapping(value = "/dosages/add-dosage", method = RequestMethod.POST)
    public String postAddDosage(Dosage dosage) {
        dosage.setVaccine(this.vaccineService.findById(dosage.getVaccine().getId()));
        dosagesCart.add(dosage);

        return "redirect:/dosages/" + dosage.getMedicalRecord().getId() + "/register";
    }

    @RequestMapping(value = "/dosages/register", method = RequestMethod.POST)
    public String postRegister(Dosage dosage) {
        this.dosageService.insert(dosage);
        return "redirect:/medical-records/" + dosage.getMedicalRecord().getId() + "/dosages";
    }

    @RequestMapping(value = "/dosages/delete", method = RequestMethod.POST)
    public String postDelete(@RequestParam Integer medicalRecordId, @RequestParam Integer vaccineId) {
        Dosage dosage = this.dosageService.findById(new DosageId(medicalRecordId, vaccineId));
        this.dosageService.deleteById(dosage.getId());

        return "redirect:/medical-records/" + dosage.getId().getMedicalRecordId() + "/dosages";
    }
}
