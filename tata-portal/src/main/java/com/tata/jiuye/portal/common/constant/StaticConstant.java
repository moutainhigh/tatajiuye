package com.tata.jiuye.portal.common.constant;

public class StaticConstant {

    /********************************流水单类型常量***************************************/
    /**
     * 流水类型-收入
     */
    public static final String FLOW_TYPE_INCOME = "income";

    /**
     * 流水类型-支出
     */
    public static final String FLOW_TYPE_EXPENDITURE = "expenditure";

    /***************************************************************************************/

    /********************************流水类型明细常量***************************************/
    /**
     * 流水类型明细-收入-分佣收入
     */
    public static final String FLOW_TYPE_DETAIL_INCOME_COMMISSION_INCOME = "commission_income";

    /**
     * 流水类型明细-收入-配送费
     */
    public static final String FLOW_TYPE_DETAIL_INCOME_DELIVERY_FEE = "delivery_fee";

    /**
     * 流水类型明细-收入-仓储补助
     */
    public static final String FLOW_TYPE_DETAIL_INCOME_STORAGE_ALLOWANCE = "storage_allowance";

    /**
     * 流水类型明细-支出-提现
     */
    public static final String FLOW_TYPE_DETAIL_EXPENDITURE_WITHDRAW = "withdraw";

    /***************************************************************************************/

    /********************************账户类型类型常量***************************************/
    /**
     * 平台账户
     */
    public static final String ACCT_TYPE_PLATFORMACCOUNT = "platformAccount";

    /**
     * 普通会员账户
     */
    public static final String ACCT_TYPE_ORDINARYMEMBERACCOUNT = "ordinaryMemberAccount";

    /***************************************************************************************/

    /********************************状态类型常量***************************************/
    /**
     * 生效
     */
    public static final Integer INTEGER_STATUS_TAKE_EFFECT = 1;

    /**
     * 失效
     */
    public static final Integer INTEGER_STATUS_FAILURE = 0;
    /***********************************************************************************/

    /********************************角色等级名称常量***************************************/
    /**
     * 普通会员
     */
    public static final String UMS_MEMBER_LEVEL_NAME_ORDINARY_MEMBER = "普通会员";
    /**
     * VIP会员
     */
    public static final String UMS_MEMBER_LEVEL_NAME_VIP_MEMBER = "VIP会员";
    /**
     * 配送中心
     */
    public static final String UMS_MEMBER_LEVEL_NAME_DELIVERY_CENTER = "配送中心";
    /***********************************************************************************/
}