/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCBasis.java
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
import com.fintech.calculator.util.constant.FCBasisDict;

public class FCBasis {

	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 计算利息因子
	 * 
	 * @param assetInfo
	 * @param startDate
	 * @param endDate
	 * @param i
	 * @return
	 */
	public static double calBasis(AssetInfo assetInfo, String startDate, String endDate, String legNo, String lNo) {
		String basis = assetInfo.getPayRuleMap().get(legNo).getCalBasis();
		if (FCBasisDict.BASIS_ACT_360.equals(basis)) {
			return FCACT360.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_ACT_365.equals(basis)) {
			return FCACT365.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_ACT_ACT.equals(basis)) {
			return FCACTACT.calBasis(assetInfo, startDate, endDate, legNo);
		} else if (FCBasisDict.BASIS_ACT_ACTISMA.equals(basis)) {
			return FCACTACTISMA.calBasis(assetInfo, startDate, endDate, legNo);
		} /*else if (FCBasisDict.BASIS_ACT_360ISDA.equals(basis)) {
			return FCACT360ISDA.calBasis(assetInfo, startDate, endDate);
		}*/ else if (FCBasisDict.BASIS_ACT_365ISDA.equals(basis)) {
			return FCACT365ISDA.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_ACT_ACTISDA.equals(basis)) {
			return FCACTACTISDA.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_30_360ISDA.equals(basis)) {
			return FC30360ISDA.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_30_360PSA.equals(basis)) {
			return FC30360PSA.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_30_360SIA.equals(basis)) {
			return FC30360SIA.calBasis(assetInfo, startDate, endDate);//TODO
		} else if (FCBasisDict.BASIS_30_360CMO.equals(basis)) {
			return FC30360CMO.calBasis(assetInfo, startDate, endDate);//TODO
		} else if (FCBasisDict.BASIS_30_360FIX.equals(basis)) {
			return FC30360FIX.calBasis(assetInfo, startDate, endDate);//TODO
		} else if (FCBasisDict.BASISE_30E_360.equals(basis)) {
			return FC30E360.calBasis(assetInfo, startDate, endDate);
		} else if (FCBasisDict.BASIS_ACT_365JANPAN.equals(basis)) {
			return FCACT365JANPAN.calBasis(assetInfo, startDate, endDate);
		} else {
			throw new java.lang.RuntimeException("不支持的计息基础!");
		}
	}
}
