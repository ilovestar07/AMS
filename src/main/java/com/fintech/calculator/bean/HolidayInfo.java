/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: HolidayInfo.java
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

public class HolidayInfo implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";
	
	private static final long serialVersionUID = -8302844100032727061L;
	
	private String dateType;
	
	private String dateCode;
	
	private String dateDir;
	
	private String workDate;
	
	private String workYear;

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getDateCode() {
		return dateCode;
	}

	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}

	public String getDateDir() {
		return dateDir;
	}

	public void setDateDir(String dateDir) {
		this.dateDir = dateDir;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	
}
