/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: PayRuleInfo.java
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

public class PayRuleInfo implements Serializable{

	public static final String VERSION = "@version 1.0.0.1";
	
	private static final long serialVersionUID = 6321157124607040684L;
	
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
	 * 腿号
	 */
	private String legNo;
	
	/**
	 * 币种
	 */
	private String currType;
	
	/**
	 * 支付方向
	 */
	private String payDir;
	
	/**
	 * 付息规则
	 */
	private String freqRule;
	
	/**
	 * 付息频率
	 */
	private String payFreq;
	
	/**
	 * 计息基础
	 */
	private String calBasis;
	
	/**
	 * 计息方式：平均值/实际天数
	 */
	private String basisType;
	
	/**
	 * 首期结束日
	 */
	private String firstEndDate;
	
	/**
	 * 倒数第二期结束日
	 */
	private String lastEndDate;
	
	/**
	 * 月末规则
	 */
	private String endMonthRule;
	
	/**
	 * 结息顺延规则
	 */
	private String deferRule;
	
	/**
	 * 付息顺延规则
	 */
	private String payDeferRule;
	
	/**
	 * 节假日规则
	 */
	private String holidayRule;
	
	/**
	 * 节假日：<节假日类型,<日期,是否节假日>>
	 */
	private HashMap<String, HashMap<String, String>> holidays;

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

	public String getLegNo() {
		return legNo;
	}

	public void setLegNo(String legNo) {
		this.legNo = legNo;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	public String getPayDir() {
		return payDir;
	}

	public void setPayDir(String payDir) {
		this.payDir = payDir;
	}

	public String getFreqRule() {
		return freqRule;
	}

	public void setFreqRule(String freqRule) {
		this.freqRule = freqRule;
	}

	public String getPayFreq() {
		return payFreq;
	}

	public void setPayFreq(String payFreq) {
		this.payFreq = payFreq;
	}

	public String getCalBasis() {
		return calBasis;
	}

	public void setCalBasis(String calBasis) {
		this.calBasis = calBasis;
	}

	public String getBasisType() {
		return basisType;
	}

	public void setBasisType(String basisType) {
		this.basisType = basisType;
	}

	public String getFirstEndDate() {
		return firstEndDate;
	}

	public void setFirstEndDate(String firstEndDate) {
		this.firstEndDate = firstEndDate;
	}

	public String getLastEndDate() {
		return lastEndDate;
	}

	public void setLastEndDate(String lastEndDate) {
		this.lastEndDate = lastEndDate;
	}

	public String getEndMonthRule() {
		return endMonthRule;
	}

	public void setEndMonthRule(String endMonthRule) {
		this.endMonthRule = endMonthRule;
	}

	public String getDeferRule() {
		return deferRule;
	}

	public void setDeferRule(String deferRule) {
		this.deferRule = deferRule;
	}

	public String getPayDeferRule() {
		return payDeferRule;
	}

	public void setPayDeferRule(String payDeferRule) {
		this.payDeferRule = payDeferRule;
	}

	public String getHolidayRule() {
		return holidayRule;
	}

	public void setHolidayRule(String holidayRule) {
		this.holidayRule = holidayRule;
	}

	public HashMap<String, HashMap<String, String>> getHolidays() {
		return holidays;
	}

	public void setHolidays(HashMap<String, HashMap<String, String>> holidays) {
		this.holidays = holidays;
	}

}
