package com.neuedu.hospitalbackend.service.serviceinterface.commonservice;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hospitalbackend.model.vo.LoginParam;
import com.neuedu.hospitalbackend.util.CommonResult;

import javax.servlet.http.HttpServletRequest;

public interface OauthService {
    CommonResult login(LoginParam loginParam, HttpServletRequest httpServletRequest);
}
