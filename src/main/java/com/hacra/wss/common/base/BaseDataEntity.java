package com.hacra.wss.common.base;

import java.util.Date;

import com.hacra.wss.modules.sys.entity.User;

/**
 * DataEntity
 * 
 * @author Hacra
 * @version 2020/05/12
 */
public abstract class BaseDataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 创建者
	 */
	protected User createBy;	
	/**
	 * 创建日期
	 */
	protected Date createDate;	
	/**
	 * 更新者
	 */
	protected User updateBy;
	/**
	 * 更新日期
	 */
	protected Date updateDate;	
	/**
	 * 删除标记（0：正常；1：删除）
	 */
	protected String delFlag; 
	
	public BaseDataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public BaseDataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用,自定义ID
	 */
	@Override
	public void preInsert(String id) {
		
	}
}
