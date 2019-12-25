package com.lqq.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lqq.ems.pojo.Emp;
import com.lqq.ems.utils.MyDBUtils;

public class EmpDao implements IEmpDao {
	
	public List<Emp> list(){
		String sql="select * from emp";
		List<Emp> list=new ArrayList<>();
		Connection con=MyDBUtils.getConnection();
		try {
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String nickname=rs.getString("nickname");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				double salary=rs.getDouble("salary");
				Emp emp=new Emp(id,nickname,password,gender,salary);
				list.add(emp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//断开连接，释放资源
			    con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {

		//1.获取到连接到数据库的对象
		Connection con=MyDBUtils.getConnection();
		String sql="select * from emp where nickname=? and password=?";
		
		try {
		    //2.获取到执行sql语句的预编译对象
		    PreparedStatement pre=con.prepareStatement(sql);
		    
		    //3.给sql中的占位符【？】赋值
		    pre.setString(1, nickname);
		    pre.setString(2, password);
		    
		    //4.执行sql语句
		    ResultSet rs=pre.executeQuery();
		    
		    //5.如果有值，则封装，然后返回
		    while(rs.next()) {
		    	//获取数据库中对应的数据值
		    	int id=rs.getInt("id");
		    	String gender=rs.getString("gender");
		    	double salary=rs.getDouble("salary");
		    	
		    	//把数据更新到对象中
		    	Emp emp=new Emp(id,nickname,password,gender,salary);
		    	return emp;
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//断开连接，释放资源
			    con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int findEmpByNickname(String nickname) {
		
		String sql = "select * from emp where nickname=?";
		// 1. 获取到链接数据库的对象
		Connection con = MyDBUtils.getConnection();
		try {
		    //2.获取到执行sql语句的预编译对象
		    PreparedStatement pre=con.prepareStatement(sql);
		    
		    //3.给sql中的占位符【？】赋值
		    pre.setString(1, nickname);
		    
		    //4.执行sql语句
		    ResultSet rs=pre.executeQuery();
		    
		    //5.如果有值，则封装，然后返回
		    while(rs.next()) {
		    	//获取数据库中对应的数据值
		    	//int id=rs.getInt("id");
		    	//String gender=rs.getString("gender");
		    	//double salary=rs.getDouble("salary");
		    	
		    	//把数据更新到对象中
		    	//Emp emp=new Emp(id,nickname,password,gender,salary);
		    	//System.out.println(emp);
		    	return 1;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			    con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public void registerEmp(Emp emp) {
		String sql = "insert into emp values(null, ?, ?, ?, ?)";

		Connection connection = MyDBUtils.getConnection();

		try {
			// 获取到执行sql的对象
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			// 给占位符赋值
			prepareStatement.setString(1, emp.getNickname());
			prepareStatement.setString(2, emp.getPassword());
			prepareStatement.setString(3, emp.getGender());
			prepareStatement.setDouble(4, emp.getSalary());

			// 执行 增, 删, 改, 都是使用executeUpdate()方法
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
