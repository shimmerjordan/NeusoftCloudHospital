package com.neuedu.hospitalbackend.service.serviceinterface.tollstationservice;

import com.neuedu.hospitalbackend.model.vo.DailySummaryParam;
import com.neuedu.hospitalbackend.util.CommonResult;

/**
 * 收费员日结
 * 用于挂号收费员每日交班日结，并向财务报账，同时可以查询本人历史日结数据。
 * @author Polaris
 */
public interface DailySummaryService {


    /**
     * 根据收费员id查询上次日结的截止时间
     */
    CommonResult getLastEndDate(Integer cashierId);

    /**
     * 日结统计：根据收费员id、起始日期查询指定收费员的所有发票信息
     * @param dailySummaryParam 日结参数
     * @return 执行结果
     */
    CommonResult listLogsByCashierIdAndDate(DailySummaryParam dailySummaryParam);

    /**
     * 结算报账：对统计时间段的收费记录，进行冻结状态
     * @param dailySummaryParam 日结参数
     * @return 执行结果
     */
    CommonResult freezeTransactionLogs(DailySummaryParam dailySummaryParam);

    /**
     * 日结历史查询
     * @param dailySummaryParam 日结参数
     * @return 执行结果
     */
    CommonResult listHistorySummaryLogs(DailySummaryParam dailySummaryParam);

    /**
     * 根据日结信息，显示其对应的发票信息
     * @param dailySummaryParam 日结参数
     * @return 执行结果
     */
    CommonResult listInvoiceInfoByCashierIdAndDate(DailySummaryParam dailySummaryParam);

    /**
     * 查询指定收费员第一条日结记录的时间
     * @param cashierId 收费员id
     * @return 执行结果
     */
    CommonResult getFirstSummaryDate(Integer cashierId);
}
