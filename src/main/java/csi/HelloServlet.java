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
		//设置请求的编码
		request.setCharacterEncoding("utf-8");
		
		//告诉客户端如何解析服务器发送的反馈（响应）
		response.setContentType("text/html;charset=utf-8");
		
		//接受请求中的name参数
		String name=request.getParameter("name");
		System.out.println(name);
		
		//服务器向客户端发送响应信息
		response.getWriter().write("客户端，你好！");
	}
}
