/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCCyclePay.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula.interest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fintech.base.contant.BaseDict;
import com.fintech.base.util.DateUtil;
import com.fintech.base.util.MathUtil;
import com.fintech.calculator.bean.AssetInfo;
import com.fintech.calculator.bean.PayPlanInfo;
import com.fintech.calculator.bean.PayPlanInfoSort;
import com.fintech.calculator.bean.RateInfo;
import com.fintech.calculator.bean.RateInfoSort;
import com.fintech.calculator.bean.RepayPlanInfo;
import com.fintech.calculator.bean.RepayPlanInfoSort;
import com.fintech.calculator.formula.basis.FCBasis;

public class FCCyclePay {

	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 期间付息：当前付息周期利息
	 * 
	 * @param assetInfo 资产信息
	 * @param date 结束日
	 * @param shares 份额
	 * @return 利息金额
	 */
	public static Double calInterest(AssetInfo assetInfo, String date, Double shares) {
		Double amt = 0.00;
		HashMap<String, PayPlanInfo> payPlanInfoMap = assetInfo.getPayPlanMap();
		List<Map.Entry<String,PayPlanInfo>> payPlanList=new ArrayList<>();
		if (payPlanInfoMap !=null) {
			payPlanList.addAll(payPlanInfoMap.entrySet());  
			PayPlanInfoSort payPlanInfoSort = new PayPlanInfoSort();
			Collections.sort(payPlanList, payPlanInfoSort);
		}
		
		HashMap<String, RateInfo> rateInfoMap = assetInfo.getRateMap();
		List<Map.Entry<String,RateInfo>> rateList=new ArrayList<>(); 
		if (rateInfoMap !=null) {
			rateList.addAll(rateInfoMap.entrySet());  
			RateInfoSort rateInfoSort = new RateInfoSort();
			Collections.sort(rateList, rateInfoSort);
		}
		
		HashMap<String, RepayPlanInfo> repayPlanMap = assetInfo.getRepayPlanMap();
		List<Map.Entry<String,RepayPlanInfo>> repayPlanList=new ArrayList<>();
		if (repayPlanMap !=null) {
			repayPlanList.addAll(repayPlanMap.entrySet());  
			RepayPlanInfoSort repayPlanInfoSort = new RepayPlanInfoSort();
			Collections.sort(repayPlanList, repayPlanInfoSort);
		}
		
		if (payPlanList != null && payPlanList.size() > 0) {
			PayPlanInfo payPlanInfo;
			for (int i = 0; i < payPlanList.size(); i++) {
				payPlanInfo = payPlanList.get(i).getValue();
				if (payPlanInfo != null && (DateUtil.isDateBefore(payPlanInfo.getStartDate(), date) == BaseDict.DATA_COMPARE.AFTER
									     || DateUtil.isDateBefore(payPlanInfo.getStartDate(), date) == BaseDict.DATA_COMPARE.THEN)) {
					break;
				}
				String startDate;
				String endDate;
				if (payPlanInfo != null
						&& (DateUtil.isDateBefore(payPlanInfo.getStartDate(), date) == BaseDict.DATA_COMPARE.BEFORE 
						 || DateUtil.isDateBefore(payPlanInfo.getStartDate(), date) == BaseDict.DATA_COMPARE.THEN)
						&& DateUtil.isDateBefore(payPlanInfo.getEndDate(), date) == BaseDict.DATA_COMPARE.AFTER) {
					startDate = payPlanInfo.getStartDate();
					endDate = date;
					if (DateUtil.isDateBefore(startDate, assetInfo.getValueDate()) == BaseDict.DATA_COMPARE.BEFORE) {
						startDate = assetInfo.getValueDate();
					}
					if (DateUtil.isDateBefore(endDate, assetInfo.getEndDate()) == BaseDict.DATA_COMPARE.AFTER) {
						endDate = assetInfo.getEndDate();
					}
					
					if (rateList != null && rateList.size() > 0) {
						RateInfo rateInfo;
						String startDateTemp;
						String endDateTemp;
						for (int j = 0; j < rateList.size(); j++) {
							rateInfo = rateList.get(j).getValue();
							if (rateInfo != null && (DateUtil.isDateBefore(rateInfo.getStartDate(), endDate) == BaseDict.DATA_COMPARE.AFTER
												  || DateUtil.isDateBefore(rateInfo.getStartDate(), endDate) == BaseDict.DATA_COMPARE.THEN)) {
								break;
							}
							if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getEndDate(), startDate) == BaseDict.DATA_COMPARE.AFTER) {
								startDateTemp = rateInfo.getStartDate();
								endDateTemp = rateInfo.getEndDate();
								Double ratio = 0.00;
								if (DateUtil.isDateBefore(startDateTemp, startDate) == BaseDict.DATA_COMPARE.BEFORE) {
									startDateTemp = startDate;
								}
								if (DateUtil.isDateBefore(endDateTemp, endDate) == BaseDict.DATA_COMPARE.AFTER) {
									endDateTemp = endDate;
								}
								if (repayPlanList != null && repayPlanList.size() > 0) {
									for (int k = 0; k < repayPlanList.size(); k++) {
										RepayPlanInfo repayPlanInfo = repayPlanList.get(k).getValue();
										if (DateUtil.isDateBefore(repayPlanInfo.getEndDate(), startDateTemp) == BaseDict.DATA_COMPARE.BEFORE
										 || DateUtil.isDateBefore(repayPlanInfo.getEndDate(), startDateTemp) == BaseDict.DATA_COMPARE.THEN) {
											ratio = MathUtil.add(ratio, MathUtil.convObjToDou(repayPlanInfo.getRepayRatio()));
											continue;
										}
										
										if (DateUtil.isDateBefore(repayPlanInfo.getEndDate(), startDateTemp) == BaseDict.DATA_COMPARE.AFTER
										 && DateUtil.isDateBefore(repayPlanInfo.getEndDate(), endDateTemp) == BaseDict.DATA_COMPARE.BEFORE) {
											endDateTemp = repayPlanInfo.getEndDate();
											Double basis = FCBasis.calBasis(assetInfo, startDateTemp, endDateTemp, payPlanList.get(0).getValue().getLegNo(), payPlanList.get(0).getValue().getLegNo());
											amt += MathUtil.mul(MathUtil.mul(MathUtil.mul(shares, MathUtil.sub(1.00, ratio)), MathUtil.convObjToDou(rateInfo.getRate())), basis);
											startDateTemp = endDateTemp;
											endDateTemp = endDate;
											ratio = MathUtil.add(ratio, MathUtil.convObjToDou(repayPlanInfo.getRepayRatio()));
										}
									}
								}
								if (DateUtil.isDateBefore(startDateTemp, endDateTemp) == BaseDict.DATA_COMPARE.BEFORE) {
									Double basis = FCBasis.calBasis(assetInfo, startDateTemp, endDateTemp, payPlanList.get(0).getValue().getLegNo(), payPlanList.get(0).getValue().getLegNo());
									amt += MathUtil.mul(MathUtil.mul(MathUtil.mul(shares, MathUtil.sub(1.00, ratio)), MathUtil.convObjToDou(rateInfo.getRate())), basis);
								} 
							}
						}
					}
				}
			}
		}
		return amt;
	}

