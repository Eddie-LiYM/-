package com.lqq.ems.dao;

import com.lqq.ems.pojo.Emp;

public interface IEmpDao {

	/**
	 * ͨ���ǳƺ��������emp����
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpByNicknameAndPassword(String nickname,String password);
	
	/**
	 * �����ǳ��ж��û��Ƿ����
	 * 
	 * @param nickname
	 * @return
	 */
	int findEmpByNickname(String nickname);
	
	/**
	 * ע��Ա����Ϣ
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);
}
