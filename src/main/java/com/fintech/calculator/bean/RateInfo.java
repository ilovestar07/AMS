/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: RateInfo.java
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

public class RateInfo implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = -5690141739965718489L;

	/**
	 * 类型
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
	 * 序号
	 */
	private String lNo;

	/**
	 * 计算方式
	 */
	private String calMode;

	/**
	 * 开始日期
	 */
	private String startDate;

	/**
	 * 结束日期
	 */
	private String endDate;

	/**
	 * 利率
	 */
	private String rate;

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

	public String getlNo() {
		return lNo;
	}

	public void setlNo(String lNo) {
		this.lNo = lNo;
	}

	public String getCalMode() {
		return calMode;
	}

	public void setCalMode(String calMode) {
		this.calMode = calMode;
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}
