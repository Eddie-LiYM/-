package com.lqq.ems.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * �������ݿ�Ĺ�����
 *
 */
public class MyDBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//���ڴ洢db.properties�ļ������ݵļ���
	private static Properties properties=new Properties();
	/**˽�й��췽��*/
	private MyDBUtils() {}
	static {
		try {
		    //���ȶ�ȡdb.properties�ļ�
		    InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            
		    //�Ѷ�ȡ��db.properties�ļ��е����ݼ��뵽Properties������
			properties.load(is);
			
			//�Ѷ�ȡ�����ݸ�ֵ��������
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			
			//ע������
			Class.forName(driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �÷�����ȡ�������ݿ�����Ӷ���
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
