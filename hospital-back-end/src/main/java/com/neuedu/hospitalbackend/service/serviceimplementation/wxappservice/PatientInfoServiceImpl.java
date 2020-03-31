package com.neuedu.hospitalbackend.service.serviceimplementation.wxappservice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hospitalbackend.model.dao.*;
import com.neuedu.hospitalbackend.model.po.*;
import com.neuedu.hospitalbackend.service.serviceinterface.doctorstationservice.PreliminaryCaseService;
import com.neuedu.hospitalbackend.service.serviceinterface.wxappservice.PatientInfoService;
import com.neuedu.hospitalbackend.util.CommonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Raven
 * @Date: 2019/6/11 5:54 PM
 */
@Service
public class PatientInfoServiceImpl implements PatientInfoService {
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private InspectionMapper inspectionMapper;
    @Resource
    private ExaminationMapper examinationMapper;
    @Resource
    private TreatmentMapper treatmentMapper;
    @Resource
    private RecipeMapper recipeMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PatientCaseMapper patientCaseMapper;

    @Resource
    private PreliminaryCaseService preliminaryCaseService;


    @Override
    public CommonResult getPatientInfo(Integer id) {
        Patient patient = patientMapper.getPatientInfoById(id);

        return CommonResult.success(patient);
    }

    @Override
    public CommonResult listRegistrationsByPatientId(Integer patientId) {
        List<HashMap> registrations = registrationMapper.listRegistrationsByPatientId(patientId);

        return CommonResult.success(registrations);
    }

    @Override
    public CommonResult getPatientResultInfo(Integer caseId){
        JSONObject returnJson = new JSONObject();
        //基本信息
        returnJson.put("基本信息", preliminaryCaseService.getPatientCaseInfo(1, caseId).getData());
        //检查结果
        returnJson.put("检查结果", inspectionMapper.getResult(caseId));
        //检验结果
        returnJson.put("检验结果", examinationMapper.getResult(caseId));
        //处置信息
        returnJson.put("处置信息", treatmentMapper.getInfo(caseId));
        //处方信息
        returnJson.put("处方信息", recipeMapper.getInfo(caseId));

        return CommonResult.success(returnJson);
    }

    @Override
    public CommonResult getWaitingAmountById(Integer patientId){
        JSONArray jsonArray = new JSONArray();

        List<HashMap> registrations = patientCaseMapper.listRegistrationsByPatientId(patientId);
        for(int i = 0; i <registrations.size(); i++){
            JSONObject jsonObject = new JSONObject();
            Integer registrationId = Integer.valueOf(registrations.get(i).get("registration_id").toString());
            Integer roleId = Integer.valueOf(registrations.get(i).get("role_id").toString());
            String appointmentDateStr = registrations.get(i).get("appointment_date").toString();

            int beforeAmount = patientCaseMapper.getWaitingAmountById(registrationId, roleId, appointmentDateStr);
            jsonObject.put("registrationId", registrationId);
            jsonObject.put("appointmentDate", appointmentDateStr);
            jsonObject.put("beforeAmount", beforeAmount);
            jsonObject.put("doctorName", roleMapper.getUserNameByRoleId(roleId));
            jsonObject.put("departmentName", roleMapper.getDepartmentNameByRoleId(roleId));
            jsonArray.add(jsonObject);
        }
        return CommonResult.success(jsonArray);
    }
}
