package dev.jx.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.jx.app.entity.Dosage;
import dev.jx.app.entity.DosageId;
import dev.jx.app.service.DosageService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DosageController {

    @Autowired
    @Qualifier("dosageServiceImpl")
    private DosageService dosageService;

    @RequestMapping(value = "/dosages/register", method = RequestMethod.POST)
    public String postRegister(Dosage dosage) {
        this.dosageService.insert(dosage);
        return "redirect:/medical-records/" + dosage.getId().getMedicalRecordId() + "/dosages";
    }

    @RequestMapping(value = "/dosages/delete", method = RequestMethod.POST)
    public String postDelete(@RequestParam Integer medicalRecordId, @RequestParam Integer vaccineId) {
        Dosage dosage = this.dosageService.findById(new DosageId(medicalRecordId, vaccineId));
        this.dosageService.deleteById(dosage.getId());

        return "redirect:/medical-records/" + dosage.getId().getMedicalRecordId() + "/dosages";
    }
}
