/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FC30360SIA.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula.basis;

import com.fintech.calculator.bean.AssetInfo;

public class FC30360SIA {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 计息基础:30/360SIA ;
	 * 说明:先计算 endDateTemp , 其年、月、日为endYearT, endMonthT, endDayT
	 * 如果payFreq为MT ， 则endDateTemp为到息日 ,否则endDateTemp为(起息日+payFreq)
	 * 如果 起息日为 31 ， 或者 (起 息日为月底并且endDateTemp为月底 )则 起 息日调整为 30
	 * 如果到期日的天数是月底且起息日的天数大于到期日,则让起息日=到期日
	 * 如果起息日为 月底 ，并且 到期日 所在日>起 息日所在 日 则到期日调整为 起息日
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);calAD=(double) days / 360;
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate) {
		return FC30360ISDA.calBasis(assetInfo, startDate, endDate);//TODO
	}
}
