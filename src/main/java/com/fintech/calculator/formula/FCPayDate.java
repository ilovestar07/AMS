/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCDate.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.formula;

import com.fintech.base.contant.BaseDict;
import com.fintech.base.util.DateUtil;
import com.fintech.calculator.util.FCUtil;
import com.fintech.calculator.util.constant.FCDict;

public class FCPayDate {

	public static final String VERSION = "@version 1.0.0.1";

	private static final String DATE_DIR = "F";

	/**
	 * 计算下一个付息日
	 * 
	 * @param startDate
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	public static String getNextPayDate(String startDate, String date, String freq, String endMonthRule) {
		if (DATE_DIR.equals(FCDict.DATE_DIR_B)) {
			return getNextPayDateBack(startDate, date, freq, endMonthRule);
		} else {
			return getNextPayDateForward(startDate, date, freq, endMonthRule);
		}
	}

	/**
	 * 计算上一个付息日
	 * 
	 * @param startDate
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	public static String getLastPayDate(String startDate, String date, String freq, String endMonthRule) {
		if (DATE_DIR.equals(FCDict.DATE_DIR_B)) {
			return getLastPayDateBack(startDate, date, freq, endMonthRule);
		} else {
			return getLastPayDateForward(startDate, date, freq, endMonthRule);
		}
	}

	/**
	 * 从前向后计算下一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getNextPayDateForward(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		if (DateUtil.isDateBefore(date, startDate) == BaseDict.DATA_COMPARE.BEFORE) {
			return startDate;
		}
		Object[] obj = FCUtil.parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = FCUtil.fcAddDate(startDate, step, unit, i);
		while (DateUtil.isDateBefore(nextDate, date) == BaseDict.DATA_COMPARE.BEFORE
				|| DateUtil.isDateBefore(nextDate, date) == BaseDict.DATA_COMPARE.THEN) {
			i++;
			nextDate = FCUtil.fcAddDate(startDate, step, unit, i);
		}
		return nextDate;
	}

	/**
	 * 从后向前计算下一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getNextPayDateBack(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		String tempNextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == BaseDict.DATA_COMPARE.BEFORE) {
			return startDate;
		}
		Object[] obj = FCUtil.parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = startDate;
		tempNextDate = FCUtil.fcAddDate(startDate, step, unit, -i);
		while (DateUtil.isDateBefore(tempNextDate, date) == BaseDict.DATA_COMPARE.AFTER) {
			nextDate = tempNextDate;
			i++;
			tempNextDate = FCUtil.fcAddDate(startDate, step, unit, -i);
		}
		return nextDate;
	}

	/**
	 * 从前向后计算上一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getLastPayDateForward(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		String tempNextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == BaseDict.DATA_COMPARE.AFTER) {
			return startDate;
		}
		Object[] obj = FCUtil.parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = startDate;
		tempNextDate = FCUtil.fcAddDate(startDate, step, unit, i);
		while (DateUtil.isDateBefore(tempNextDate, date) == BaseDict.DATA_COMPARE.BEFORE
				|| DateUtil.isDateBefore(tempNextDate, date) == BaseDict.DATA_COMPARE.THEN) {
			nextDate = tempNextDate;
			i++;
			tempNextDate = FCUtil.fcAddDate(startDate, step, unit, i);
		}
		return nextDate;
	}

	/**
	 * 从后向前计算上一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getLastPayDateBack(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == BaseDict.DATA_COMPARE.BEFORE) {
			return startDate;
		}
		Object[] obj = FCUtil.parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = FCUtil.fcAddDate(startDate, step, unit, -i);
		while (DateUtil.isDateBefore(nextDate, date) == BaseDict.DATA_COMPARE.AFTER) {
			i++;
			nextDate = FCUtil.fcAddDate(startDate, step, unit, -i);
		}
		return nextDate;
	}
}
