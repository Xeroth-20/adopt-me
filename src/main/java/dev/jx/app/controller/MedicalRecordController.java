package dev.jx.app.controller;

import java.util.Map;

import dev.jx.app.entity.DosageId;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import dev.jx.app.entity.MedicalRecord;
import dev.jx.app.entity.Dosage;
import dev.jx.app.service.MedicalRecordService;
import dev.jx.app.service.PetService;
import dev.jx.app.service.VaccineService;

@Controller
public class MedicalRecordController {

    @Autowired
    @Qualifier("medicalRecordServiceImpl")
    private MedicalRecordService medicalRecordService;

    @Autowired
    private PetService petService;

    @Autowired
    @Qualifier("vaccineServiceImpl")
    private VaccineService vaccineService;

    @RequestMapping(value = "/medical-records", method = RequestMethod.GET)
    public String getIndex(Map<String, Object> map) {
        map.put("medicalRecords", this.medicalRecordService.findAll());
        return "/medical-records/index";
    }

    @RequestMapping(value = "/medical-records/register", method = RequestMethod.GET)
    public String getRegister(Model model, Map<String, Object> map) {
        model.addAttribute("medicalRecord", new MedicalRecord());
        map.put("pets", this.petService.findAll());

        return "/medical-records/register";
    }

    @RequestMapping(value = "/medical-records/register", method = RequestMethod.POST)
    public String postRegister(MedicalRecord medicalRecord) {
        this.medicalRecordService.insert(medicalRecord);
        return "redirect:/medical-records";
    }

    @RequestMapping(value = "/medical-records/{id}/edit", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model, Map<String, Object> map) {
        model.addAttribute("medicalRecord", this.medicalRecordService.findById(id));
        map.put("pets", this.petService.findAll());

        return "/medical-records/edit";
    }

    @RequestMapping(value = "/medical-records/{id}/edit", method = RequestMethod.POST)
    public String postEdit(MedicalRecord medicalRecord) {
        this.medicalRecordService.update(medicalRecord);
        return "redirect:/medical-records";
    }

    @RequestMapping(value = "/medical-records/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("medicalRecord", this.medicalRecordService.findById(id));
        return "/medical-records/delete";
    }

    @RequestMapping(value = "/medical-records/{id}/delete", method = RequestMethod.POST)
    public String postDelete(MedicalRecord medicalRecord) {
        this.medicalRecordService.deleteById(medicalRecord.getId());
        return "redirect:/medical-records";
    }

    @RequestMapping(value = "/medical-records/{id}/dosages", method = RequestMethod.GET)
    public String getDosages(@PathVariable Integer id, Model model, Map<String, Object> map) {
        MedicalRecord medicalRecord = this.medicalRecordService.findById(id);
        Dosage dosage = new Dosage();
        dosage.setMedicalRecord(medicalRecord);
        model.addAttribute("dosage", dosage);
        map.put("medicalRecord", medicalRecord);
        map.put("vaccines", this.vaccineService.findAllByDosagesNotInMedicalRecordId(medicalRecord.getId()));

        return "/medical-records/dosages";
    }
}