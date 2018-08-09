/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCDict.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.calculator.util.constant;

public class FCDict {

	public static final String VERSION = "@version 1.0.0.1";

	/**资产性质*/
	public static interface ASSET_NATURE {
		/**资产性质*/
		public static final String NAME = "ASSET_NATURE";
		/**资产性质:期间付息*/
		public static final String CYCLEPAY = "01";
		/**资产性质:到期付息*/
		public static final String ENDPAY = "02";
		/**资产性质:贴现*/
		public static final String DISCOUNT = "03";
	}
	
	/**计息方式*/
	public static interface BASIS_TYPE {
		/**计息方式*/
		public static final String NAME = "BASIS_TYPE";
		/**计息方式:实际天数*/
		public static final String ACT = "01";
		/**计息方式:平均值*/
		public static final String AVE = "02";
	}
	
	/**付息规则*/
	public static interface FREQ_RULE {
		/**付息规则*/
		public static final String NAME = "FREQ_RULE";
		/**付息规则:不规则*/
		public static final String IRREGULAR = "00";
		/**付息规则:定期*/
		public static final String REGULAR = "01";
		/**付息规则:自然月*/
		public static final String MONTH = "02";
		/**付息规则:自然季*/
		public static final String SEASON = "03";
		/**付息规则:到期*/
		public static final String MATURITY = "T";
	}
	
	
	/**付息单位*/
	public static interface BASIS_UNIT {
		/**付息单位*/
		public static final String NAME = "BASIS_UNIT";
		/**付息单位:天*/
		public static final char D = 'd';
		/**付息单位:周*/
		public static final char W = 'w';
		/**付息单位:月*/
		public static final char M = 'm';
		/**付息单位:季*/
		public static final char S = 's';
		/**付息单位:年*/
		public static final char Y = 'y';
	}
	

	/*********************** 日期方向 ***********************/
	/**
	 * 日期方向:向后
	 */
	public static final String DATE_DIR_F = "F";
	/**
	 * 日期方向:向前
	 */
	public static final String DATE_DIR_B = "B";
}
