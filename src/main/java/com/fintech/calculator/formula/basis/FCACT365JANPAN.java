/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCACT365JANPAN.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula.basis;

import com.fintech.base.util.DateUtil;
import com.fintech.base.util.MathUtil;
import com.fintech.calculator.bean.AssetInfo;

public class FCACT365JANPAN {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 计息基础:ACT/365JANPAN ;
	 * 说明:如果 计息日 为闰年，并且>=3月1号则分子需要+1天,如果 到息日 为闰年，并且到息日为2月29号之前则分子需要+1天
	 * 计算公式:(计息区间 天数-区间包含的闰年数)/365 
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate) {
		Double factor = DateUtil.subDate(endDate, startDate);
		Double startYear = MathUtil.convObjToDou(DateUtil.getYear(startDate)); // 起息日的年份
		Double startMonth = MathUtil.convObjToDou(DateUtil.getYear(endDate)); // 起息日的月份
		Double endYear = MathUtil.convObjToDou(DateUtil.getMonth(endDate)) + 1.00; // 计息日的年份
		Double endMonth = MathUtil.convObjToDou(DateUtil.getDay(startDate)); // 计息日的月份
		Double endDay = MathUtil.convObjToDou(DateUtil.getDay(endDate)); // 计息日的日子

		// 对与开始日期、结束日期 只要是闰年，则总天数减一
		if (DateUtil.isLeapYear(startYear)) {
			factor = factor - 1.00;
		}
		if (startYear!=endYear && DateUtil.isLeapYear(endYear)) {
			factor = factor - 1.00;
		}
		// 如果起息日期为闰年且日期大于等于3月1日，则天数补回一天
		if (DateUtil.isLeapYear(startYear) && startMonth >= 3){
			factor += 1.00;
		}
		// 如果计息日期为闰年且日期为2月底之前，则天数补回一天
		if (DateUtil.isLeapYear(endYear)) {
			if (endMonth == 1.00 || (endMonth == 2.00 && endDay < 29.00)) {
				factor += 1.00;
			}
		}
		factor = MathUtil.div(factor, 365.00);
		return factor;
	}
}
