package com.neuedu.hospitalbackend.util;

/**
 * 枚举了一些常用API操作码
 * Created by Raven on 2019/5/30.
 */
public enum ResultCode implements IErrorCode {
    // 外层code
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),

    // 内层error data
    // Raven, Steve
    E_600(600, "用户不存在"),
    E_601(601, "密码错误"),
    E_602(602, "操作项不存在"),
    E_603(603, "用户未登录，请重新登录"),
    E_604(604, "登录信息过期，请重新登录"),
    E_605(605, "插入失败"),
    E_606(606, "原密码输入错误"),
    E_607(607, "新密码与原密码相同"),

    // Polaris
    E_700(700, "更新失败"),
    E_701(701, "不是待诊状态，无法退号" ),
    E_702(702, "找不到指定用户信息"),
    E_703(703, "找不到指定用户挂号信息"),
    E_704(704, "存在不可退费项目"),
    E_705(705,"存在不可退药项目"),
    E_706(706,"存在不可取药项目"),
    E_707(707,"药品库存不足"),
    E_708(708,"统计时间段内无收费记录"),
    E_709(709,"统计时间段内无日结记录"),
    E_710(710,"该收银员无日结历史记录"),
    E_711(711,"请先保存检查结果"),
    E_712(712,"集合类型异常"),
    E_713(713,"无可用发票号"),

    // Amy
    E_800(800, "数据库参数异常"),
    E_801(801, "传入参数异常"),
    E_802(802, "保存失败!"),
    E_803(803, "删除失败"),
    E_804(804, "操作权限异常"),
    E_805(805, "缺少必填参数"),
    E_806(806, "该名称已存在"),
    E_807(807, "该模板不存在"),
    E_808(808, "排班存在冲突"),
    E_809(809, "查询时间异常"),
    E_810(810, "已存在排班结果");



    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
