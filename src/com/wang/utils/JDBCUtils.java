package com.wang.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBCUtils��װ���õ�JDBC����
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class JDBCUtils {
	/**
	 * ��SQL������ò���
	 * @param preparedStatement
	 * @param params
	 */
	public static void handleParams(PreparedStatement preparedStatement,Object[] params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				try {
					preparedStatement.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
