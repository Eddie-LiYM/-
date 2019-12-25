package com.lqq.ems.service;

import com.lqq.ems.pojo.Emp;
/**
 * ����ӿ�
 * @author 37568
 *
 */
public interface IEmpService {
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
