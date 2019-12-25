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
				//�Ͽ����ӣ��ͷ���Դ
			    con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {

		//1.��ȡ�����ӵ����ݿ�Ķ���
		Connection con=MyDBUtils.getConnection();
		String sql="select * from emp where nickname=? and password=?";
		
		try {
		    //2.��ȡ��ִ��sql����Ԥ�������
		    PreparedStatement pre=con.prepareStatement(sql);
		    
		    //3.��sql�е�ռλ����������ֵ
		    pre.setString(1, nickname);
		    pre.setString(2, password);
		    
		    //4.ִ��sql���
		    ResultSet rs=pre.executeQuery();
		    
		    //5.�����ֵ�����װ��Ȼ�󷵻�
		    while(rs.next()) {
		    	//��ȡ���ݿ��ж�Ӧ������ֵ
		    	int id=rs.getInt("id");
		    	String gender=rs.getString("gender");
		    	double salary=rs.getDouble("salary");
		    	
		    	//�����ݸ��µ�������
		    	Emp emp=new Emp(id,nickname,password,gender,salary);
		    	return emp;
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//�Ͽ����ӣ��ͷ���Դ
			    con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int findEmpByNickname(String nickname) {
		
		String sql = "select * from emp where nickname=?";
		// 1. ��ȡ���������ݿ�Ķ���
		Connection con = MyDBUtils.getConnection();
		try {
		    //2.��ȡ��ִ��sql����Ԥ�������
		    PreparedStatement pre=con.prepareStatement(sql);
		    
		    //3.��sql�е�ռλ����������ֵ
		    pre.setString(1, nickname);
		    
		    //4.ִ��sql���
		    ResultSet rs=pre.executeQuery();
		    
		    //5.�����ֵ�����װ��Ȼ�󷵻�
		    while(rs.next()) {
		    	//��ȡ���ݿ��ж�Ӧ������ֵ
		    	//int id=rs.getInt("id");
		    	//String gender=rs.getString("gender");
		    	//double salary=rs.getDouble("salary");
		    	
		    	//�����ݸ��µ�������
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
			// ��ȡ��ִ��sql�Ķ���
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			// ��ռλ����ֵ
			prepareStatement.setString(1, emp.getNickname());
			prepareStatement.setString(2, emp.getPassword());
			prepareStatement.setString(3, emp.getGender());
			prepareStatement.setDouble(4, emp.getSalary());

			// ִ�� ��, ɾ, ��, ����ʹ��executeUpdate()����
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
