package com.lqq.ems.pojo;

import java.io.Serializable;

/**
 *  µÃÂ¿‡
 * @author 37568
 *
 */
@SuppressWarnings("serial")
public class Emp implements Serializable{
	private Integer id;
	private String nickname;
	private String password;
	private String gender;
	private double salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", nickname=" + nickname + ", password=" + password + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Integer id, String nickname, String password, String gender, double salary) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.gender = gender;
		this.salary = salary;
	}
}
