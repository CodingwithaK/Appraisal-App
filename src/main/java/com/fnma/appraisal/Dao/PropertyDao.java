package com.fnma.appraisal.Dao;

import com.fnma.appraisal.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDao extends JpaRepository<Property, Integer> {
}
