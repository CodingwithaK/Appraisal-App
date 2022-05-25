package com.fnma.appraisal.Dao;

import com.fnma.appraisal.Entity.Appraisal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalDao extends JpaRepository<Appraisal, Integer> {
}
