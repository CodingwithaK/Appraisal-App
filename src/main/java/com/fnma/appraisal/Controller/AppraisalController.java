package com.fnma.appraisal.Controller;

import com.fnma.appraisal.Entity.Appraisal;
import com.fnma.appraisal.Service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    // Appraisal API
    @GetMapping ("/appraisals")
    public List<Appraisal> getAllAppraisals(){
        return this.appraisalService.getAllAppraisal();
    }
    @GetMapping("/appraisals/{appraisalID}")
    public Appraisal getappraisal(@PathVariable String appraisalID){
        return this.appraisalService.getAppraisalByID(Integer.parseInt(appraisalID));
    }
    @PostMapping("/appraisals")
    public Appraisal addappraisal(@RequestBody Appraisal appraisal){
        return this.appraisalService.addAppraisal(appraisal);
    }
    @PutMapping("/appraisals")
    public Appraisal updateappraisal(@RequestBody Appraisal appraisal){
        return this.appraisalService.updateAppraisal(appraisal);
    }
    @DeleteMapping("/appraisals/{appraisalID}")
    public String deleteappraisal(@PathVariable String appraisalID){
        return this.appraisalService.deleteAppraisalByID(Integer.parseInt(appraisalID));
    }

}
