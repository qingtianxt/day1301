package service;

import java.sql.Connection;

import dao.AccountDao;
import utils.JdbcUtils;

public class AccountService {

	/**
	 * ת��
	 * @param fromuser ת����
	 * @param touser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			//1.ת��
			dao.accountout(conn,fromuser,money);
			int i=1/0;
			//2.ת��
			dao.accountin(conn,touser,money);
			//3.�����ύ
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
			//����ع�
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
	
		
	}

}
