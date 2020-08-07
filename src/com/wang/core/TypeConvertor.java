package com.wang.core;

/**
 * --����java�������ͺ����ݿ��������͵Ļ���ת��
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public interface TypeConvertor {

	/**
	 * 	�����ݿ���������ת��ΪJava��������
	 * @param columnType ���ݿ���������
	 * @return Java��������
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * 	��Java��������ת��Ϊ���ݿ���������
	 * @param javaDataType Java��������
	 * @return ���ݿ���������
	 */
	public String JavaType2databaseType(String javaDataType);
}
