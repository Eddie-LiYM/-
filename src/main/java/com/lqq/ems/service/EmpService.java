package com.lqq.ems.service;

import com.lqq.ems.dao.EmpDao;
import com.lqq.ems.dao.IEmpDao;
import com.lqq.ems.pojo.Emp;
/**
 * 服务接口的实现类
 * @author 37568
 *
 */
public class EmpService implements IEmpService {
	

	private IEmpDao empDao=new EmpDao();
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {
		// TODO Auto-generated method stub
		//获取到专门处理持久层方面的对象
		
		//调用dao中的方法
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}

	public int findEmpByNickname(String nickname) {
		return empDao.findEmpByNickname(nickname);
	}
	public void registerEmp(Emp emp) {
		empDao.registerEmp(emp);
	}

}
