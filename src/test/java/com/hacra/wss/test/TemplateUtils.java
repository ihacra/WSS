package com.hacra.wss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hacra.wss.common.util.StringUtils;

/**
 * TemplateUtils
 * 
 * @author Hacra
 * @date 2020/05/13
 */
public class TemplateUtils {

	private static String FS, CN, CN1 , CN2, CN3;
	private static List<String[]> FIELD = new ArrayList<String[]>();

	public static void init(String cn0, String fs0) {
		CN = cn0;
		FS = fs0;
		CN1 = String.valueOf((char)(CN.charAt(0)+32)) + CN.substring(1);
		CN2 = CN.toLowerCase();
		CN3 = StringUtils.camelCase2UnderScoreCase(CN1);
		String[] fss = FS.split("\\r\\n");
		String regex = "private\\s+?([a-zA-Z]+?)\\s+?([\\w\\W]+?);$";
		Pattern pattern = Pattern.compile(regex);
		for (String fs : fss) {
			Matcher matcher = pattern.matcher(fs);
			if (matcher.find()) {
				String usc = StringUtils.camelCase2UnderScoreCase(matcher.group(2));
				FIELD.add(new String[] {matcher.group(1), matcher.group(2), usc});
			}
		}
	}
	
	public static void daoTemplate() {
		System.out.printf("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
				"<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n" + 
				"<mapper namespace=\"com.zgh.amc.modules.%s.dao.%sDao\">\n\n", CN2.endsWith("det") ? CN2.subSequence(0, CN2.length()-3) : CN2, CN);
		daoSelect();
		daoGet();
		daoFindList();
		daoInsert();
		daoUpdate();
		daoDelete();
		daoGetNextId();
		System.out.println("</mapper>\n");
	}
	
	private static void daoSelect() {
		System.out.printf("\t<sql id=\"%sColumns\">\n", CN1);
		System.out.printf("\t\ta.id AS \"id\",\n");
		for (int i = 0; i < FIELD.size(); i++) {
			String[] fs = FIELD.get(i);
			System.out.printf("\t\ta.%s AS \"%s\",\n", fs[2], fs[1]);
		}
		System.out.printf("\t\ta.%s AS \"%s\",\n", "create_by", "createBy.id");
		System.out.printf("\t\ta.%s AS \"%s\",\n", "create_date", "createDate");
		System.out.printf("\t\ta.%s AS \"%s\",\n", "update_by", "updateBy.id");
		System.out.printf("\t\ta.%s AS \"%s\",\n", "update_date", "updateDate");
		System.out.printf("\t\ta.%s AS \"%s\"\n", "del_flag", "delFlag");
		System.out.printf("\t</sql>\n\n");
	}

	private static void daoGet() {
		System.out.printf("\t<select id=\"get\" resultType=\"%s\">\r\n" + 
				"\t\tSELECT\r\n" + 
				"\t\t<include refid=\"%sColumns\"/>\r\n" + 
				"\t\tFROM %s a\r\n" + 
				"\t\tWHERE a.id = #{id}\r\n" + 
				"\t</select>\n\n", CN, CN1, CN3);
	}
	
	private static void daoFindList() {
		System.out.printf("\t<select id=\"findList\" resultType=\"%s\">\r\n" + 
				"\t\tSELECT\r\n" + 
				"\t\t<include refid=\"%sColumns\"/>\r\n" + 
				"\t\tFROM %s a\r\n" + 
				"\t\t<where>\r\n" +
				"\t\t\ta.del_flag = #{DEL_FLAG_NORMAL}\r\n" + 
				"\t\t</where>\r\n", CN, CN1, CN3);
		System.out.printf("\t\tORDER BY CAST(a.id AS SIGNED) DESC\r\n" + 
				"\t</select>\n\n");
	}
	
	private static void daoInsert() {
		System.out.printf("\t<insert id=\"insert\">\n");
		System.out.printf("\t\tINSERT INTO %s (\n", CN3);
		System.out.printf("\t\t\t%s\n", "id");
		for (int i = 0; i < FIELD.size(); i++) {
			String[] fs = FIELD.get(i);
			System.out.printf("\t\t\t%s,\n", fs[2]);
		}
		System.out.printf("\t\t\t%s,\n", "create_by");
		System.out.printf("\t\t\t%s,\n", "create_date");
		System.out.printf("\t\t\t%s,\n", "update_by");
		System.out.printf("\t\t\t%s,\n", "update_date");
		System.out.printf("\t\t\t%s\n", "del_flag");
		System.out.printf("\t\t) VALUES (\n");
		System.out.printf("\t\t\t#{%s},\n", "id");
		for (int i = 0; i < FIELD.size(); i++) {
			String[] fs2 = FIELD.get(i);
			System.out.printf("\t\t\t#{%s},\n", fs2[1]);
		}
		System.out.printf("\t\t\t#{%s},\n", "createBy.id");
		System.out.printf("\t\t\t#{%s},\n", "createDate");
		System.out.printf("\t\t\t#{%s},\n", "updateBy.id");
		System.out.printf("\t\t\t#{%s},\n", "updateDate");
		System.out.printf("\t\t\t#{%s}\n", "delFlag");
		System.out.printf("\t\t)\n\t</insert>\n\n");
	}

	private static void daoUpdate() {
		System.out.printf("\t<update id=\"update\">\n");
		System.out.printf("\t\tUPDATE %s SET\n", CN3);
		for (int i = 0; i < FIELD.size(); i++) {
			String[] fs = FIELD.get(i);
			System.out.printf("\t\t\t%s = #{%s},\n", fs[2], fs[1]);
		}
		System.out.printf("\t\t\t%s = #{%s},\n", "update_by", "updateBy.id");
		System.out.printf("\t\t\t%s = #{%s}\n", "update_date", "updateDate");
		System.out.printf("\t\tWHERE id = #{id}\n\t</update>\n\n");
	}

	private static void daoDelete() {
		System.out.printf("\t<update id=\"delete\">\r\n" + 
				"\t\tUPDATE %s SET\r\n" + 
				"\t\t\tdel_flag = #{DEL_FLAG_DELETE},\r\n" +
				"\t\t\tupdate_by = #{updateBy.id},\r\n" +
				"\t\t\tdel_flag = #{DEL_FLAG_DELETE},\r\n" +
				"\t\tWHERE id = #{id}\r\n" + 
				"\t</update>\n\n", CN3);
	}
	
	private static void daoGetNextId() {
		System.out.printf("\t<select id=\"getNextId\" resultType=\"String\">\r\n" + 
				"\t\tselect seq+1 from sqlite_sequence where name='%s'\r\n" + 
				"\t</select>\n\n", CN3);
	}
}
