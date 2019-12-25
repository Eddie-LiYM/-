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
		
		// ����Ո�󅢔�
		String cmd = req.getParameter("cmd");
		
		if("login".equals(cmd)) {
			//System.out.println("�յ���¼������, �M�е�䛲���...");
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
	 * �����������������ע�Ṧ��
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���Ȼ�ȡ��ǰ̨ҳ�洫�ݵ�����
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		double salary = Double.parseDouble(req.getParameter("salary"));
		/**
		 * ���������ж��ǳ��Ƿ��Ѿ���ʹ��, �����ʹ��, ������ע��.
		 */
		// ��ȡ���������
		IEmpService service = new EmpService();

		// �����ж��û����Ƿ���ڵķ���.
		// 1��ʾ����, ��1��ʾ������
		int flag = service.findEmpByNickname(nickname);

		if (flag == 1) {
			// ����ʾ��Ϣ���뵽��������
			req.setAttribute("nicknameMsg", "���ǳ��Ѵ���, �뻻һ���ǳƣ�");
			// ����ת��
			req.getRequestDispatcher("/register.jsp").forward(req, resp);

			return;
		}else {
				// �����е����ݷ�װ��ʵ�������
				Emp emp = new Emp(1, nickname, password, gender, salary);

				// ����ע��ķ���
				service.registerEmp(emp);

				resp.getWriter().write("ע��ɹ�, 2s����ת����¼ҳ��");

				resp.setHeader("refresh", "2;url=/csi/login.jsp");
		}

	}
	
	
	/**
	 * ����ר�����ڴ����¼���ܵķ���
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		/**
		 * ˼·��1.��ȡ���û�������ǳƺ�����
		 *       2.Ȼ��ȥ�����ݿ��еıȶԣ��Ƿ������ж�Ӧ�ǳƺ��������
		 *       3.��������������¼
		 *       4.���������������û����˺Ż�����������������µ�¼�����ߵ����ע�᡿��
		 */
		//1.��ȡ���û�������ǳƺ�����
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		System.out.println(nickname);
		System.out.println(password);
		
		//2.Ȼ��ȥ�����ݿ��еıȶԣ��Ƿ������ж�Ӧ�ǳƺ��������
		IEmpService service=new EmpService();
		Emp emp=service.findEmpByNicknameAndPassword(nickname, password);
		if(emp!=null) {
			//resp.getWriter().write("��¼�ɹ�����ӭ"+emp);
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			return;
		}
		else{
			resp.getWriter().write("�˺Ż���������������¼��");
		}
	}
}
