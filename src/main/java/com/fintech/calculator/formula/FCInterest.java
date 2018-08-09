/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCInterest.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula;

import com.fintech.base.util.MathUtil;
import com.fintech.calculator.bean.AssetInfo;
import com.fintech.calculator.formula.interest.FCCyclePay;
import com.fintech.calculator.formula.interest.FCDiscount;
import com.fintech.calculator.formula.interest.FCEndPay;
import com.fintech.calculator.util.constant.FCDict;

public class FCInterest {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 百份利息计算
	 * 
	 * @param assetInfo 资产信息
	 * @param date 结束日
	 * @return 利息金额
	 * @return
	 */
	public static Double fcInterest(AssetInfo assetInfo, String date) {
		Double shares = 100.00;
		if (MathUtil.convObjToDou(assetInfo.getFaceValue()) != 0.00) {
			shares = MathUtil.convObjToDou(assetInfo.getFaceValue());
		}
		return fcInterest(assetInfo, date, shares);
	}

	/**
	 * 利息计算
	 * 
	 * @param assetInfo 资产信息
	 * @param date 结束日
	 * @param shares 份额
	 * @return 利息金额
	 */
	public static Double fcInterest(AssetInfo assetInfo, String date, Double shares) {
		if (FCDict.ASSET_NATURE.CYCLEPAY.equals(assetInfo.getAssetNature())) {
			return FCCyclePay.calInterest(assetInfo, date, shares);
		} else if (FCDict.ASSET_NATURE.ENDPAY.equals(assetInfo.getAssetNature())) {
			return FCEndPay.calInterest(assetInfo, date, shares);
		} else if (FCDict.ASSET_NATURE.DISCOUNT.equals(assetInfo.getAssetNature())) {
			return FCDiscount.calInterest(assetInfo, date, shares);
		}
		return 0.00;
	}

}
