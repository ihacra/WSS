package com.hacra.wss.common.config;

/**
 * Global
 * 
 * @author Hacra
 * @version 2020/05/12
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 私有化构造函数
	 */
	private Global() {}
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
}
