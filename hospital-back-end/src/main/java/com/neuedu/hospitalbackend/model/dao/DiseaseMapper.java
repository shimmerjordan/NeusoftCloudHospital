package com.neuedu.hospitalbackend.model.dao;

import com.neuedu.hospitalbackend.model.po.Disease;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DiseaseMapper {
    Disease get(Short id);

    int insert(Disease disease);

    int update(Disease disease);

    int delete(Short id);

    List<Disease> list();

    String getTypeOfDiseaseByIcdCode(String icdCode);

    List<HashMap> ListChineseDisease();

    List<HashMap> ListWesternDisease();

    HashMap getDiseaseByIcdCode(String icdCode);
}
