package csi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")

public class HelloServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������ı���
		request.setCharacterEncoding("utf-8");
		
		//���߿ͻ�����ν������������͵ķ�������Ӧ��
		response.setContentType("text/html;charset=utf-8");
		
		//���������е�name����
		String name=request.getParameter("name");
		System.out.println(name);
		
		//��������ͻ��˷�����Ӧ��Ϣ
		response.getWriter().write("�ͻ��ˣ���ã�");
	}
}
