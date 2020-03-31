package com.neuedu.hospitalbackend.model.vo;

import java.util.List;

/**
 * 门诊病历
 */
public class PatientCaseParam {
    private Integer caseId;
    private String narrate; //主述
    private String curDisease; //现病史
    private String curTreatCondition; //现病治疗情况
    private String pastDisease; //既往史
    private String allergy; //过敏史
    private String physicalCondition; //体格检查
    private String assistDiagnose;//辅助检查
    private Integer diagnoseType;//诊断类型
    private Integer status;//1.待诊 2.暂存 3.已诊（未确诊） 4.确诊  5.诊闭
    private List<DiagnoseParam> modernDiagnose; //西医初诊
    private List<DiagnoseParam> traditionalDiagnose; //中医初诊
    private List<DiagnoseParam> finalModernDiagnose; //西医确诊
    private List<DiagnoseParam> finalTraditionalDiagnose; //中医确诊

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DiagnoseParam> getFinalModernDiagnose() {
        return finalModernDiagnose;
    }

    public void setFinalModernDiagnose(List<DiagnoseParam> finalModernDiagnose) {
        this.finalModernDiagnose = finalModernDiagnose;
    }

    public List<DiagnoseParam> getFinalTraditionalDiagnose() {
        return finalTraditionalDiagnose;
    }

    public void setFinalTraditionalDiagnose(List<DiagnoseParam> finalTraditionalDiagnose) {
        this.finalTraditionalDiagnose = finalTraditionalDiagnose;
    }

    public String getAssistDiagnose() {
        return assistDiagnose;
    }

    public void setAssistDiagnose(String assistDiagnose) {
        this.assistDiagnose = assistDiagnose;
    }

    public Integer getDiagnoseType() {
        return diagnoseType;
    }

    public void setDiagnoseType(Integer diagnoseType) {
        this.diagnoseType = diagnoseType;
    }

    public String getPastDisease() {
        return pastDisease;
    }

    public List<DiagnoseParam> getModernDiagnose() {
        return modernDiagnose;
    }

    public void setModernDiagnose(List<DiagnoseParam> modernDiagnose) {
        this.modernDiagnose = modernDiagnose;
    }

    public List<DiagnoseParam> getTraditionalDiagnose() {
        return traditionalDiagnose;
    }

    public void setTraditionalDiagnose(List<DiagnoseParam> traditionalDiagnose) {
        this.traditionalDiagnose = traditionalDiagnose;
    }

    public void setPastDisease(String pastDisease) {
        this.pastDisease = pastDisease;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getNarrate() {
        return narrate;
    }

    public void setNarrate(String narrate) {
        this.narrate = narrate;
    }

    public String getCurDisease() {
        return curDisease;
    }

    public void setCurDisease(String curDisease) {
        this.curDisease = curDisease;
    }

    public String getCurTreatCondition() {
        return curTreatCondition;
    }

    public void setCurTreatCondition(String curTreatCondition) {
        this.curTreatCondition = curTreatCondition;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(String physicalCondition) {
        this.physicalCondition = physicalCondition;
    }
}
