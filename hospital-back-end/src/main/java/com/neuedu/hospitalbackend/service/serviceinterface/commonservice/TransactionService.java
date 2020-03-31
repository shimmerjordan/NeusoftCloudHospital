package com.neuedu.hospitalbackend.service.serviceinterface.commonservice;

import com.neuedu.hospitalbackend.model.po.TransactionLog;
import com.neuedu.hospitalbackend.util.CommonResult;

/**
 * 缴费表和缴费异常表的数据插入
 * @author Polaris
 */
public interface TransactionService {

    /**
     * 向缴费异常表里添加记录
     * @param originalCode 原缴费记录发票号
     * @param newCode 新发票号 (如果有新发票产生）
     * @param reverseCode 冲正发票号
     * @param roleId 收银员ID
     * @param reason 异常原因
     * @return 执行结果
     */
    CommonResult insertTransactionExceptionLog(String originalCode, String newCode, String reverseCode,
                                               Integer roleId, String reason);

    /**
     * 向缴费表里添加记录
     * @param transactionLog 缴费记录
     * @return 执行结果
     */
    CommonResult insertTransactionLog(TransactionLog transactionLog);
}
