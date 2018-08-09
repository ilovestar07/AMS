/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCACTACTISMA.java
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

public class FCACTACTISMA {

	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 计息基础:ACT/ACTIMSA ;
	 * 计算公式:与ACT/ACT一致
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param legNo 腿号
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate, String legNo) {
		return FCACTACT.calBasis(assetInfo, startDate, endDate, legNo);
	}
}
