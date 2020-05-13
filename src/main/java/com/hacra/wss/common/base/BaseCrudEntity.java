package com.hacra.wss.common.base;

import java.util.Date;

import com.hacra.wss.common.util.StringUtils;
import com.hacra.wss.modules.sys.entity.User;
import com.hacra.wss.modules.sys.util.UserUtils;

/**
 * DataEntity
 * 
 * @author Hacra
 * @version 2020/05/12
 */
public abstract class BaseCrudEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	/** 创建者 */
	protected User createBy;	
	/** 创建日期 */
	protected Date createDate;	
	/** 更新者 */
	protected User updateBy;
	/** 更新日期 */
	protected Date updateDate;	
	/** 删除标记（0：正常；1：删除） */
	protected String delFlag; 
	
	public BaseCrudEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public BaseCrudEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用,自定义ID
	 */
	@Override
	public void preInsert(String id) {
		if (StringUtils.isNotBlank(id)) {
			this.setId(id);
		}
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
			this.createBy = user;
		} else {
			this.updateBy = new User("1");
			this.createBy = new User("1");
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate() {
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
		} else {
			this.updateBy = new User("1");
		}
		this.updateDate = new Date();
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
