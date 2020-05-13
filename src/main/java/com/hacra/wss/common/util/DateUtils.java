package com.hacra.wss.common.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * DateUtils
 * 
 * @author Hacra
 * @date 2020/05/13
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
	}
}
