package com.wang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wang.resources.Resources;

/**
 * JDBCUtils��װ���õ�JDBC����
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class JDBCUtils {
	// ��ȡ����
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// ����������
			Class.forName(Resources.getCalssname());
			// ��������
			connection = DriverManager.getConnection(Resources.getUrl(), Resources.getUser(), Resources.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// �رշ���
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
