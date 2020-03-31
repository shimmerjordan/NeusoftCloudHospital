package com.neuedu.hospitalbackend.model.po;

import java.sql.Date;

public class Diagnose {
    private Integer id;

    private Integer caseId;

    private String diseaseId;

    private Date startTime;

    private Boolean isFirstDiagnosed;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Boolean getFirstDiagnosed() {
        return isFirstDiagnosed;
    }

    public void setFirstDiagnosed(Boolean firstDiagnosed) {
        isFirstDiagnosed = firstDiagnosed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getIsFirstDiagnosed() {
        return isFirstDiagnosed;
    }

    public void setIsFirstDiagnosed(Boolean isFirstDiagnosed) {
        this.isFirstDiagnosed = isFirstDiagnosed;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}