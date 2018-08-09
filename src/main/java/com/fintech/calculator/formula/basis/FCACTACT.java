/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCACTACT.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula.basis;

import com.fintech.base.contant.BaseDict;
import com.fintech.base.util.DateUtil;
import com.fintech.base.util.MathUtil;
import com.fintech.calculator.bean.AssetInfo;
import com.fintech.calculator.bean.PayRuleInfo;
import com.fintech.calculator.formula.FCPayDate;
import com.fintech.calculator.util.FCUtil;
import com.fintech.calculator.util.constant.FCDict;

public class FCACTACT {

	public static final String VERSION = "@version 1.0.0.1";
	
	public static final String FREQ_1Y = "12m";

	/**
	 * 计息基础:ACT/ACT ;
	 * 计算公式:ACT/ACT与ACT/ACTISMA一致
	 * 
	 * @param assetInfo 资产基础信息
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param legNo 腿号
	 * @return 计息因子
	 */
	protected static double calBasis(AssetInfo assetInfo, String startDate, String endDate, String legNo) {
		PayRuleInfo payRuleInfo = assetInfo.getPayRuleMap().get(legNo);
		if (FCDict.BASIS_TYPE.AVE.equals(payRuleInfo.getBasisType())) {
			return calBasisAVE(assetInfo, startDate, endDate, payRuleInfo);
		} else {
			return calBasisACT(assetInfo, startDate, endDate);
		}
	}
	
	/**
	 * ACT/ACT按实际天数付息的计算利息因子
	 * 
	 * @param assetInfo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private static double calBasisACT(AssetInfo assetInfo, String startDate, String endDate) {
		Double factor = 0.00;
		String theoryValueDate = FCPayDate.getLastPayDate(assetInfo.getValueDate(), endDate, FREQ_1Y, "");
		String theoryEndDate = FCPayDate.getNextPayDate(assetInfo.getValueDate(), endDate, FREQ_1Y, "");
		Double theoryDays = DateUtil.subDate(theoryEndDate, theoryValueDate);
		if (DateUtil.isDateBefore(theoryEndDate, endDate) == BaseDict.DATA_COMPARE.BEFORE) {
			factor = MathUtil.div(DateUtil.subDate(theoryEndDate, startDate), theoryDays);
			String lastStart = FCPayDate.getLastPayDate(assetInfo.getValueDate(), endDate, FREQ_1Y, "");
			String lastEnd = FCPayDate.getNextPayDate(assetInfo.getValueDate(), endDate, FREQ_1Y, "");
			theoryDays = DateUtil.subDate(lastEnd, lastStart);
			factor = MathUtil.add(MathUtil.add(factor, DateUtil.subYear(lastStart, theoryEndDate)),
					MathUtil.div(DateUtil.subDate(endDate, lastStart), theoryDays));
		} else {
			factor = MathUtil.div(DateUtil.subDate(endDate, startDate), theoryDays);
		}
		return factor;
	}
	
	/**
	 * ACT/ACT按平均值付息的计算利息因子
	 * 
	 * @param assetInfo
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private static double calBasisAVE(AssetInfo assetInfo, String startDate, String endDate, PayRuleInfo payRuleInfo) {
		Double factor = 0.00;
		String theoryPayStartDate = FCPayDate.getLastPayDate(assetInfo.getValueDate(), startDate, payRuleInfo.getPayFreq(), "");
		String theoryPayEndDate = FCPayDate.getNextPayDate(assetInfo.getValueDate(), startDate, payRuleInfo.getPayFreq(), "");
		double days = DateUtil.subDate(theoryPayEndDate, theoryPayStartDate);
		Object[] f = FCUtil.parseFreq(payRuleInfo.getPayFreq());
		int step = (Integer)f[0];
		char basis_unit = ((String)f[1]).charAt(0);
		if(step==0){
			return 1.00;
		}else{
			if (basis_unit==FCDict.BASIS_UNIT.M || basis_unit==FCDict.BASIS_UNIT.S) {
				factor = MathUtil.div(MathUtil.div(DateUtil.subDate(endDate, startDate), days), MathUtil.div(12.00, step));
			} else {
				throw new java.lang.RuntimeException("平均值法只能对应频率到月或者季！");
			}
		}
		return factor;
	}
}
