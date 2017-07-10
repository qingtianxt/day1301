package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService4DB;


/**
 * ת��
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		// 1.������������

		String fromuser = request.getParameter("fromuser");
		String touser = request.getParameter("touser");
		String money = request.getParameter("money");
		// 2.����accountservice.account(fromuser,touser,money);
		try {
//			ʹ��threadlocal����
//			new AccountService4tl().account(fromuser, touser, money);
			// 3.��ӡ��Ϣ
			new AccountService4DB().account(fromuser, touser, money);
			w.print("ת�˳ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			w.print("ת��ʧ��");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
