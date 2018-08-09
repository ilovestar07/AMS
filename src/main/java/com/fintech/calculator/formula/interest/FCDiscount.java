/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCNoPay.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula.interest;

import com.fintech.base.util.DateUtil;
import com.fintech.base.util.MathUtil;
import com.fintech.calculator.bean.AssetInfo;

public class FCDiscount {

	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 贴现：当前付息周期利息
	 * 
	 * @param assetInfo 资产信息
	 * @param date 结束日
	 * @param shares 份额
	 * @return 利息
	 */
	public static Double calInterest(AssetInfo assetInfo, String date, Double shares) {
		Double amt = 0.00;
		Double days = DateUtil.subDate(assetInfo.getEndDate(), assetInfo.getValueDate());
		Double t = DateUtil.subDate(date, assetInfo.getValueDate());
		Double discount = MathUtil.sub(
				shares,
				MathUtil.mul(
						shares,
						MathUtil.div(MathUtil.convObjToDou(assetInfo.getIssuePrice()),
								MathUtil.convObjToDou(assetInfo.getFaceValue()))));
		amt = MathUtil.mul(MathUtil.div(discount, days), t);
		return amt;
	}
	
	/**
	 * 贴现：从开始日到结束日之间的利息
	 * 
	 * @param assetInfo 资产信息
	 * @param startDate 开始日
	 * @param endDate 结束日
	 * @param shares 份额
	 * @return 利息
	 */
	public static Double calInterest(AssetInfo assetInfo, String startDate, String endDate, Double shares) {
		Double amt = 0.00;
		amt = MathUtil.sub(calInterest(assetInfo, endDate, shares), calInterest(assetInfo, startDate, shares));
		return amt;
	}
}
