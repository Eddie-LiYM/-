package com.lqq.ems.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * 连接数据库的工具类
 *
 */
public class MyDBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//用于存储db.properties文件中数据的集合
	private static Properties properties=new Properties();
	/**私有构造方法*/
	private MyDBUtils() {}
	static {
		try {
		    //首先读取db.properties文件
		    InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            
		    //把读取到db.properties文件中的数据加入到Properties集合中
			properties.load(is);
			
			//把读取的数据赋值到程序中
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			
			//注册驱动
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
	 * 该方法获取到到数据库的连接对象
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
