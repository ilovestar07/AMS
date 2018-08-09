/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FC30360ISDA.java
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

public class FC30360ISDA {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 计息基础:30/360ISDA ;
	 * 说明:startYear,startMonth,startDay , endYear,endMonth,endDay,分别表示 起息日年、月、日，到息日的年、月、日
	 * 计算公式 ： days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) + (endDay - startDay);
	 * calAD=(double) days / 360;
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate) {
		Double factor = 0.00;
		Double startYear = MathUtil.convObjToDou(DateUtil.getYear(startDate)); // 起息日的年份
		Double startMonth = MathUtil.convObjToDou(DateUtil.getYear(endDate)); // 起息日的月份
		Double startDay = MathUtil.convObjToDou(DateUtil.getMonth(startDate)) + 1.00; // 起息日的日子
		Double endYear = MathUtil.convObjToDou(DateUtil.getMonth(endDate)) + 1.00; // 计息日的年份
		Double endMonth = MathUtil.convObjToDou(DateUtil.getDay(startDate)); // 计息日的月份
		Double endDay = MathUtil.convObjToDou(DateUtil.getDay(endDate)); // 计息日的日子

		if (startDay == 31.00) {
			startDay = 30.00;
		}
		
		if (endDay == 31.00 && startDay == 30.00) {
			endDay = 30.00;
		}

		factor = MathUtil.div(MathUtil.add(MathUtil.add(MathUtil.mul(360.00, MathUtil.sub(endYear, startYear)), MathUtil.mul(30.00, MathUtil.sub(endMonth, startMonth))), MathUtil.sub(endDay, startDay)), 360.00);
		return factor;
	}
}
