/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: AssetInfo.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.bean;

import java.io.Serializable;
import java.util.HashMap;

public class AssetInfo implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 4207424268309964849L;

	/**
	 * 资产类型
	 */
	private String assetType;
	
	/**
	 * 资产子类型
	 */
	private String assetSubtype;
	
	/**
	 * 资产内码
	 */
	private String assetICode;
	
	/**
	 * 资产名称
	 */
	private String assetName;

	/**
	 * 起息日
	 */
	private String valueDate;

	/**
	 * 到期日
	 */
	private String endDate;

	/**
	 * 币种
	 */
	private String currType;

	/**
	 * 性质
	 */
	private String assetNature;

	/**
	 * 还本方式
	 */
	private String repayType;

	/**
	 * 面额
	 */
	private String faceValue;

	/**
	 * 发行价
	 */
	private String issuePrice;
	
	/**
	 * 付息规则信息：<腿号,付息规则信息>
	 */
	private HashMap<String, PayRuleInfo> payRuleMap;

	/**
	 * 付息计划信息：<腿号_序号,付息计划信息>
	 */
	private HashMap<String, PayPlanInfo> payPlanMap;
	
	/**
	 * 还本计划信息：<序号,还本计划信息>
	 */
	private HashMap<String, RepayPlanInfo> RepayPlanMap;

	/**
	 * 利率信息：<腿号_序号,利率信息>
	 */
	private HashMap<String, RateInfo> rateMap;

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetSubtype() {
		return assetSubtype;
	}

	public void setAssetSubtype(String assetSubtype) {
		this.assetSubtype = assetSubtype;
	}

	public String getAssetICode() {
		return assetICode;
	}

	public void setAssetICode(String assetICode) {
		this.assetICode = assetICode;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	public String getAssetNature() {
		return assetNature;
	}

	public void setAssetNature(String assetNature) {
		this.assetNature = assetNature;
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getIssuePrice() {
		return issuePrice;
	}

	public void setIssuePrice(String issuePrice) {
		this.issuePrice = issuePrice;
	}

	public HashMap<String, PayRuleInfo> getPayRuleMap() {
		return payRuleMap;
	}

	public void setPayRuleMap(HashMap<String, PayRuleInfo> payRuleMap) {
		this.payRuleMap = payRuleMap;
	}

	public HashMap<String, PayPlanInfo> getPayPlanMap() {
		return payPlanMap;
	}

	public void setPayPlanMap(HashMap<String, PayPlanInfo> payPlanMap) {
		this.payPlanMap = payPlanMap;
	}

	public HashMap<String, RepayPlanInfo> getRepayPlanMap() {
		return RepayPlanMap;
	}

	public void setRepayPlanMap(HashMap<String, RepayPlanInfo> repayPlanMap) {
		RepayPlanMap = repayPlanMap;
	}

	public HashMap<String, RateInfo> getRateMap() {
		return rateMap;
	}

	public void setRateMap(HashMap<String, RateInfo> rateMap) {
		this.rateMap = rateMap;
	}

}
