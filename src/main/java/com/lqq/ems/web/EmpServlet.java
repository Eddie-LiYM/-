package com.lqq.ems.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lqq.ems.pojo.Emp;
import com.lqq.ems.service.EmpService;
import com.lqq.ems.service.IEmpService;
import com.lqq.ems.utils.MyDBUtils;

@WebServlet("/EmpServlet")
@SuppressWarnings("serial")
public class EmpServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 接收請求參數
		String cmd = req.getParameter("cmd");
		
		if("login".equals(cmd)) {
			//System.out.println("收到登录的命令, 進行登錄操作...");
			login(req,resp);
		} else if ("register".equals(cmd)) {
			register(req, resp);
		}else if("list".equals(cmd)) {
			list(req,resp);
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//IEmpService service = new EmpService();
		
	}

	/**
	 * 这个方法是用来进行注册功能
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 首先获取到前台页面传递的数据
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		double salary = Double.parseDouble(req.getParameter("salary"));
		/**
		 * 可以首先判断昵称是否已经被使用, 如果被使用, 则不允许注册.
		 */
		// 获取到服务对象
		IEmpService service = new EmpService();

		// 调用判断用户名是否存在的方法.
		// 1表示存在, 非1表示不存在
		int flag = service.findEmpByNickname(nickname);

		if (flag == 1) {
			// 把提示信息放入到请求域中
			req.setAttribute("nicknameMsg", "该昵称已存在, 请换一个昵称！");
			// 请求转发
			req.getRequestDispatcher("/register.jsp").forward(req, resp);

			return;
		}else {
				// 把所有的数据封装到实体对象中
				Emp emp = new Emp(1, nickname, password, gender, salary);

				// 调用注册的方法
				service.registerEmp(emp);

				resp.getWriter().write("注册成功, 2s后跳转到登录页面");

				resp.setHeader("refresh", "2;url=/csi/login.jsp");
		}

	}
	
	
	/**
	 * 这是专门用于处理登录功能的方法
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/**
		 * 思路：1.获取到用户输入的昵称和密码
		 *       2.然后去与数据库中的比对，是否正好有对应昵称和密码存在
		 *       3.如果存在则允许登录
		 *       4.如果不存在则告诉用户【账号或密码有误，请检查后重新登录，或者点击【注册】】
		 */
		//1.获取到用户输入的昵称和密码
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		System.out.println(nickname);
		System.out.println(password);
		
		//2.然后去与数据库中的比对，是否正好有对应昵称和密码存在
		IEmpService service=new EmpService();
		Emp emp=service.findEmpByNicknameAndPassword(nickname, password);
		if(emp!=null) {
			//resp.getWriter().write("登录成功，欢迎"+emp);
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			return;
		}
		else{
			resp.getWriter().write("账号或密码有误，请检查后登录！");
		}
	}
}
