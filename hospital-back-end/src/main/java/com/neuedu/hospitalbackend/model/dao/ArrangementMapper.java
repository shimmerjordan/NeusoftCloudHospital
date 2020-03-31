package com.neuedu.hospitalbackend.model.dao;

import com.neuedu.hospitalbackend.model.po.Arrangement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Component
public interface ArrangementMapper {
    int insert(Arrangement record);

    int insertSelective(Arrangement record);

    List<Arrangement> listAvailableDoctors(@Param("appointmentDateStr") String appointmentDateStr,  @Param("timeSlot") Byte timeSlot,
                                           @Param("registrationLevelId") Short registrationLevelId,
                                           @Param("departmentId") Integer departmentId);

    int updateRemainingAppointment(@Param("appointmentDateStr") String appointmentDateStr, @Param("timeSlot") Byte timeSlot,
                                   @Param("roleId") Integer roleId, @Param("registrationLevelId") Short registrationLevelId,
                                   @Param("amount") int amount, @Param("departmentId") Integer departmentId);

    List<HashMap> listByDepartmentIdAndDatePeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                                            @Param("departmentId") Integer departmentId);

    List<Arrangement> listByUserIdAndDatePeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int deleteByDepartmentIdAndDatePeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                                          @Param("departmentId") Integer departmentId);

    int updateTimeSlot(@Param("id") Integer id, @Param("timeSlot") Byte timeSlot);

    int deleteById(@Param("id") Integer id);
}