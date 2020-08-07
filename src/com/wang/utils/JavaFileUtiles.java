package com.wang.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;
import javax.swing.text.TabableView;

import com.wang.bean.ColumnInfo;
import com.wang.bean.JavaFieldGetSet;
import com.wang.bean.TableInfo;
import com.wang.core.DBManager;
import com.wang.core.MysqlTypeConvertor;
import com.wang.core.TableContext;
import com.wang.core.TypeConvertor;

/**
 * JavaFileUtiles��װjava�ļ�(Դ����)����
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class JavaFileUtiles {

	/**
	 * �����ֶ���Ϣ����java������Ϣ���磺varchar name -->private String name;�Լ���Ӧ��set/get����
	 * 
	 * @param columnInfo    �ֶ���Ϣ
	 * @param typeConvertor ����ת����
	 * @return java���Ե�set/get����Դ��
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo columnInfo, TypeConvertor typeConvertor) {
		JavaFieldGetSet jfgSet = new JavaFieldGetSet();

		String javaFieldType = typeConvertor.databaseType2JavaType(columnInfo.getDataType());
		// private String username;
		jfgSet.setFieldInfo("\tprivate " + javaFieldType + " " + columnInfo.getName() + ";\n");

		// public String getUsername(){return username;}
		StringBuilder getSrc = new StringBuilder();
		getSrc.append(
				"\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(columnInfo.getName()) + "(){\n");
		getSrc.append("\t\treturn " + columnInfo.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgSet.setGetInfo(getSrc.toString());

		// public void setUsername(String username){this.username = username;}
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(columnInfo.getName()) + "(");
		setSrc.append(javaFieldType + " " + columnInfo.getName() + "){\n");
		setSrc.append("\t\tthis." + columnInfo.getName() + " = " + columnInfo.getName() + ";\n");
		setSrc.append("\t}\n");
		jfgSet.setSetInfo(setSrc.toString());

		return jfgSet;
	}

	/**
	 * ���ݱ���Ϣ����java��
	 * 
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת����
	 * @return java���Դ��
	 */
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {

		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaField = new ArrayList<JavaFieldGetSet>();

		for (ColumnInfo c : columns.values()) {
			javaField.add(createFieldGetSetSRC(c, convertor));
		}

		StringBuilder src = new StringBuilder();

		// ����package���
		src.append("package " + DBManager.getConf().getPo_package() + ";\n\n");
		// ����import���
		src.equals("import java.sql.*;\n");
		src.equals("import java.util.*;\n\n");
		// �������������
		src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + "{\n\n");
		// ���������б�
		for (JavaFieldGetSet f : javaField) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		// ����get�����б�
		for (JavaFieldGetSet f : javaField) {
			src.append(f.getGetInfo());
		}
		// ����set�����б�
		for (JavaFieldGetSet f : javaField) {
			src.append(f.getSetInfo());
		}
		// ���������
		src.append("}\n");

		return src.toString();
	}

	/**
	 * ����java�ļ�����Ӧ�İ���
	 * 
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת����
	 */
	public static void createJavaPoFile(TableInfo tableInfo, TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo, convertor);

		String srcPath = DBManager.getConf().getSrc_path() + "/";
		String srcPackage = DBManager.getConf().getPo_package().replace(".", "/");
		// java�ļ���
		String srcFile = "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java";

		File f = new File(srcPath + srcPackage);

		if (!f.exists()) {
			f.mkdirs();// Ŀ¼�����ھ��½�
		}
		BufferedWriter bw = null;
		try {
			f = new File(f.getAbsolutePath() + srcFile);
			if (!f.exists()) {
				f.createNewFile();// �ļ������ھ��½�
			}
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(src);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
