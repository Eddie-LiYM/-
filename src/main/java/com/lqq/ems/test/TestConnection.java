package com.lqq.ems.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lqq.ems.utils.MyDBUtils;

public class TestConnection {
  public static void main(String[]arg) throws SQLException {
	  Connection con=MyDBUtils.getConnection();
	  System.out.println(con);
	  /*Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from emp");
	     while (rs.next()) {
	        System.out.println(rs.getString("nickname"));
	     }*/
  }
}
