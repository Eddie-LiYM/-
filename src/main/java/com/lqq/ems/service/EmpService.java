package com.lqq.ems.service;

import com.lqq.ems.dao.EmpDao;
import com.lqq.ems.dao.IEmpDao;
import com.lqq.ems.pojo.Emp;
/**
 * ����ӿڵ�ʵ����
 * @author 37568
 *
 */
public class EmpService implements IEmpService {
	

	private IEmpDao empDao=new EmpDao();
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {
		// TODO Auto-generated method stub
		//��ȡ��ר�Ŵ���־ò㷽��Ķ���
		
		//����dao�еķ���
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}

	public int findEmpByNickname(String nickname) {
		return empDao.findEmpByNickname(nickname);
	}
	public void registerEmp(Emp emp) {
		empDao.registerEmp(emp);
	}

}
