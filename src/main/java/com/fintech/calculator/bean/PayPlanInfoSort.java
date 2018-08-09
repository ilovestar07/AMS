/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: PayPlanInfoSort.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 	
 *****************************************************************************
 */
package com.fintech.calculator.bean;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

import com.fintech.base.util.DateUtil;

public class PayPlanInfoSort implements Comparator<HashMap.Entry<String, PayPlanInfo>> {

	public static final String VERSION = "@version 1.0.0.1";

	@Override
	public int compare(Entry<String, PayPlanInfo> payPlanMap1, Entry<String, PayPlanInfo> payPlanMap2) {
		return DateUtil.isDateBefore(payPlanMap1.getValue().getStartDate(), payPlanMap2.getValue().getStartDate());
	}
}
