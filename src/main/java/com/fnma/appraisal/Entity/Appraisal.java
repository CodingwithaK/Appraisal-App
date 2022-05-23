package com.fnma.appraisal.Entity;

import java.util.Date;
import java.util.HashSet;

public class Appraisal {
    private int appraisalID;
    private int propertyID;
    private int bankID;
    private int appraiserID;
    private String status; // request, rejected, in process, completed
    private Date appraisalDate;
    private HashSet<Integer> Comparitives;
    private String assessment;
    private float appraisedValue;
}
