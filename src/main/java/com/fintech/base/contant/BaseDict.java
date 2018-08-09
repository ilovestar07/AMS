/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 基础数据字典
 * 类   名  称: BaseDict.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.contant;

public class BaseDict {

	/**数据大小*/
	public static interface DATA_COMPARE {
		/**数据大小*/
		public static final String NAME = "DATA_COMPARE";
		/**数据大小:大于*/
		public static final Integer AFTER = 1;
		/**数据大小:等于*/
		public static final Integer THEN = 0;
		/**数据大小:小于*/
		public static final Integer BEFORE = -1;
	}
}
