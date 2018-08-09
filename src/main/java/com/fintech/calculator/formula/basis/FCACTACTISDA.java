/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCACTACTISDA.java
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

public class FCACTACTISDA {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 计息基础:ACT/ACTISDA ;
	 * 计算公式:天数计算分数=(落在闰年的计息天数/366)+（落在平年的计息天数/365);与ACT/365ISDA公式计算方法一致
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate) {
		Double factor = 0.00;
		String startYear = DateUtil.getYearStr(startDate);
		String endYear = DateUtil.getYearStr(endDate);
		if (startYear.equals(endYear)) {
			factor = MathUtil.div(DateUtil.subDate(endDate, startDate), DateUtil.getNaturalYearDays(startYear));
		} else {
			String middleDate = endYear + "0101";
			factor = MathUtil.add(
					MathUtil.div(DateUtil.subDate(middleDate, startDate), DateUtil.getNaturalYearDays(startYear)),
					MathUtil.div(DateUtil.subDate(endDate, middleDate), DateUtil.getNaturalYearDays(endYear)));
		}
		return factor;
	}
}
