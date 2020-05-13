package com.hacra.wss.template;

/**
 * TmpTest
 * 
 * @author Hacra
 * @date 2020/05/13
 */
public class TemplateMain {

	private static final String CN = "User";	
	private static final String FS = "private String name;\r\n" + 
			"private String loginName;\r\n" + 
			"private String password;\r\n" + 
			"private String gender;\r\n" + 
			"private String nation;\r\n" + 
			"private Date birthdate;\r\n" + 
			"private String address;\r\n" + 
			"private String email;\r\n" + 
			"private String mobile;\r\n" + 
			"private String perSign;";		
		
	public static void main(String[] args) {
		TemplateUtils.init(CN, FS);
		TemplateUtils.daoTemplate();
	}
}
