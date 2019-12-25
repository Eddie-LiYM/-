package com.lqq.ems.service;

import com.lqq.ems.pojo.Emp;
/**
 * 服务接口
 * @author 37568
 *
 */
public interface IEmpService {
	/**
	 * 通过昵称和密码查找emp对象
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpByNicknameAndPassword(String nickname,String password);
	
	/**
	 * 根据昵称判断用户是否存在
	 * 
	 * @param nickname
	 * @return
	 */
	int findEmpByNickname(String nickname);

	/**
	 * 注册员工信息
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);

}
