package com.wang.bean;

/**
 * ��װ�����ļ�(xml)��Ϣ
 * 
 * @author wangQ
 *
 * @date 2020-8-7
 */
public class Configuration {

	/**
	 * ����ʹ�õ����ݿ�
	 */
	private String usingDB;
	/**
	 * ������
	 */
	private String classname;
	/**
	 * JDBC��url
	 */
	private String url;
	/**
	 * ���ݿ��û���
	 */
	private String user;
	/**
	 * ���ݿ�����
	 */
	private String password;
	/**
	 * ��Ŀ��Դ��·�� 
	 */
	private String src_path;
	/**
	 * ɨ������Java��İ���po��Persistence object �־û�����
	 */
	private String po_package;

	public Configuration() {
		super();
	}

	public Configuration(String usingDB, String classname, String url, String user, String password, String src_path,
			String po_package) {
		super();
		this.usingDB = usingDB;
		this.classname = classname;
		this.url = url;
		this.user = user;
		this.password = password;
		this.src_path = src_path;
		this.po_package = po_package;
	}

	public String getUsingDB() {
		return usingDB;
	}

	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSrc_path() {
		return src_path;
	}

	public void setSrc_path(String src_path) {
		this.src_path = src_path;
	}

	public String getPo_package() {
		return po_package;
	}

	public void setPo_package(String po_package) {
		this.po_package = po_package;
	}

}
