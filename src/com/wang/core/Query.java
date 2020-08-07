package com.wang.core;

import java.util.List;

/**
 * Query�ӿڣ������ѯ�������ṩ����ĺ����ࣩ
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */

@SuppressWarnings("all")
public interface Query {
	
	/**
	 * 	ֱ��ִ��һ��DML���
	 * @param sql sql���
	 * @param params ��Ӧ����
	 * @return ִ�����Ӱ��ļ�¼����
	 */
	public int excuteDML(String sql,Object[] params);
	
	/**
	 * 	������洢�����ݿ���
	 * @param object Ҫ�洢�Ķ���
	 */
	public void insert(Object object);
	
	/**
	 * 	ɾ��cls��ʾ���Ӧ�ı��еļ�¼��ָ������id��ֵ��
	 * @param cls �����Ӧ�����Class����
	 * @param id ����ֵ
	 * @return ִ�����Ӱ��ļ�¼����
	 */
	public int delete(Class cls,Object id);//delete from cls where id = id;
	
	/**
	 * 	ɾ�����������ݿ��ж�Ӧ�ļ�¼�����Ӧ��������ֵ��Ӧ����¼��
	 * @param object
	 * @return ִ�����Ӱ��ļ�¼����
	 */
	public int delete(Object object);
	
	/**
	 *	 ���¶����Ӧ�ļ�¼��ֻ���¶�Ӧ���ֶ�ֵ
	 * @param object Ҫ���µĶ���
	 * @param fieldNames ��Ҫ���µ������б�
	 * @return ִ�����Ӱ��ļ�¼����
	 */
	public int update(Object object,String[] fieldNames);
	
	/**
	 * 	��ѯ���ض��м�¼������ÿ�м�¼��װ��clasָ������Ķ�����
	 * @param sql sql���
	 * @param clas ��װ���ݵ�JavaBean���Class����
	 * @param params ��Ӧ����
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql,Class clas,Object[] params);
	
	/**
	 * 	��ѯ����һ�м�¼��������¼��װ��clasָ������Ķ�����
	 * @param sql sql���
	 * @param clas ��װ���ݵ�JavaBean���Class����
	 * @param params ��Ӧ����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql,Class clas,Object[] params);
	
	/**
	 * 	��ѯ����һ��ֵ��һ��һ�У���������ֵ����
	 * @param sql sql���
	 * @param params ��Ӧ����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql,Object[] params);
	
	/**
	 * 	��ѯ����һ��ֵ��һ��һ�У���������ֵ����
	 * @param sql sql���
	 * @param params ��Ӧ����
	 * @return ��ѯ��������(int,double,float,byte,long)
	 */
	public Number queryNumber(String sql,Object[] params);
	
}
