package com.fnma.appraisal.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="appraisal")
public class Appraisal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appraisalID;
    @ManyToOne
    @JoinColumn(name = "property")
    private Property property;
    @ManyToOne
    @JoinColumn(name = "bank")
    private User bank;
    @ManyToOne
    @JoinColumn(name = "appraiser")
    private User appraiser;
    private String status; // request, rejected, in process, completed
    private Date appraisalDate;
    @ManyToMany()
    private Set<Property> comparitives;
    private String assessment;
    private float appraisedValue;

    public Appraisal() {
    }

    public Appraisal(int appraisalID, Property property, User bank, User appraiser, String status, Date appraisalDate, Set<Property> comparitives, String assessment, float appraisedValue) {
        this.appraisalID = appraisalID;
        this.property = property;
        this.bank = bank;
        this.appraiser = appraiser;
        this.status = status;
        this.appraisalDate = appraisalDate;
        this.comparitives = comparitives;
        this.assessment = assessment;
        this.appraisedValue = appraisedValue;
    }

    public int getAppraisalID() {
        return appraisalID;
    }

    public void setAppraisalID(int appraisalID) {
        this.appraisalID = appraisalID;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getBank() {
        return bank;
    }

    public void setBank(User bank) {
        this.bank = bank;
    }

    public User getAppraiser() {
        return appraiser;
    }

    public void setAppraiser(User appraiser) {
        this.appraiser = appraiser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAppraisalDate() {
        return appraisalDate;
    }

    public void setAppraisalDate(Date appraisalDate) {
        this.appraisalDate = appraisalDate;
    }

    public Set<Property> getComparitives() {
        return comparitives;
    }

    public void setComparitives(Set<Property> comparitives) {
        this.comparitives = comparitives;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public float getAppraisedValue() {
        return appraisedValue;
    }

    public void setAppraisedValue(float appraisedValue) {
        this.appraisedValue = appraisedValue;
    }
}