package com.fnma.appraisal.Service;

import com.fnma.appraisal.Dao.AppraisalDao;
import com.fnma.appraisal.Entity.Appraisal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppraisalServiceImpl implements AppraisalService{
    private AppraisalDao AppraisalDao;

    @Override
    public List<Appraisal> getAllAppraisal() {
        return this.AppraisalDao.findAll();
    }

    @Override
    public Appraisal getAppraisalByID(int AppraisalID) {
        Optional<Appraisal> c = this.AppraisalDao.findById(AppraisalID);
        Appraisal appraisal = null;
        if(c.isPresent()){
            appraisal = c.get();
        } else {
            throw new RuntimeException(" Appraisal not found for id :: " + AppraisalID);
        }
        return appraisal;

    }

    @Override
    public Appraisal addAppraisal(Appraisal appraisal) {
        return this.AppraisalDao.save(appraisal);
    }

    @Override
    public Appraisal updateAppraisal(Appraisal appraisal) {
        return this.AppraisalDao.save(appraisal);
    }

    @Override
    public String deleteAppraisalByID(int appraisalID) {
        this.AppraisalDao.deleteById(appraisalID);
        return "Deleted Successfully";
    }
}