//	/**
//	 * 期间付息：从开始日到结束日之间的利息
//	 * 
//	 * @param assetInfo 资产信息
//	 * @param startDate 开始日
//	 * @param endDate 结束日
//	 * @param shares 份额
//	 * @return 利息金额
//	 */
//	public static Double calInterest(AssetInfo assetInfo, String startDate, String endDate, Double shares) {
//		Double amt = 0.00;
//		HashMap<String, PayPlanInfo> payPlanInfoMap = assetInfo.getPayPlanMap();
//		List<Map.Entry<String,PayPlanInfo>> payPlanList=new ArrayList<>();  
//		payPlanList.addAll(payPlanInfoMap.entrySet());  
//		PayPlanInfoSort payPlanInfoSort = new PayPlanInfoSort();
//		Collections.sort(payPlanList, payPlanInfoSort);
//		
//		HashMap<String, RateInfo> rateInfoMap = assetInfo.getRateMap();
//		List<Map.Entry<String,RateInfo>> rateList=new ArrayList<>();  
//		rateList.addAll(rateInfoMap.entrySet());  
//		RateInfoSort rateInfoSort = new RateInfoSort();
//		Collections.sort(rateList, rateInfoSort);
//		
//		if (payPlanList != null && payPlanList.size() > 0) {
//			PayPlanInfo payPlanInfo;
//			for (int i = 0; i < payPlanList.size(); i++) {
//				String startDateTemp;
//				String endDateTemp;
//				payPlanInfo = payPlanList.get(i).getValue();
//				if (payPlanInfo != null
//						&& (DateUtil.isDateBefore(payPlanInfo.getStartDate(), endDate) == FCDict.DATA_BEFORE || DateUtil
//								.isDateBefore(payPlanInfo.getStartDate(), endDate) == FCDict.DATA_THEN)
//						&& DateUtil.isDateBefore(payPlanInfo.getStartDate(), startDate) == FCDict.DATA_AFTER) {
//					startDateTemp = payPlanInfo.getStartDate();
//					endDateTemp = payPlanInfo.getEndDate();
//					if (DateUtil.isDateBefore(startDateTemp, startDate) == FCDict.DATA_BEFORE) {
//						startDateTemp = startDate;
//					}
//					if (DateUtil.isDateBefore(endDateTemp, endDate) == FCDict.DATA_AFTER) {
//						endDateTemp = endDate;
//					}
//					
//					if (rateList != null && rateList.size() > 0) {
//						RateInfo rateInfo;
//						String rateStartDateTemp;
//						String rateEndDateTemp;
//						for (int j = 0; j < rateList.size(); j++) {
//							rateInfo = rateList.get(j).getValue();
//							if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getStartDate(), endDate) == FCDict.DATA_AFTER) {
//								break;
//							}
//							if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getEndDate(), startDate) == FCDict.DATA_AFTER) {
//								rateStartDateTemp = rateInfo.getStartDate();
//								rateEndDateTemp = rateInfo.getEndDate();
//								if (DateUtil.isDateBefore(rateStartDateTemp, startDate) == FCDict.DATA_BEFORE) {
//									rateStartDateTemp = startDate;
//								}
//								if (DateUtil.isDateBefore(rateEndDateTemp, endDate) == FCDict.DATA_AFTER) {
//									rateEndDateTemp = endDate;
//								}
//								Double basis = FCBasis.calBasis(assetInfo, rateStartDateTemp, rateEndDateTemp, payPlanInfo.getLegNo(), payPlanInfo.getlNo());
//								amt += MathUtil.mul(MathUtil.mul(shares, MathUtil.convObjToDou(rateInfo.getRate())), basis);
//							}
//						}
//					}
//				}
//			}
//		}
//		return amt;
//	}
}
