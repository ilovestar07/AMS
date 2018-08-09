/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: PayPlanInfo.java
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

public class PayPlanInfo implements Serializable {
	
	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 4521065013789058213L;
	
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
	 * 序号
	 */
	private String lNo;

	/**
	 * 开始日期
	 */
	private String startDate;
	
	/**
	 * 结束日期
	 */
	private String endDate;
	
	/**
	 * 支付日期
	 */
	private String payDate;

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

	public String getlNo() {
		return lNo;
	}

	public void setlNo(String lNo) {
		this.lNo = lNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

}
