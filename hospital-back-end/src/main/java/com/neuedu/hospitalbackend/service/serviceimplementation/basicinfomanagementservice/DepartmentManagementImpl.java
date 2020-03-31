package com.neuedu.hospitalbackend.service.serviceimplementation.basicinfomanagementservice;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neuedu.hospitalbackend.model.dao.DepartmentMapper;
import com.neuedu.hospitalbackend.model.po.Department;
import com.neuedu.hospitalbackend.service.serviceinterface.basicinfomanagementservice.DepartmentManagementService;
import com.neuedu.hospitalbackend.util.CommonResult;
import com.neuedu.hospitalbackend.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.activation.CommandObject;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.neuedu.hospitalbackend.util.ResultCode.*;

/**
 * @author Raven
 */
@Service
public class DepartmentManagementImpl implements DepartmentManagementService {
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public CommonResult getDepartmentById(Integer id) {
        Department department = departmentMapper.get(id);
        return CommonResult.success(department);
    }

    @Override
    public CommonResult insertDepartment(Department department) {
        int count = departmentMapper.insert(department);
        if (count == 0) {
            return CommonResult.fail();
        }
        return CommonResult.success(count);
    }

    @Override
    public CommonResult updateDepartmentById(Department department) {
        if (departmentMapper.get(department.getId()) == null) {
            return CommonResult.fail(E_602);
        }
        int count = departmentMapper.update(department);
        if (count == 0) {
            return CommonResult.fail();
        }
        return CommonResult.success(count);
    }

    @Override
    public CommonResult deleteDepartmentById(Integer id) {
        if (departmentMapper.get(id) == null) {
            return CommonResult.fail(E_602);
        }
        int count = departmentMapper.delete(id);
        if (count == 0) {
            return CommonResult.fail();
        }
        return CommonResult.success(count);
    }

    @Override
    public CommonResult listAllDepartments() {
        List<Department> list = departmentMapper.list();
        return CommonResult.success(list);
    }

    @Override
    public CommonResult listPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Department> list = departmentMapper.listByPage();
        return CommonResult.success(list);
    }

    @Override
    public CommonResult listDepartmentsTree() {
        List<Department> list = departmentMapper.list();
        Map<String, Map<String, List<String>>> map = new HashMap<>();

        // 三层判断，没有则插入
        for (Department department : list) {
            if (!map.containsKey(department.getType())) {
                map.put(department.getType(), new HashMap<>());
            }
            if (!map.get(department.getType()).containsKey(department.getClassification())) {
                map.get(department.getType()).put(department.getClassification(), new ArrayList<>());
            }
            if (!map.get(department.getType()).get(department.getClassification()).contains(department.getName())) {
                map.get(department.getType()).get(department.getClassification()).add(department.getName());
            }
        }

        return CommonResult.success(map);
    }


    /**
     * 获取所有门诊科室
     */
    public CommonResult listDoctorDepartments(){
        JSONObject returnJson = new JSONObject();

        List<HashMap> departments = departmentMapper.listDoctorDepartments();

        returnJson.put("departments", departments);
        return CommonResult.success(returnJson);
    }

}
