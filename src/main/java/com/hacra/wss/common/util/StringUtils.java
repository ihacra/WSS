package com.hacra.wss.common.util;

/**
 * StringUtils
 * 
 * @author Hacra
 * @date 2020/05/11
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * 驼峰命名转下划线命名
	 * createBy => create_by
	 * @param camelCase
	 * @return
	 */
	public static String camelCase2UnderScoreCase(String camelCase) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < camelCase.length(); i++) {
			char c = camelCase.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				sBuilder.append("_").append((char)(c + 32));
			} else {
				sBuilder.append(c);
			}
		}
		return sBuilder.toString();
	}
}
