package com.wang.bean;

import java.util.List;
import java.util.Map;

/**
 * --��װһ�ű�ṹ����Ϣ
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class TableInfo {

	/**
	 * ����
	 */
	private String tname;
	/**
	 * �����ֶ���Ϣ
	 */
	private Map<String, ColumnInfo> columns;
	/**
	 * Ψһ������Ŀǰֻ֧�ֵ�һ������
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 	�洢��������
	 */
	private List<ColumnInfo> priKeys;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public TableInfo() {
		super();
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}

}
