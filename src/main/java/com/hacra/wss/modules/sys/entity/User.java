package com.hacra.wss.modules.sys.entity;

import java.util.Date;

import com.hacra.wss.common.base.BaseCrudEntity;

/**
 * User
 * 
 * @author Hacra
 * @date 2020/05/11
 */
public class User extends BaseCrudEntity<User> {

	private static final long serialVersionUID = 1L;
	/** 姓名 */
	private String name;		
	/** 登录名 */
	private String loginName;		
	/** 密码 */
	private String password;		
	/** 性别 */
	private String gender;
	/** 民族 */
	private String nation;
	/** 出生日期 */
	private Date birthdate;
	/** 居住地址 */
	private String address;
	/** 电子邮箱 */
	private String email;
	/** 手机号码 */
	private String mobile;
	/** 个人签名 */
	private String perSign;
	
	public User() {
		super();
	}
	
	public User(String id) {
		super(id);
	}
	
	public User(String id, String loginName) {
		super(id);
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPerSign() {
		return perSign;
	}

	public void setPerSign(String perSign) {
		this.perSign = perSign;
	}
}
