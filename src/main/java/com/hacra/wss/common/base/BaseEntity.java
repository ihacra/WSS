package com.hacra.wss.common.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.hacra.wss.common.utils.StringUtils;

/**
 * BaseEntity
 * 
 * @author Hacra
 * @version 2020/05/12
 */
public abstract class BaseEntity<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;
	
	/**
	 * 是否是新记录（默认：false）
	 */
	protected boolean isNewRecord = false;
	
	/**
	 * 自定义SQL（SQL标识，SQL内容）
	 */
	protected Map<String, String> sqlMap;
	
	/**
	 * 删除标记（0：正常）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	
	/**
	 * 删除标记（1：删除）
	 */
	public static final String DEL_FLAG_DELETE = "1";
	
	public BaseEntity() {
		
	}
	
	public BaseEntity(String id) {
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsNewRecord() {
		return isNewRecord || StringUtils.isBlank(getId());
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	public Map<String, String> getSqlMap() {
		if (sqlMap == null) {
			sqlMap = new HashMap<String, String>(16);
		}
		return sqlMap;
	}

	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert(String id);
	
	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		BaseEntity<?> that = (BaseEntity<?>)obj;
		return StringUtils.equals(this.getId(), that.getId());
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
