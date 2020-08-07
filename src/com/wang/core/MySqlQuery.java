package com.wang.core;

import java.lang.reflect.Method;
import java.util.List;

import com.wang.bean.ColumnInfo;
import com.wang.bean.TableInfo;
import com.wang.utils.ReflectUtils;
import com.wang.utils.StringUtils;

/**
 * �������MySql���ݿ�Ĳ�ѯ
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
@SuppressWarnings("all")
public class MySqlQuery implements Query {

	@Override
	public int excuteDML(String sql, Object[] params) {

		return 0;
	}

	@Override
	public void insert(Object object) {

	}

	@Override
	public int delete(Class cls, Object id) {
		// ����class�����idֵɾ����Ӧ���е����� Emp.class,2-->delete from emp where id = 2;

		// ͨ��Class�����ҵ�TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(cls);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();// ����
		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + " = ?";

		return excuteDML(sql, new Object[] { id });
	}

	@Override
	public int delete(Object object) {
		Class cls = object.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(cls);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();// ����
		//ͨ��������ƻ�ȡ����ֵ
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), object);
		return delete(cls,priKeyValue);
		
	}

	@Override
	public int update(Object object, String[] fieldNames) {

		return 0;
	}

	@Override
	public List queryRows(String sql, Class clas, Object[] params) {

		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clas, Object[] params) {

		return null;
	}

	@Override
	public Object queryValue(String sql, Object[] params) {

		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {

		return null;
	}

}
