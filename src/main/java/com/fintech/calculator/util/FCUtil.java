/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-12-31
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.util;

import com.fintech.base.util.DateUtil;
import com.fintech.calculator.util.constant.FCDict;

public class FCUtil {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 解析付息频率
	 * 
	 * @param freq 付息频率
	 * @return
	 */
	public static Object[] parseFreq(String freq) {
		Object[] ret = new Object[2];
		if (freq != null && freq.matches("[tT]|[0-9]+[dwmyDWMY]{1}")) {
			Integer setp = 0;
			if (freq.length() > 1) {
				setp = Integer.parseInt(freq.substring(0, freq.length() - 1));
			}
			String unit = freq.toLowerCase().substring(freq.length() - 1);
			ret[0] = setp;
			ret[1] = unit;
			return ret;
		} else {
			throw new java.lang.RuntimeException("频率格式错误！");
		}
	}
	
	/**
	 * 计算日期
	 * 
	 * @param date 开始日期
	 * @param step 步长
	 * @param unit 单位
	 * @param num 次数
	 * @return date + num * step个单位后的日期
	 */
	public static String fcAddDate(String date, Integer step, char unit, Integer num) {
		String retDate = date;
		switch (unit) {
		case FCDict.BASIS_UNIT.D:
			retDate = DateUtil.addDate(date, step * num);
			break;
		case FCDict.BASIS_UNIT.W:
			retDate = DateUtil.addDate(date, 7 * step * num);
			break;
		case FCDict.BASIS_UNIT.M:
			retDate = DateUtil.addMonth(date, step * num);
			break;
		case FCDict.BASIS_UNIT.S:
			retDate = DateUtil.addMonth(date, 3 * step * num);
			break;
		case FCDict.BASIS_UNIT.Y:
			retDate = DateUtil.addYears(date, step * num);
			break;
		}
		return retDate;
	}
}
