package com.fnma.appraisal.Service;

import com.fnma.appraisal.Entity.Appraisal;

import java.util.List;

public interface AppraisalService {
    List<Appraisal> getAllAppraisal();
    Appraisal getAppraisalByID(int appraisalID);
    Appraisal addAppraisal(Appraisal appraisal);
    Appraisal updateAppraisal(Appraisal appraisal);
    String deleteAppraisalByID(int appraisalID);
}
