import request from '@/utils/request'


export default{
  // 获取所有门诊科室
  listDoctorDepartments() {
    return request({
      url: 'basicinfo/doctordepartments',
      method: 'GET'
    })
  },

  // 获取某科室中所有角色
  listAllRolesByDepartmentId(departmentId) {
    return request({
      url: 'basicinfo/departmentroles/' + departmentId,
      method: 'GET'
    })
  },

  // 查询排班规则
  listArrangementRules(departmentId) {
    return request({
      url: 'basicinfo/arrangementrules/' + departmentId,
      method: 'GET'
    })
  },

  // 设定排班规则
  insertArrangementRule(arrangementRuleParam) {
    return request({
      url: 'basicinfo/arrangementrule',
      method: 'POST',
      data: arrangementRuleParam
    })
  },

  // 生成排班规则
  insertArrangement(arrangementParam) {
    return request({
      url: 'basicinfo/arrangement',
      method: 'POST',
      data: arrangementParam
    })
  },

  // 查看排班信息
  listArrangements(startDate, endDate, departmentId) {
    return request({
      url: 'basicinfo/arrangements/' + departmentId,
      method: 'GET',
      params: {startDate, endDate}
    })
  },

  // 修改排班信息
  modifyArrangement(arrangementId, timeSlot) {
    return request({
      url: 'basicinfo/arrangements/modification/' + arrangementId,
      method: 'PUT',
      params: {timeSlot}
    })
  }

}