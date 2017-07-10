package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService4DB;


/**
 * 转账
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		// 1.接收三个参数

		String fromuser = request.getParameter("fromuser");
		String touser = request.getParameter("touser");
		String money = request.getParameter("money");
		// 2.调用accountservice.account(fromuser,touser,money);
		try {
//			使用threadlocal方法
//			new AccountService4tl().account(fromuser, touser, money);
			// 3.打印信息
			new AccountService4DB().account(fromuser, touser, money);
			w.print("转账成功");
		} catch (Exception e) {
			e.printStackTrace();
			w.print("转账失败");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
