package com.wang.utils;

/**
 * StringUtils��װ���õ��ַ�������
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class StringUtils {
	/**
	 * ��Ŀ���ַ�������ĸ��д
	 * 
	 * @param str Ŀ���ַ���
	 * @return ����ĸ��д���ַ���
	 */
	public static String firstChar2UpperCase(String str) {

		return str.toUpperCase().substring(0, 1) + str.substring(1);
	}
}
