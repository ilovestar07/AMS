/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 字符工具类
 * 类   名  称: StrUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-12-29
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.util;

public class StrUtil {
	
	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param s 字符串
	 * @return 是否为空
	 */
	public static boolean isNullStr(String s) {
		return (s == null) || (s.trim().length() <= 0);
	}
	
	/**
	 * 将整数转换成字符串
	 * 
	 * @param num 需要转换的整数
	 * @return 对应的字符串
	 */
	public static String numToStr(Integer num) {
		if (num != null) {
			return num.toString();
		} else {
			return "";
		}
	}

}
